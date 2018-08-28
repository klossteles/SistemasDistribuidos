package process;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Process extends Thread {
    private int state;
    private Key publicKey;
    private Key privateKey;
    private final MulticastSocket socket;
    private final InetAddress group;
    private Map<String, Key> processosConhecidos;
    private String name;

    public Process(int state, InetAddress group, MulticastSocket socket) {
        this.state = state;
        this.socket = socket;
        this.group = group;
        this.processosConhecidos = new HashMap<String, Key>();
        this.name = new Timestamp(Calendar.getInstance().getTimeInMillis()).toString();
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            this.publicKey = kp.getPublic();
            this.privateKey = kp.getPrivate();
            this.socket.joinGroup(this.group);
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void announce(){
        JSONObject json = new JSONObject();
        json.put(this.name, this.publicKey);
        byte[] m = json.toString().getBytes();
        DatagramPacket messageOut = new DatagramPacket(m, m.length, group, 6789);
        try {
            this.socket.send(messageOut);
        } catch (IOException e){
            System.out.println("IO: " + e.getMessage());
        }
    }

    private void criptografar (InputStream input) {

    }

    @Override
    public void run() {
        byte[] buffer = new byte[1000];
        DatagramPacket messageIn = new DatagramPacket(buffer, buffer.length);
        while (true){
            try {
                this.socket.receive(messageIn);
            } catch (IOException ex) {
                ex.printStackTrace();
//                Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null, ex);
            }
            JSONObject json = new JSONObject(messageIn.toString());
            System.out.println(json);
            System.out.println("Received:" + new String(messageIn.getData()));
        }
    }
}
