import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Process extends Thread {
    private int state;
    private final String name;
    private Key publicKey;
    private Key privateKey;
    private final MulticastSocket socket;
    private ArrayList<Process> processosConhecidos;
    private final InetAddress group;

    public Process(int state, String name, MulticastSocket socket, InetAddress group) {
        this.state = state;
        this.name = name;
        this.socket = socket;
        this.processosConhecidos = new ArrayList<>();
        this.group = group;
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

    private void announce(){

    }

    private void criptografar (InputStream ) {

    }

    @Override
    public void run() {
        byte[] buffer = new byte[1000];
        DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
        while (true){

        }
    }
}
