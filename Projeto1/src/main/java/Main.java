import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    /**
     * Constantes para definir o estado de um Processo.
     */
    private static final int RELEASED = 0;
    private static final int WANTED   = 1;
    private static final int HELD     = 2;

    public static final int TIMEOUT = 10000;//10 Segundos

    /**
     * Constantes para definir eventos de entrada e saída no grupo multicast.
     */
    public static final int IN_EVENT = 0;
    public static final int OU_EVENT = 1;

    /**
     * Constantes para definir o IP do grupo multicast e a porta para conexão.
     */
    public static final String MULTICAST_IP = "228.5.6.7";
    public static final int MULTICAST_PORT  = 6789;

    public static void main(String args[]) {
        try{
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
            Process process = new Process(RELEASED, group, socket);
            process.announce(IN_EVENT);
            process.start();
        }catch (UnknownHostException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }catch (IOException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }

        Scanner scan = new Scanner(System.in);
        String option = "";
        while (option.equalsIgnoreCase("0")) {
            System.out.println("0 - sair");
            System.out.println("O que deseja fazer? ");
            option = scan.nextLine();
        }
    }
}