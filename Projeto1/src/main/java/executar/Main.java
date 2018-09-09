package executar;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import constantes.MessageType;
import org.json.JSONObject;
import processos.Mensagem;
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

        Process finalProcess = process;
//        Cria timer para buscar pelos processos vivos
//        para isso, coloca obteve_resposta como 0 e se anuncia
        Timer timerCheckLive = new Timer();
        timerCheckLive.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (Map.Entry<Long, JSONObject> entry : finalProcess.getProcessosConhecidos().entrySet()){
                    JSONObject jsonObject = entry.getValue();
                    jsonObject.put("obteve_resposta", 0);
                }
                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Estou me anunciando: {0}", Instant.now());
                Mensagem.announce(MessageType.ANNOUNCE, finalProcess);
            }
        },0, TIMEOUT);
//         TODO: Ocorrendo erro java.util.ConcurrentModificationException, ao iniciar o segundo timer
//        Cria timer para verificar quem respondeu
//        caso obteve_reposta == 0 remove da lista de conhecidos
//        Timer timerRemoveDead = new Timer();
//        timerRemoveDead.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Verificando quem respondeu");
//                for(Map.Entry<Long, JSONObject> entry : finalProcess.getProcessosConhecidos().entrySet()){
//                    JSONObject jsonObject = entry.getValue();
//                    if(jsonObject.get("obteve_resposta").equals(0)){
//                        finalProcess.getProcessosConhecidos().remove(entry.getKey());
//                    }
//                }
//            }
//        }, 5, TIMEOUT);

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