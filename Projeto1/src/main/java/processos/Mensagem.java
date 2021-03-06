/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processos;

import static constantes.ProcessResourceState.*;
import static constantes.MessageType.*;
import static executar.Main.*;
import constantes.MessageType;
import constantes.ProcessResourceState;
import criptografia.RSA;
import java.io.IOException;
import java.net.DatagramPacket;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PublicKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import recursos.Recurso;

/**
 *
 * @author Brendon
 */
public class Mensagem {

    private static final Logger LOG = Logger.getLogger(Mensagem.class.getName());

    /**
     * Envia um DatagramPacket anunciando a entrada ou saída do atual processo
     * no grupo multicast em que está vinculado.
     *
     * @param type [Obrigatório] - Se GROUP_IN, representa um anúncio de entrada
     * no grupo multicast. Se GROUP_OUT, representa um anúncio de saída do grupo
     * multicast. Se ANNOUNCE, representa um anúncio de atualização de processos
     * do grupo multicast.
     * @param process [Obrigatório] - Processo que está fazendo o anúncio (REMETENTE).
     */
    public static void announce(final MessageType type, Process process){
        try {
            for(Map.Entry<Long, JSONObject> entry : process.getProcessosConhecidos().entrySet()){
                setObteveResposta(entry.getKey(), 0, process);
            }
            DatagramPacket announcePacket = createAnnounceDatagram(type, process);
            process.getSocket().send(announcePacket);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run(){
//                    LOG.info("Verificando quem respondeu");
                    for(Map.Entry<Long, JSONObject> entry : process.getProcessosConhecidos().entrySet()){
                        JSONObject jsonObject = entry.getValue();
                        if(jsonObject.get("obteve_resposta").equals(0)){
                            process.getProcessosConhecidos().remove(entry.getKey());
                        }
                    }
                }
            }, TIMEOUT);
        } catch(IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Envia um DatagramPacket no grupo multicast, solicitando/liberando um recurso
     * ou respondendo a requisição de recurso feita por um processo externo.
     * 
     * @param requestReleaseOkDenial [Obrigatório] - Tipo de operação que será
     * aplicada ao recurso em análise.
     * @param process [Obrigatório] - Processo que irá fazer o anúncio de recurso.
     * @param resource [Obrigatório] - Recurso que está sendo gerenciado.
     */
    public static void resource(final MessageType requestReleaseOkDenial, Process process, Recurso resource){
        try {
            DatagramPacket resourcePacket = createResourceDatagram(requestReleaseOkDenial, process, resource);
            process.getSocket().send(resourcePacket);
        } catch(IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
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
     * <td>TIPO_EVENTO == (Evento de anúncio) &amp;&amp; Marca processo
     * conhecido como ativo</td>
     * </tr>
     * </table>
     *
     * @param datagram [Obrigatório] - DatagramPacket contendo a mensagem
     * recebida.
     * @param process [Obrigatório] - O processo que está analisando a resposta
     * recebida.
     */
    public static void tratarMensagemRecebida(DatagramPacket datagram, Process process){
        String mensagem = new String(datagram.getData(), DEFAULT_ENCODING);
        JSONObject json = new JSONObject(mensagem);

        //Parte não criptografada do Datagrama.
        Long idProcessRecebido = json.getLong("id");
        MessageType groupEventRecebido = MessageType.getTypeByCode(json.getInt("message_type"));

        JSONObject js = null;
        PublicKey publicKeyRecebida = null;

        //Evita processar os pacotes do próprio remetente.
        if(idProcessRecebido.equals(process.getId())){
            return;
        }

        switch(groupEventRecebido) {
            case GROUP_IN:
                //Se evento de entrada, o par recebido é inserido no conjunto de pares conhecidos.
                js = new JSONObject(json.getString("json"));
                publicKeyRecebida = RSA.StringToPublicKey(js.getString("key"));

                if(!process.getProcessosConhecidos().containsKey(idProcessRecebido)){
                    //                    processosConhecidos.putIfAbsent(idProcessRecebido, publicKeyRecebida);
                    process.getProcessosConhecidos().putIfAbsent(idProcessRecebido, js);
                    Mensagem.announce(MessageType.GROUP_IN, process);
                    LOG.log(Level.INFO, "Inseriu:{0}", idProcessRecebido);
                }
                setObteveResposta(idProcessRecebido, 1, process);
                break;

            case GROUP_OUT:
                //Se evento de saída, o par recebido é removido do conjunto de pares conhecidos.
                process.getProcessosConhecidos().remove(idProcessRecebido);
                LOG.log(Level.INFO, "Removeu:{0}", idProcessRecebido);
                break;

            case ANNOUNCE:
                js = new JSONObject(json.getString("json"));
                publicKeyRecebida = RSA.StringToPublicKey(js.getString("key"));

                if(!process.getProcessosConhecidos().containsKey(idProcessRecebido)){
                    process.getProcessosConhecidos().putIfAbsent(idProcessRecebido, js);
//                    LOG.log(Level.INFO, "Inseriu:{0}", idProcessRecebido);
                }
                setObteveResposta(idProcessRecebido, 1, process);
//                LOG.log(Level.INFO, "Se Anunciou:{0}", idProcessRecebido);
                break;

            case RESOURCE_REQUEST:
                LOG.info(String.format("RESOURCE_REQUEST recebido de '%d'", idProcessRecebido));
                Long idResourceRequest = json.getLong("id_resource");
                Long requestTime = json.getLong("request_time");

                Recurso resourceSolicitado = process.getRecursosDisponiveis().get(idResourceRequest);
                ProcessResourceState stateLocal = resourceSolicitado.getEstadoSolicitacao();
                long requestTimeLocal = resourceSolicitado.getMomentoSolicitacao().getEpochSecond();

                if(stateLocal.equals(HELD) || (stateLocal.equals(WANTED) && requestTimeLocal < requestTime)){
                    Mensagem.resource(RESOURCE_DENIAL, process, resourceSolicitado);
                    resourceSolicitado.addProcessoSolicitante(json);
                } else{
                    Mensagem.resource(RESOURCE_OK, process, resourceSolicitado);
                }
                break;

            case RESOURCE_RELEASE:
                LOG.info(String.format("RESOURCE_RELEASE recebido de '%d'", idProcessRecebido));
                Long idResourceRelease = json.getLong("id_resource");
                Long idNextProcess = null;
                JSONArray listaEspera = null;
                if (json.has("id_next_process")) {
                    idNextProcess = json.getLong("id_next_process");
                }
                if (json.has("waiting_list")) {
                    listaEspera = json.getJSONArray("waiting_list");
                }

                Recurso resourceLiberado = process.getRecursosDisponiveis().get(idResourceRelease);

                if (idNextProcess != null && idNextProcess == process.getId()) {
                    resourceLiberado.carregarWaitingList(listaEspera);
                    resourceLiberado.alocado();
                }
                break;

            case RESOURCE_OK://O recurso solicitado está disponível.
                Long idResourceOk = json.getLong("id_resource");
                Recurso resourceOk = process.getRecursosDisponiveis().get(idResourceOk);
                resourceOk.incrementReceivedMessagesOK();
                LOG.info(String.format("RESOURCE_OK recebido de '%d'. (%d)//(%d)", idProcessRecebido, process.getProcessosConhecidosAoSolicitarRecurso(), resourceOk.getReceivedMessages()));
                
                //AUTENTICAÇÃO DE REMENTENTE
                PublicKey publicKeyOk = process.getPublicKeyFromAnotherProcess(idProcessRecebido);
                String assinaturaOk = "";
                if(publicKeyOk != null){
                    assinaturaOk = RSA.descriptografar(publicKeyOk, json.getString("assinatura"), DEFAULT_ENCODING);
                }else{
                    LOG.severe(String.format("O Remetente da mensagem '%d' não está mais Online. Não é possível autenticar. ", idProcessRecebido));
                    break;
                }
                
                if(!assinaturaOk.equals(RESOURCE_OK.name())){
                    LOG.severe(String.format("Falha de autenticação de Assinatura Digital do Processo Rementente %d", idProcessRecebido));
                    break;
                }
                
                if(process.getProcessosConhecidosAoSolicitarRecurso() == resourceOk.getReceivedMessages()){
                    if(resourceOk.getEstadoSolicitacao().equals(WANTED)){
                        resourceOk.alocado();
                        resourceOk.clearReceivedMessagesOK();
                    }
                }
                break;
                
            case RESOURCE_DENIAL://O recurso não está disponível. Acorda a thread e adiciona na lista de espera.
                Long idResourceNegado = json.getLong("id_resource");
                Recurso resourceNegado = process.getRecursosDisponiveis().get(idResourceNegado);
                resourceNegado.incrementReceivedMessagesDenial();
                LOG.info(String.format("RESOURCE_DENIAL recebido de '%d'. (%d)//(%d)", idProcessRecebido, process.getProcessosConhecidosAoSolicitarRecurso(), resourceNegado.getReceivedMessages()));
                
                //AUTENTICAÇÃO DE REMENTENTE
                PublicKey publicKeyDenial = process.getPublicKeyFromAnotherProcess(idProcessRecebido);
                String assinaturaDenial = "";
                if(publicKeyDenial != null){
                    assinaturaDenial = RSA.descriptografar(publicKeyDenial, json.getString("assinatura"), DEFAULT_ENCODING);
                }else{
                    LOG.severe(String.format("O Remetente da mensagem '%d' não está mais Online. Não é possível autenticar. ", idProcessRecebido));
                    break;
                }
                
                if(!assinaturaDenial.equals(RESOURCE_DENIAL.name())){
                    LOG.severe(String.format("Falha de autenticação de Assinatura Digital do Processo Rementente %d", idProcessRecebido));
                    break;
                }
                
                /* Se tal recurso foi solicitado por mim (WANTED), foi negado, mas
                 * estou na fila.
                 */
                if(resourceNegado.souOProximo(process)){
                    resourceNegado.clearReceivedMessagesOK();
                    LOG.info(String.format("O recurso '%d' foi negado, mas estou na fila.", idResourceNegado));
                }
                break;
        }
    }

    /**
     * Remove os processos conhecidos que não responderam.
     *
     * @param process type [Obrigatório] - Processo que serão removidos os
     * processos que não responderam
     */
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
        
//        System.out.println("========= " + json.toString());
        byte[] data = json.toString().getBytes(DEFAULT_ENCODING);
        return new DatagramPacket(data, data.length, process.getGroup(), MULTICAST_PORT);
    }

    /**
     * Cria um objeto DatagramPacket utilizado para fazer a requisição de um 
     * recurso ou responder a requisição de um recurso por outro processo.
     * 
     * @param type [Obrigatório] - Tipo de operação que será aplicada ao recurso 
     * em análise.
     * @param process [Obrigatório] - Processo que irá fazer o anúncio de recurso.
     * @param resource [Obrigatório] - Recurso que está sendo gerenciado.
     * @return 
     */
    private static DatagramPacket createResourceDatagram(final MessageType type, Process process, Recurso resource){
        JSONObject json = new JSONObject();
        json.put("id", process.getId());//Identificador do rementente.
        json.put("request_time", Instant.now().getEpochSecond());//Indicação de tempo do remetente.
        json.put("id_resource", resource.getId());
        json.put("message_type", type.getTypeCode());
        
        switch(type) {
            case RESOURCE_RELEASE:
                if(!resource.getProcessosSolicitantes().isEmpty()){
                    json.put("id_next_process", resource.removeProcessoSolicitante().get("id"));
                    json.put("waiting_list", resource.waitingListToString());
                }                
                break;
                
            /* Caso seja uma resposta a uma dada requisição de recurso, um campo
                de assinatura é inserido no JSON, para que seja possível autenticar
                a origem da mensagem. Apenas esse campo é criptografado.
            */
            case RESOURCE_OK:
            case RESOURCE_DENIAL:
                json.put("assinatura", RSA.criptografar(process.getPrivateKey(), type.name(), DEFAULT_ENCODING));
                System.out.println(json.toString());
                break;
        }
        
        byte[] data = json.toString().getBytes(DEFAULT_ENCODING);
        return new DatagramPacket(data, data.length, process.getGroup(), MULTICAST_PORT);
    }

    /**
     * Troca o valor de obteve_repsosta (json) para o valor passado
     *
     * @param processId type [Obrigatório] - Processo que respondeu
     * @param value type [Obrigatório] - Valor que será trocado (0 - não
     * respondeu, 1 - respondeu)
     * @param process type [Obrigatório] - Processo que será trocado o
     * obteve_resposta
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
