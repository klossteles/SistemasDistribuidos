
import criptografia.RSA;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class Process extends Thread {

    private long id;
    private int state;
    private Key publicKey;
    private Key privateKey;
    private final MulticastSocket socket;
    private final InetAddress group;
    private Map<String, Key> processosConhecidos;

    /**
     * Utilizado para definir o encoding do texto das mensagens enviadas.
     * Necessário para efetuar a descriptografia adequada das mensagens
     * trocadas.
     */
    private final Charset encodingPadrao;

    public Process(int state, InetAddress group, MulticastSocket socket){
        //Utiliza como ID o instante em que o Processo foi criado, em milisegundos.
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
     * Envia um DatagramPacket anunciando a entrada ou saída do atual processo
     * do grupo multicast em que está vinculado.
     * 
     * @param groupEvent [Obrigatório] - Se 0, representa um anúncio de entrada
     * no grupo multicast. Se 1, representa um anúncio de saída do grupo multicast.
     */
    public void announce(final int groupEvent){
        try {
            DatagramPacket announcePacket = createAnnounceDatagram(id, publicKey, groupEvent);
            socket.joinGroup(group);
            socket.send(announcePacket);
        } catch(IOException ex) {
            Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run(){
        byte[] buffer = new byte[1000];
        DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
        while(true){

        }
    }

    private byte[] criptografar(String input){
        return RSA.criptografar(privateKey, input);
    }

    private String descriptografar(byte[] data){
        return RSA.descriptografar(publicKey, data, encodingPadrao);
    }

    /**
     * Cria um objeto DatagramPacket utilizado para fazer o anúncio de um par
     * em um grupo multicast.
     * 
     * @param id         [Obrigatório] - Identificador único para o processo.
     * @param publicKey  [Obrigatório] - A chave pública do processo.
     * @param groupEvent [Obrigatório] - FLAG para definir entrada ou saída do 
     * grupo multicast.
     * 
     * @return [{@link java.net.DatagramPacket}] contendo os dados de um processo 
     * que deseja entrar ou sair de um grupo multicast.
     */
    private DatagramPacket createAnnounceDatagram(long id, Key publicKey, final int groupEvent){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("key", publicKey);
        json.put("group_operation", groupEvent);
        
        byte[] data = criptografar(json.toString()); 
        return new DatagramPacket(data, data.length, group, Main.MULTICAST_PORT);
    }
    
}
