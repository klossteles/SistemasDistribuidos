package executar;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import processos.Process;
import static constantes.ProcessResourceState.*;
import java.nio.charset.Charset;

public class Main {
    /**
     * Constantes para definir o estado de um Processo.
     */
//    private static final int RELEASED = 0;
//    private static final int WANTED   = 1;
//    private static final int HELD     = 2;
    
    public static final int TIMEOUT = 10000;//10 Segundos
    
    /**
     * Constantes para definir eventos de entrada e saída no grupo multicast.
     */
//    public static final int IN_EVENT = 0;
//    public static final int OUT_EVENT = 1;

    /**
     * Utilizado para definir o encoding do texto das mensagens enviadas.
     * Necessário para efetuar a descriptografia adequada das mensagens
     * trocadas.
     */
    public static final Charset DEFAULT_ENCODING = Charset.defaultCharset();
    
    /**
     * Constantes para definir o IP do grupo multicast e a porta para conexão.
     */
    public static final String MULTICAST_IP = "233.5.6.10";
    public static final int MULTICAST_PORT  = 6789;
    
    public static void main(String args[]) {
        Process process = null;
        try{
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
            process = new Process(RELEASED, group, socket);
            process.inicializar();
        }catch (UnknownHostException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }catch (IOException e){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }

        Scanner scan = new Scanner(System.in);
        String option = "";
        while (!option.equalsIgnoreCase("0")) {
            System.out.println("0 - Sair");
            System.out.println("1 - Processos Conhecidos");
            System.out.println("2 - Quem sou eu");
            System.out.println("O que deseja fazer?");
            option = scan.nextLine();

            switch (option){
                case "0":
                    process.encerrar();
                    break;
                case "1":
                    System.out.println(process.getKnownProcess());
                    break;
                case "2":
                    System.out.println("Meu id: " + process.whoAmI());
                    break;
                default:
                    System.err.println("Opção Indisponível");
                    break;
            }
        }
    }
}