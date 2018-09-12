/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processos;

import static constantes.ProcessResourceState.*;
import static constantes.MessageType.*;
import constantes.MessageType;
import constantes.ProcessResourceState;
import criptografia.RSA;
import executar.Main;
import java.io.IOException;
import java.net.DatagramPacket;
import java.security.Key;
import java.security.PublicKey;
import java.time.Instant;
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

    private static final Logger LOG = Logger.getLogger(Process.class.getName());
    //=========================================================================

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
            }, Main.TIMEOUT);
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
            Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
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
        String mensagem = new String(datagram.getData(), Main.DEFAULT_ENCODING);
        JSONObject json = new JSONObject(mensagem);

        Long idRecebido = json.getLong("id");
        MessageType groupEventRecebido = MessageType.getTypeByCode(json.getInt("message_type"));

        JSONObject js = null;
        PublicKey publicKeyRecebida = null;

        if(idRecebido.equals(process.getId())){
            return;
        }

        switch(groupEventRecebido) {
            case GROUP_IN:
                //Se evento de entrada, o par recebido é inserido no conjunto de pares conhecidos.
                js = new JSONObject(json.getString("json"));
                publicKeyRecebida = RSA.StringToPublicKey(js.getString("key"));

                if(!process.getProcessosConhecidos().containsKey(idRecebido)){
                    //                    processosConhecidos.putIfAbsent(idRecebido, publicKeyRecebida);
                    process.getProcessosConhecidos().putIfAbsent(idRecebido, js);
                    Mensagem.announce(MessageType.GROUP_IN, process);
                    LOG.log(Level.INFO, "Inseriu:{0}", idRecebido);
                }
                setObteveResposta(idRecebido, 1, process);
                break;

            case GROUP_OUT:
                //Se evento de saída, o par recebido é removido do conjunto de pares conhecidos.
                process.getProcessosConhecidos().remove(idRecebido);
                LOG.log(Level.INFO, "Removeu:{0}", idRecebido);
                break;

            case ANNOUNCE:
                js = new JSONObject(json.getString("json"));
                publicKeyRecebida = RSA.StringToPublicKey(js.getString("key"));

                if(!process.getProcessosConhecidos().containsKey(idRecebido)){
                    process.getProcessosConhecidos().putIfAbsent(idRecebido, js);
//                    LOG.log(Level.INFO, "Inseriu:{0}", idRecebido);
                }
                setObteveResposta(idRecebido, 1, process);
//                LOG.log(Level.INFO, "Se Anunciou:{0}", idRecebido);
                break;

            case RESOURCE_REQUEST:
                LOG.info(String.format("RESOURCE_REQUEST recebido de '%d'", idRecebido));
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
                LOG.info(String.format("RESOURCE_RELEASE recebido de '%d'", idRecebido));
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

            case RESOURCE_OK://O recurso solicitado está disponível. Acorda thread.
                Long idResourceOk = json.getLong("id_resource");
                Recurso resourceOk = process.getRecursosDisponiveis().get(idResourceOk);
                resourceOk.incrementReceivedMessagesOK();
                Key priateKey = process.getPrivateKey();
                String str = RSA.descriptografar(priateKey, json.getString("mensagem").getBytes(Main.DEFAULT_ENCODING),Main.DEFAULT_ENCODING);
                json = new JSONObject(str);
                LOG.info(String.format("RESOURCE_OK recebido de '%d'. (%d)//(%d)", idRecebido, process.getProcessosConhecidosAoSolicitarRecurso(), resourceOk.getReceivedMessages()));
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
                LOG.info(String.format("RESOURCE_DENIAL recebido de '%d'. (%d)//(%d)", idRecebido, process.getProcessosConhecidosAoSolicitarRecurso(), resourceNegado.getReceivedMessages()));
                /* Se tal recurso foi solicitado por mim (WANTED), foi negado, mas
                 * sou o proximo na fila.
                 */
                if(resourceNegado.souOProximo(process)){
                    resourceNegado.clearReceivedMessagesOK();
                    LOG.info(String.format("O recurso '%d' foi negado, mas sou o próximo na fila.", idResourceNegado));
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

        byte[] data = json.toString().getBytes();
        return new DatagramPacket(data, data.length, process.getGroup(), Main.MULTICAST_PORT);
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
        byte[] data = new byte[0];
        switch(type) {
            case RESOURCE_RELEASE:
                if(!resource.getProcessosSolicitantes().isEmpty()){
                    json.put("id_next_process", resource.removeProcessoSolicitante().get("id"));
                    json.put("waiting_list", resource.waitingListToString());
                }
                data = json.toString().getBytes(Main.DEFAULT_ENCODING);
                break;
            case RESOURCE_OK:
                JSONObject jsonOk = new JSONObject();
                jsonOk.put("id", process.getId());
                jsonOk.put("message_type", type.getTypeCode());
                jsonOk.put("message", RSA.criptografar(process.getPrivateKey(), json.toString(), Main.DEFAULT_ENCODING));
                data = jsonOk.toString().getBytes(Main.DEFAULT_ENCODING);
                break;
            case RESOURCE_DENIAL:
                JSONObject jsonDenial = new JSONObject();
                jsonDenial.put("id", process.getId());
                jsonDenial.put("message_type", type.getTypeCode());
                jsonDenial.put("message", RSA.criptografar(process.getPrivateKey(), json.toString(), Main.DEFAULT_ENCODING));
                data = jsonDenial.toString().getBytes(Main.DEFAULT_ENCODING);
                break;
        }

        return new DatagramPacket(data, data.length, process.getGroup(), Main.MULTICAST_PORT);
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
