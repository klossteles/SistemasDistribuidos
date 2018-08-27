
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
import org.json.JSONObject;

public class Process extends Thread {

    private String id;
    private int state;
    private PublicKey publicKey;
    private PrivateKey privateKey;
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
        //Utiliza como ID o instante em que o Processo foi criado, no formato ISO-8601.
        this.id = Instant.now().toString();
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
            try {
                //Define o timeout para receber as respostas do grupo
                socket.setSoTimeout(Main.TIMEOUT);
                socket.receive(messageIn);
                tratarMensagemRecebida(messageIn);
            } catch(SocketTimeoutException ste){
                // TODO: Verificar item 5: "A lista de pares deverá ser atualizada".
            }catch(IOException ex) {
                Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    private DatagramPacket createAnnounceDatagram(String id, PublicKey publicKey, final int groupEvent){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("key", RSA.publicKeyToString(publicKey));
        json.put("group_event", groupEvent);
        
        byte[] data = criptografar(json.toString()); 
        return new DatagramPacket(data, data.length, group, Main.MULTICAST_PORT);
    }
    
    /**
     * Trata um DatagramPacket advindo do anúncio de outro par. Considera que a
     * mensagem recebida NÃO está criptografada.
     * 
     * @param datagram 
     */
    private void tratarMensagemRecebida(DatagramPacket datagram){
        String mensagem = new String(datagram.getData(), encodingPadrao);
        JSONObject json = new JSONObject(mensagem);
        
        String idRecebido           = json.getString("id");
        PublicKey publicKeyRecebida = RSA.StringToPublicKey(json.getString("key"));
        int groupEventRecebido      = json.getInt("group_event");
        
        //Se evento de entrada, o par recebido é inserido no conjunto de pares conhecidos.
        if(groupEventRecebido == Main.IN_EVENT){
            processosConhecidos.putIfAbsent(idRecebido, publicKeyRecebida);
        } 
        //Se evento de saída, o par recebido é removido do conjunto de pares conhecidos.
        else{
            processosConhecidos.remove(idRecebido);
        }
        
        
    }
}
