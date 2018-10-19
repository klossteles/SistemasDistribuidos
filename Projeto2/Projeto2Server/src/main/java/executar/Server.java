/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import PassagemAerea.PassagemAerea;
import hospedagem.Hospedagem;
import interfaces.ClientInterface;
import interfaces.ServerInterface;
import pacotes.Pacote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Brendon & Lucas
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

    private final ConcurrentHashMap<ClientInterface, JSONArray> interesses;
    private final PassagemAerea passagens;
    private final Hospedagem hospedagens;
    private final Pacote pacotes;

    public Server() throws RemoteException{
        this.passagens = new PassagemAerea();
        this.hospedagens = new Hospedagem();
        this.pacotes = new Pacote(this.passagens, this.hospedagens);
        this.interesses = new ConcurrentHashMap<>();
    }

    public PassagemAerea getPassagens(){
        return passagens;
    }

    public Hospedagem getHospedagens(){
        return hospedagens;
    }

    public Pacote getPacotes(){
        return pacotes;
    }

    @Override
    public String consultarPassagens() throws RemoteException{
        return passagens.consultarPassagens();
    }

    @Override
    public String consultarHospedagens() throws RemoteException{
        return hospedagens.consultarHospedagem();
    }

    @Override
    public String consultarPacotes() throws RemoteException{
        return pacotes.consultarPacotes();
    }

    @Override
    public String consultarRegistrosInteresse(ClientInterface clientRef) throws RemoteException{
        if(!this.interesses.containsKey(clientRef)){
            return "VAZIO";
        }

        StringBuilder registros = new StringBuilder();
        registros.append(System.lineSeparator());

        JSONArray array = this.interesses.get(clientRef);
        for(int indice = 0; indice < array.length(); indice++){
            JSONObject registro = array.getJSONObject(indice);

            registros.append(System.lineSeparator())
                     .append("Identificador do Registro: ").append(registro.getLong("ID"))              .append(System.lineSeparator())
                     .append("Tipo de Registro: ")         .append(registro.getString("TIPO_INTERESSE")).append(System.lineSeparator())
                     .append("Destino: ")                  .append(registro.getString("DESTINO"))       .append(System.lineSeparator())
                     .append("Preço Máximo: ")             .append(registro.getDouble("PRECO"))         .append(System.lineSeparator());
        }

        return registros.toString();
    }

    @Override
    public boolean registrarInteresse(String dados, ClientInterface clientRef) throws RemoteException{
        JSONObject dadosInteresse = new JSONObject(dados);
        
        if(this.interesses.containsKey(clientRef)){//Se esse cliente já cadastrou interesse antes.
            this.interesses.get(clientRef).put(dadosInteresse);//Acrescenta o novo interesse            
        } else{//Se o cliente ainda não havia solicitado registro de interesse.
            JSONArray array = new JSONArray();
            array.put(dadosInteresse);

            this.interesses.put(clientRef, array);
        }

        clientRef.notificarEvento("Registro de interesse cadastrado.");
        return true;
    }

    @Override
    public boolean removerInteresse(Long idRegistroInteresse, ClientInterface clientRef) throws RemoteException{
        if(this.interesses.containsKey(clientRef)){
            JSONArray interessesCliente = this.interesses.get(clientRef);
            boolean registroNaoFoiEncontrado = true;
            
            //Itera e remove o elemento de interesse.
            for(int indice = 0; indice < interessesCliente.length(); indice++){
                long idRegistroLocal = interessesCliente.getJSONObject(indice).getLong("ID");
                if(idRegistroLocal == idRegistroInteresse){
                    interessesCliente.remove(indice);
                    clientRef.notificarEvento("Registro de interesse removido.");
                    registroNaoFoiEncontrado = false;
                    break;
                }
            }
            
            //Se o id de registro fornecido não existe na lista de interesses do cliente.
            if(registroNaoFoiEncontrado){
                clientRef.notificarEvento("Não foi encontrado nenhum registro de interesse com o identificador fornecido.");
            }
            
            //Se não há mais interesses desse cliente cadastrados, o server remove
            //a referência desse cliente.
            if(interessesCliente.isEmpty()){
                this.interesses.remove(clientRef);
            }
            
            return true;

        } else{
            clientRef.notificarEvento("O cliente informado não possui um registro de interesse com o identificador fornecido.");
            return false;
        }
    }

    /**
     * Percorre os registros de interesse e compara com o novo registro que é 
     * recebido por parâmetro. Se os atributos de DESTINO e PRECO foram iguais, notifica
     * o cliente correspondente, informando que existe um registro que corresponde
     * com o interesse anteriormente cadastrado.
     *
     * @param TIPO_INTERESSE [Obrigatório] - Define se o novo registro é PASSAGEM, HOSPEDAGEM ou PACOTE.
     * @param NOVO_REGISTRO [Obrigatório] - O novo registro que será comparado com os
     * registros de interesse.
     */
    public void notificarClientesInteresse(final String TIPO_INTERESSE, final JSONObject NOVO_REGISTRO){
        ClientInterface client;
        JSONObject dadosInteresses;

        //Iteração para TODOS os clientes
        for(Map.Entry<ClientInterface, JSONArray> registros : this.interesses.entrySet()){
            client = registros.getKey();

            //Itera na lista de interesses de um cliente específico.
            for(int indice = 0; indice < registros.getValue().length(); indice++){
                dadosInteresses = registros.getValue().getJSONObject(indice);

                if(dadosInteresses.getString("TIPO_INTERESSE").equalsIgnoreCase(TIPO_INTERESSE)){
                    if(dadosInteresses.getString("DESTINO").equalsIgnoreCase(NOVO_REGISTRO.getString("DESTINO"))){
                        if(dadosInteresses.getDouble("PRECO") >= NOVO_REGISTRO.getDouble("PRECO")){
                            StringBuilder mensagem = new StringBuilder();
                            mensagem.append(System.lineSeparator())
                                    .append("===== NOTIFICAÇÃO DE EVENTO DE INTERESSE ===")
                                    .append(System.lineSeparator())
                                    .append(String.format("Foram cadastrados registros do tipo '%s' que correspondem com um de seus interesses.", TIPO_INTERESSE))
                                    .append(System.lineSeparator())
                                    .append("DADOS DO REGISTRO:")             .append(System.lineSeparator())
                                    .append("    Identificador do Registro: ").append(dadosInteresses.getLong("ID")).append(System.lineSeparator())
                                    .append("    Tipo de Registro: ")         .append(dadosInteresses.getString("TIPO_INTERESSE")).append(System.lineSeparator())
                                    .append("    Destino: ")                  .append(dadosInteresses.getString("DESTINO")).append(System.lineSeparator())
                                    .append("    Preço: ")                    .append(dadosInteresses.getDouble("PRECO"));
                            
                            try {
                                client.notificarEvento(mensagem.toString());
                            } catch(RemoteException ex) {
                                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "Falha ao notificar cliente", ex);
                            }
                        }
                    }
                }
            }

        }
    }

    @Override
    public boolean comprarPassagem(Long identificador) throws RemoteException{
        return passagens.comprarPassagem(identificador);
    }

    @Override
    public boolean comprarHospedagem(Long identificador) throws RemoteException{
        return hospedagens.comprarHospedagem(identificador);
    }

    @Override
    public boolean comprarPacote(Long id) throws RemoteException{
        return pacotes.comprarPacote(id);
    }
}
