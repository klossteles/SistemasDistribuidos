package processos;


import executar.Main;
import criptografia.RSA;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class Process extends Thread {

    private final long id;
    private int state;
    private final PublicKey publicKey;
    private final PrivateKey privateKey;
    private final MulticastSocket socket;
    private final InetAddress group;
    private final Map<Long, JSONObject> processosConhecidos;

    /**
     * Utilizado para definir o encoding do texto das mensagens enviadas.
     * Necessário para efetuar a descriptografia adequada das mensagens
     * trocadas.
     */
    private final Charset encodingPadrao;

    public Process(int state, InetAddress group, MulticastSocket socket) {
        //Utiliza como ID o instante em que o Processo foi criado, utilizando o Epoch.
        this.id = Instant.now().toEpochMilli();
        this.state = state;
        this.socket = socket;
        this.group = group;
        this.processosConhecidos = new HashMap<>();
        this.encodingPadrao = StandardCharsets.UTF_8;

        KeyPair kp = RSA.gerarChavePublicaPrivada();
        this.publicKey = kp.getPublic();
        this.privateKey = kp.getPrivate();
    }

    /**
     * Inicializa o Process, executando os seguintes passos:
     * <ul>
     * <li>1. Entra no grupo multicast;</li>
     * <li>2. Faz um anuncio de entrada para os outros pares do grupo multicast;</li>
     * <li>3. Inicia a thread que irá tratar as mensagens enviadas por outros pares;</li>
     * </ul>
     */
    public void inicializar() {
        joinMulticastGroup();
        announce(Main.IN_EVENT);
        start();
    }

    /**
     * Encerra o Process, executando os seguintes passos:
     * <ul>
     * <li>1. Faz um anúncio de saída para os outros pares do grupo multicast;</li>
     * <li>2. Sai do grupo multicast;</li>
     * <li>3. Encerra a thread que trata as mensagens enviadas por outros pares;</li>
     * </ul>
     */
    public void encerrar() {
        announce(Main.OUT_EVENT);
        leaveMulticastGroup();
        this.stop();
    }

    public void setState(int state) {
        this.state = state;
    }

    /**
     * Retorna o ID do processo, como String.
     *
     * @return [{@link java.lang.String}] contendo o ID do process.
     */
    public String whoAmI() {
        return String.valueOf(this.id);
    }

    /**
     * Retorna uma lista de pares conhecidos, em formado de String.
     *
     * @return [{@link java.lang.String}] contendo uma lista de pares conhecidos.
     */
    public String getKnownProcess() {
        JSONArray jsArray = new JSONArray();
        for (Map.Entry<Long, JSONObject> entry : this.processosConhecidos.entrySet()) {
            JSONObject jsObj = new JSONObject();
            jsObj.put("id", entry.getKey());
            jsObj.put("json", entry.getValue());
            jsArray.put(jsObj);
        }
        return jsArray.toString(4);//4 espaços para a indentação
    }

    /**
     * Entra em um grupo multicast.
     *
     * @return TRUE caso o acesso ao grupo ocorra corretamente. FALSE caso
     * contrário.
     */
    private boolean joinMulticastGroup() {
        try {
            socket.joinGroup(group);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, "Falha ao tentar acessar grupo multicast.", ex);
            return false;
        }
    }

    /**
     * Sai de um grupo multicast.
     *
     * @return TRUE caso a saída do grupo ocorreu corretamente. FALSE caso
     * contrário.
     */
    private boolean leaveMulticastGroup() {
        try {
            socket.leaveGroup(group);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Envia um DatagramPacket anunciando a entrada ou saída do atual processo
     * no grupo multicast em que está vinculado.
     *
     * @param groupEvent [Obrigatório] - Se 0, representa um anúncio de entrada
     *                   no grupo multicast. Se 1, representa um anúncio de saída do grupo
     *                   multicast.
     */
    public void announce(final int groupEvent) {
        try {
            for (Map.Entry<Long, JSONObject> entry : this.processosConhecidos.entrySet()) {
                setObteveResposta(entry.getKey(),0);
            }
            DatagramPacket announcePacket = createAnnounceDatagram(id, publicKey, groupEvent);
            socket.send(announcePacket);
        } catch (IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Logger.getLogger(Process.class.getName()).log(Level.INFO, "Anunciou. TIPO de Evento: {0}", groupEvent == 0 ? "ENTRADA" : "SAÍDA");
    }

    /**
     * Thread que executa um socket receive para capturar as mensagens dos
     * outros pares do grupo multicast.
     */
    @Override
    public void run() {
        byte[] buffer = new byte[1000];
        DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
        while (true) {
            try {
                //Define o timeout para receber as respostas do grupo
                socket.setSoTimeout(Main.TIMEOUT);
                socket.receive(messageIn);
                tratarMensagemRecebida(messageIn);
//                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Recebeu um anuncio de:{0}", messageIn.getAddress());
            } catch (SocketTimeoutException ste) {
                //TODO: Verificar com a professora o que realmente deve ser feito ao ocorrer o timeout.
                //A lógica abaixo só faz sentido se o TIMEOUT for GRANDE.
                trataTimeOut();
//                this.processosConhecidos.clear();
//                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Timeout Alcançado no Processo {0}. Lista de pares conhecidos está vazia.", this.id);
            } catch (IOException ex) {
                Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Cria um objeto DatagramPacket utilizado para fazer o anúncio de um par em
     * um grupo multicast.
     *
     * @param id         [Obrigatório] - Identificador único para o processo.
     * @param publicKey  [Obrigatório] - A chave pública do processo.
     * @param groupEvent [Obrigatório] - FLAG para definir entrada ou saída do
     *                   grupo multicast.
     * @return [{@link java.net.DatagramPacket}] contendo os dados de um
     * processo que deseja entrar ou sair de um grupo multicast.
     */
    private DatagramPacket createAnnounceDatagram(long id, PublicKey publicKey, final int groupEvent) {
        JSONObject json = new JSONObject();
        json.put("id", id);
        JSONObject js = new JSONObject();
        js.put("key", RSA.publicKeyToString(publicKey));
        js.put("obteve_resposta", 1);
        json.put("json", js.toString());
        json.put("group_event", groupEvent);

//        byte[] data = criptografar(json.toString());
        byte[] data = json.toString().getBytes();
        return new DatagramPacket(data, data.length, group, Main.MULTICAST_PORT);
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
     * <td>(Par Emissor) != (Par Receptor) &amp;&amp; TIPO_EVENTO == (Evento de Entrada) &amp;&amp; Emissor ainda não é conhecido</td>
     * <td>Emissor é inserido na lista de pares conhecidos;<br>Receptor se anuncia novamente;</td>
     * </tr>
     * <tr>
     * <td>(Par Emissor) != (Par Receptor) &amp;&amp; TIPO_EVENTO == (Evento de Saída) &amp;&amp; Emissor é conhecido</td>
     * <td>Emissor é removido da lista de pares conhecidos</td>
     * </tr>
     * </table>
     *
     * @param datagram [Obrigatório] - DatagramPacket contendo a mensagem recebida.
     */
    private void tratarMensagemRecebida(DatagramPacket datagram) {
        String mensagem = new String(datagram.getData(), encodingPadrao);
        JSONObject json = new JSONObject(mensagem);

        Long idRecebido = json.getLong("id");
//        PublicKey publicKeyRecebida = RSA.StringToPublicKey(json.getString("key"));
        JSONObject js = new JSONObject(json.getString("json"));
        int groupEventRecebido = json.getInt("group_event");

        if (!idRecebido.equals(this.id)) {
            //Se evento de entrada, o par recebido é inserido no conjunto de pares conhecidos.
            if (groupEventRecebido == Main.IN_EVENT) {
                if (!this.processosConhecidos.containsKey(idRecebido)) {
//                    processosConhecidos.putIfAbsent(idRecebido, publicKeyRecebida);
                    processosConhecidos.putIfAbsent(idRecebido, js);
                    this.announce(Main.IN_EVENT);
                    Logger.getLogger(Process.class.getName()).log(Level.INFO, "Inseriu:{0}", idRecebido);
                }
                setObteveResposta(idRecebido, 1);
            } else { //Se evento de saída, o par recebido é removido do conjunto de pares conhecidos.
                processosConhecidos.remove(idRecebido);
                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Removeu:{0}", idRecebido);
            }
        }
    }

    private void setObteveResposta(Long processId, int value) {
        for (Map.Entry<Long, JSONObject> entry : this.processosConhecidos.entrySet()) {
            if (entry.getKey().equals(processId)) {
                JSONObject jsonObject = entry.getValue();
                jsonObject.put("obteve_resposta", value);
            }
        }
    }

    /**
     *
     *
     */
    private void trataTimeOut() {
        for (Map.Entry<Long, JSONObject> entry : this.processosConhecidos.entrySet()) {
            JSONObject jsonObject = entry.getValue();
            if (jsonObject.get("obteve_resposta").equals(0)) {
                this.processosConhecidos.remove(entry.getKey());
            }
        }
    }

}
