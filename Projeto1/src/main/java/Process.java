import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Process extends Thread {
    private int state;
    private Key publicKey;
    private Key privateKey;
    private final MulticastSocket socket;
    private final InetAddress group;
    private Map<String, Key> processosConhecidos;

    public Process(int state, InetAddress group, MulticastSocket socket) {
        this.state = state;
        this.socket = socket;
        this.group = group;
        this.processosConhecidos = new HashMap<>();
        try{
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            this.publicKey = kp.getPublic();
            this.privateKey = kp.getPrivate();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public void announce(){

    }

    private void criptografar (InputStream input) {

    }

    @Override
    public void run() {
        byte[] buffer = new byte[1000];
        DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
        while (true){

        }
    }
}
