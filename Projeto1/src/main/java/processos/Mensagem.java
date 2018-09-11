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
import java.security.PublicKey;
import java.time.Instant;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import recursos.Recurso;

/**
 *
 * @author Brendon
 */
public class Mensagem {

    private static final Logger LOG = Logger.getLogger(Process.class.getName());
    private static int receivedMessages = 0;

    public static void incrementReceivedMessages(){
        Mensagem.receivedMessages++;
    }

    public static void clearReceivedMessages(){
        Mensagem.receivedMessages = 0;
    }

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

    public static void resource(final MessageType requestOrRelease, Process process, Recurso resource){
        try {
            DatagramPacket resourcePacket = createResourceDatagram(requestOrRelease, process, resource);
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
     * @param process
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
                Long idResourceRequest = json.getLong("id_resource");
                Long requestTime = json.getLong("request_time");

                Recurso resourceSolicitado = process.getRecursosDisponiveis().get(idResourceRequest);
                ProcessResourceState stateLocal = resourceSolicitado.getEstadoSolicitacao();
                long requestTimeLocal = resourceSolicitado.getMomentoSolicitacao().getEpochSecond();

                if(stateLocal.equals(HELD)
                        || (stateLocal.equals(WANTED) && requestTimeLocal < requestTime)){
                    Mensagem.resource(RESOURCE_DENIAL, process, resourceSolicitado);
                    resourceSolicitado.addProcessoSolicitante(json);
                } else{
                    Mensagem.resource(RESOURCE_OK, process, resourceSolicitado);
                }
                break;

            case RESOURCE_RELEASE:
                Long idResourceRelease = json.getLong("id_resource");
                Long idNextProcess = json.getLong("id_next_process");

                Recurso resourceLiberado = process.getRecursosDisponiveis().get(idResourceRelease);

                if(idNextProcess == process.getId()){
                    resourceLiberado.alocado();
                }
                break;

            case RESOURCE_OK://O recurso solicitado está disponível. Acorda thread.
                Mensagem.incrementReceivedMessages();
                if(process.getProcessosConhecidosAoSolicitarRecurso() == Mensagem.receivedMessages){
                    Long idResourceOk = json.getLong("id_resource");
                    Recurso resourceOk = process.getRecursosDisponiveis().get(idResourceOk);
                    resourceOk.alocado();
                    Mensagem.clearReceivedMessages();
                    process.wait = false;
                }
                break;
            case RESOURCE_DENIAL://O recurso não está disponível. Acorda a thread e adiciona na lista de espera.
                Mensagem.incrementReceivedMessages();
                if(process.getProcessosConhecidosAoSolicitarRecurso() == Mensagem.receivedMessages){                    
                    Long idResourceNegado = json.getLong("id_resource");
                    Recurso resourceNegado = process.getRecursosDisponiveis().get(idResourceNegado);
                    json.put("id", process.getId());
                    resourceNegado.setEstadoSolicitacao(WANTED);
                    resourceNegado.addProcessoSolicitante(json);
                    Mensagem.clearReceivedMessages();
                    process.wait = false;
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

    private static DatagramPacket createResourceDatagram(final MessageType type, Process process, Recurso resource){
        JSONObject json = new JSONObject();
        json.put("id", process.getId());//Identificador do rementente.
        json.put("request_time", Instant.now().getEpochSecond());//Indicação de tempo do remetente.
        json.put("id_resource", resource.getId());
        json.put("message_type", type.getTypeCode());//Se é REQUEST ou RELEASE de um recurso.

        if(type.equals(RESOURCE_RELEASE)){
            if(resource.getProcessosSolicitantes().isEmpty()){
                json.put("id_next_process", 0);
            } else{
                json.put("id_next_process", resource.removeProcessoSolicitante().get("id"));
            }
        }

        byte[] data = json.toString().getBytes(Main.DEFAULT_ENCODING);
        return new DatagramPacket(data, data.length, process.getGroup(), Main.MULTICAST_PORT);
    }

    /**
     * Troca o valor de obteve_repsosta (json) para o valor passado
     *
     * @param processId type [Obrigatório] - Processo que respondeu
     * @param value type [Obrigatório] - Valor que será trocado (0 - não respondeu, 1 - respondeu)
     * @param process type [Obrigatório] - Processo que será trocado o obteve_resposta
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
