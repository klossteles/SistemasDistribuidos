import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    private static final int RELEASED = 0;
    private static final int WANTED = 1;
    private static final int HELD = 2;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String option = "";
        try{
            InetAddress group = InetAddress.getByName("228.5.6.7");
            MulticastSocket socket = new MulticastSocket(6789);
            Process process = new Process(RELEASED, group, socket);
            process.announce();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        while (option.equalsIgnoreCase("0")) {
            System.out.println("0 - sair");
            System.out.println("O que deseja fazer? ");
            option = scan.nextLine();
        }
    }
}