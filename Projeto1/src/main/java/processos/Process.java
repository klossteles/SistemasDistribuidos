package processos;

import static constantes.ProcessResourceState.*;
import executar.Main;
import criptografia.RSA;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import recursos.Recurso;
import static constantes.MessageType.*;
import constantes.ProcessResourceState;

public class Process extends Thread {

    private final long id;
    private final PublicKey publicKey;
    private final PrivateKey privateKey;
    private final MulticastSocket socket;
    private final InetAddress group;
    private final ConcurrentHashMap<Long, JSONObject> processosConhecidos;
    private final Map<Long, Recurso> recursosDisponiveis;

    private static final Logger LOG = Logger.getLogger(Process.class.getName());
    private int processosConhecidosAoSolicitarRecurso = 0;
    
    public Process(ProcessResourceState state, InetAddress group, MulticastSocket socket){
        //Utiliza como ID o instante em que o Processo foi criado, utilizando o Epoch.
        this.id = Instant.now().toEpochMilli();
        this.socket = socket;
        this.group = group;
        this.processosConhecidos = new ConcurrentHashMap<>();
        this.recursosDisponiveis = new HashMap<>();

        KeyPair kp = RSA.gerarChavePublicaPrivada();
        this.publicKey = kp.getPublic();
        this.privateKey = kp.getPrivate();
    }

    @Override
    public long getId(){
        return id;
    }

    public MulticastSocket getSocket(){
        return socket;
    }

    public PublicKey getPublicKey(){
        return publicKey;
    }

    public InetAddress getGroup(){
        return group;
    }

    public ConcurrentHashMap<Long, JSONObject> getProcessosConhecidos(){
        return processosConhecidos;
    }

    public Map<Long, Recurso> getRecursosDisponiveis(){
        return recursosDisponiveis;
    }

    public int getProcessosConhecidosAoSolicitarRecurso(){
        return processosConhecidosAoSolicitarRecurso;
    }

    /**
     * Inicializa o Process, executando os seguintes passos:
     * <ul>
     * <li>1. Entra no grupo multicast;</li>
     * <li>2. Faz um anuncio de entrada para os outros pares do grupo
     * multicast;</li>
     * <li>3. Inicia a thread que irá tratar as mensagens enviadas por outros
     * pares;</li>
     * </ul>
     */
    public void inicializar(){
        joinMulticastGroup();
        Mensagem.announce(GROUP_IN, this);
        start();
    }

    /**
     * Encerra o Process, executando os seguintes passos:
     * <ul>
     * <li>1. Faz um anúncio de saída para os outros pares do grupo
     * multicast;</li>
     * <li>2. Sai do grupo multicast;</li>
     * <li>3. Encerra a thread que trata as mensagens enviadas por outros
     * pares;</li>
     * </ul>
     */
    public void encerrar(){
        Mensagem.announce(GROUP_OUT, this);
        leaveMulticastGroup();
        this.stop();
    }

    /**
     * Retorna o ID do processo, como String.
     *
     * @return [{@link java.lang.String}] contendo o ID do process.
     */
    public String whoAmI(){
        return String.valueOf(this.id);
    }

    /**
     * Retorna uma lista de pares conhecidos, em formado de String.
     *
     * @return [{@link java.lang.String}] contendo uma lista de pares
     * conhecidos.
     */
    public String getKnownProcess(){
        JSONArray jsArray = new JSONArray();
        for(Map.Entry<Long, JSONObject> entry : this.processosConhecidos.entrySet()){
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
    private boolean joinMulticastGroup(){
        try {
            socket.joinGroup(group);
            return true;
        } catch(IOException ex) {
            LOG.log(Level.SEVERE, "Falha ao tentar acessar grupo multicast.", ex);
            return false;
        }
    }

    /**
     * Sai de um grupo multicast.
     *
     * @return TRUE caso a saída do grupo ocorreu corretamente. FALSE caso
     * contrário.
     */
    private boolean leaveMulticastGroup(){
        try {
            socket.leaveGroup(group);
            return true;
        } catch(IOException ex) {
            LOG.log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Solicita um recurso representado pelo ID recebido por parâmetro. A
     * solicitação é feita através de uma mensagem do tipo
     * {@link constantes.MessageType} RESOURCE_REQUEST no grupo multicast.
     *
     * @param idRecurso [Obrigatório] - ID do recurso que se deseja solicitar o
     * uso exclusivo.
     * @return
     */
    public boolean solicitarRecurso(long idRecurso){
        if(idRecurso < 1 || !this.recursosDisponiveis.containsKey(idRecurso)){
            LOG.warning(String.format("O recurso de ID '%d' não existe.", idRecurso));
            return false;
        }

        Recurso resource = this.recursosDisponiveis.get(idRecurso);
        ProcessResourceState localState = resource.getEstadoSolicitacao();
        if(localState.equals(WANTED) || localState.equals(HELD)){
            LOG.warning(String.format("O recurso de ID '%d' já foi solicitado.", idRecurso));
            return false;
        }

        resource.solicitar();
        this.processosConhecidosAoSolicitarRecurso = this.processosConhecidos.size();

        if(this.processosConhecidosAoSolicitarRecurso == 0){
            resource.alocado();
            LOG.info(String.format("O recurso de ID '%d' foi alocado.", idRecurso));
            return true;
        }

        Mensagem.clearReceivedMessages();
        Mensagem.resource(RESOURCE_REQUEST, this, resource);
        LOG.info(String.format("O recurso de ID '%d' foi solicitado pelo processo '%s'.", idRecurso, this.id));
        return true;
    }

    /**
     * Libera um recurso representado pelo ID recebido por parâmetro. A
     * liberação é feita através de uma mensagem do tipo
     * {@link constantes.MessageType} RESOURCE_RELEASE no grupo multicast.
     *
     * @param idRecurso [Obrigatório] - ID do recurso que se deseja liberar o
     * uso exclusivo.
     * @return
     */
    public boolean liberarRecurso(long idRecurso){
        if(idRecurso < 1 || !this.recursosDisponiveis.containsKey(idRecurso)){
            LOG.warning(String.format("O recurso de ID '%d' não existe.", idRecurso));
            return false;
        }

        Recurso resource = this.recursosDisponiveis.get(idRecurso);
        if(!resource.getEstadoSolicitacao().equals(HELD)){
            LOG.warning(String.format("O recurso de ID '%d' não está alocado para o processo '%d'.", idRecurso, this.id));
            return false;
        }

        resource.liberar();
        Mensagem.clearReceivedMessages();
        Mensagem.resource(RESOURCE_RELEASE, this, resource);
        LOG.info(String.format("O recurso de ID '%d' foi liberado.", idRecurso));

        return true;
    }

    /**
     * Thread que executa um socket receive para capturar as mensagens dos
     * outros pares do grupo multicast.
     */
    @Override
    public void run(){
        byte[] buffer = new byte[1000];
        DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
        while(true){
            try {
                //Define o timeout para receber as respostas do grupo
                socket.setSoTimeout(Main.TIMEOUT);
                socket.receive(messageIn);
                Mensagem.tratarMensagemRecebida(messageIn, this);
            } catch(SocketTimeoutException ste) {
                Mensagem.trataTimeOut(this);
            } catch(IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }
}
