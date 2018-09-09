/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processos;

import constantes.MessageType;
import criptografia.RSA;
import executar.Main;
import java.io.IOException;
import java.net.DatagramPacket;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import recursos.Recurso;

/**
 *
 * @author Brendon
 */
public class Mensagem {

    /**
     * Envia um DatagramPacket anunciando a entrada ou saída do atual processo
     * no grupo multicast em que está vinculado.
     *
     * @param type [Obrigatório] - Se GROUP_IN, representa um anúncio de entrada
     * no grupo multicast. Se GROUP_OUT, representa um anúncio de saída do grupo
     * multicast.
     * @param process
     */
    public static void announce(final MessageType type, Process process){
        try {
            for(Map.Entry<Long, JSONObject> entry : process.getProcessosConhecidos().entrySet()){
                setObteveResposta(entry.getKey(), 0, process);
            }
            DatagramPacket announcePacket = createAnnounceDatagram(type, process);
            process.getSocket().send(announcePacket);
        } catch(IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Trata um DatagramPacket advindo do anúncio de outro par. Considera que a
     * mensagem recebida NÃO está criptografada.
     *
     * <table border="1">
     * <tr>
     * <th colspan="2">Casos Considerados</th>
     * </tr>
     * <tr>
     * <th>Caso Considerado</th>
     * <th>Ação Executada</th>
     * </tr>
     * <tr>
     * <td>(Par Emissor) == (Par Receptor)</td>
     * <td>Nenhuma operação é executada</td>
     * </tr>
     * <tr>
     * <td>(Par Emissor) != (Par Receptor) &amp;&amp; TIPO_EVENTO == (Evento de
     * Entrada) &amp;&amp; Emissor ainda não é conhecido</td>
     * <td>Emissor é inserido na lista de pares conhecidos;<br>Receptor se
     * anuncia novamente;</td>
     * </tr>
     * <tr>
     * <td>(Par Emissor) != (Par Receptor) &amp;&amp; TIPO_EVENTO == (Evento de
     * Saída) &amp;&amp; Emissor é conhecido</td>
     * <td>Emissor é removido da lista de pares conhecidos</td>
     * </tr>
     * <tr>
     * <td>TIPO_EVENTO == (Evento de anúncio) &amp;&amp; Marca processo conhecido como ativo</td>
     * </tr>
     * </table>
     *
     * @param datagram [Obrigatório] - DatagramPacket contendo a mensagem
     * recebida.
     * @param process
     */
    public static void tratarMensagemRecebida(DatagramPacket datagram, Process process){
        String mensagem = new String(datagram.getData(), Main.DEFAULT_ENCODING);
        JSONObject json = new JSONObject(mensagem);
        
        Long idRecebido = json.getLong("id");
        MessageType groupEventRecebido = MessageType.getTypeByCode(json.getInt("message_type"));
        
        JSONObject js = new JSONObject(json.getString("json"));
        PublicKey publicKeyRecebida = RSA.StringToPublicKey(js.getString("key"));
        
        if(idRecebido.equals(process.getId())){
            return;
        }
        switch(groupEventRecebido) {
            case GROUP_IN:
                //Se evento de entrada, o par recebido é inserido no conjunto de pares conhecidos.
                if(!process.getProcessosConhecidos().containsKey(idRecebido)){
                    //                    processosConhecidos.putIfAbsent(idRecebido, publicKeyRecebida);
                    process.getProcessosConhecidos().putIfAbsent(idRecebido, js);
                    Mensagem.announce(MessageType.GROUP_IN, process);
                    Logger.getLogger(Process.class.getName()).log(Level.INFO, "Inseriu:{0}", idRecebido);
                }
                setObteveResposta(idRecebido, 1, process);
                break;
            case GROUP_OUT:
                //Se evento de saída, o par recebido é removido do conjunto de pares conhecidos.
                process.getProcessosConhecidos().remove(idRecebido);
                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Removeu:{0}", idRecebido);
                break;
            case RESOURCE_REQUEST:
                break;
            case RESOURCE_RELEASE:
                break;
            case ANNOUNCE:
                setObteveResposta(idRecebido, 1, process);
                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Se Anunciou:{0}", idRecebido);
                break;
        }
    }

    //TODO Está rolando uma exception de concorrencia na thread.
    //TODO Também esta rolando a perda de um dos processos da lista de conhecidos.
    public static void trataTimeOut(Process process){
        for(Map.Entry<Long, JSONObject> entry : process.getProcessosConhecidos().entrySet()){
            JSONObject jsonObject = entry.getValue();
            if(jsonObject.get("obteve_resposta").equals(0)){
                process.getProcessosConhecidos().remove(entry.getKey());
            }
        }
    }

    /**
     * Cria um objeto DatagramPacket utilizado para fazer o anúncio de um par em
     * um grupo multicast.
     *
     * @param type [Obrigatório] - Define se é um anúncio de entrada ou saída do
     * grupo multicast.
     * @param process [Obrigatório] - Processo que irá fazer o anúncio.
     *
     * @return [{@link java.net.DatagramPacket}] contendo os dados de um
     * processo que deseja entrar ou sair de um grupo multicast.
     */
    private static DatagramPacket createAnnounceDatagram(final MessageType type, Process process){
        JSONObject js = new JSONObject();
        js.put("key", RSA.publicKeyToString(process.getPublicKey()));
        js.put("obteve_resposta", 1);

        JSONObject json = new JSONObject();
        json.put("id", process.getId());
        json.put("json", js.toString());
        json.put("message_type", type.getTypeCode());

        byte[] data = json.toString().getBytes();
        return new DatagramPacket(data, data.length, process.getGroup(), Main.MULTICAST_PORT);
    }

    private static DatagramPacket createResourceDatagram(final MessageType type, Process process, Recurso resource){
        JSONObject json = new JSONObject();
        json.put("id_process", process.getId());
        json.put("request_time", Instant.now().getEpochSecond());
        json.put("id_resource", resource.getId());
        json.put("message_type", type.getTypeCode());

        byte[] data = json.toString().getBytes(Main.DEFAULT_ENCODING);
        return new DatagramPacket(data, data.length, process.getGroup(), Main.MULTICAST_PORT);
    }

    /**
     *
     * @param processId
     * @param value
     * @param process
     */
    private static void setObteveResposta(Long processId, int value, Process process){
        for(Map.Entry<Long, JSONObject> entry : process.getProcessosConhecidos().entrySet()){
            if(entry.getKey().equals(processId)){
                JSONObject jsonObject = entry.getValue();
                jsonObject.put("obteve_resposta", value);
            }
        }
    }

}
