
import criptografia.RSA;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class Process extends Thread {

    private int state;
    private Key publicKey;
    private Key privateKey;
    private final MulticastSocket socket;
    private final InetAddress group;
    private Map<String, Key> processosConhecidos;
    
    /**
     * Utilizado para definir o encoding do texto das mensagens enviadas. 
     * Necessário para efetuar a descriptografia adequada das mensagens trocadas.
     */
    private final Charset encodingPadrao;

    public Process(int state, InetAddress group, MulticastSocket socket){
        this.state = state;
        this.socket = socket;
        this.group = group;
        this.processosConhecidos = new HashMap<>();
        this.encodingPadrao = StandardCharsets.UTF_8;
        
        KeyPair kp = RSA.gerarChavePublicaPrivada();
        this.publicKey = kp.getPublic();
        this.privateKey = kp.getPrivate();
    }

    public void announce(){

    }

    private void criptografar(InputStream input){

    }

    @Override
    public void run(){
        byte[] buffer = new byte[1000];
        DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
        while(true){

        }
    }
}
