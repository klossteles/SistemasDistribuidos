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
import java.util.logging.Level;
import java.util.logging.Logger;

import constantes.MessageType;
import processos.Mensagem;
import processos.Process;

import static constantes.ProcessResourceState.*;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONObject;
import recursos.Recurso;

public class Main {

    public static final int TIMEOUT = 30000;//10 Segundos

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
    public static final int MULTICAST_PORT = 6789;

    public static void main(String args[]){
        Process process = null;
        try {
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            MulticastSocket socket = new MulticastSocket(MULTICAST_PORT);
            process = new Process(RELEASED, group, socket);
            process.inicializar();
            inicializarRecursosArbitrariamente(process);
        } catch(UnknownHostException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        } catch(IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }

        Process finalProcess = process;
//        Cria timer para buscar pelos processos vivos
//        para isso, coloca obteve_resposta como 0 e se anuncia
        Timer timerCheckWhoIsAlive = new Timer();
        timerCheckWhoIsAlive.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){
                Mensagem.announce(MessageType.ANNOUNCE, finalProcess);
//                Logger.getLogger(Process.class.getName()).log(Level.INFO, "Estou me anunciando: {0}", Instant.now());
            }
        }, 0, TIMEOUT);

        menu(process, timerCheckWhoIsAlive);
    }

    /**
     * Exibe e computa a opção escolhida pelo usuário no menu de opções de
     * gerência de processos e recursos.
     *
     * @param process [Obrigatório] - Processo que irá sofrer as ações
     * escolhidas pelo usuário.
     */
    private static void menu(Process process, Timer timer){
        Scanner scan = new Scanner(System.in);
        Scanner scanRecurso = new Scanner(System.in);
        String option = "";
        while(!option.equalsIgnoreCase("0")){
            System.out.println("0 - Sair");
            System.out.println("1 - Processos Conhecidos");
            System.out.println("2 - Quem sou eu");
            System.out.println("3 - Solicitar recurso");
            System.out.println("4 - Liberar recurso");
            System.out.println("5 - Exibir Status Local Recursos");
            System.out.println("6 - Exibir Lista de Espera Local Recursos");
            System.out.println("O que deseja fazer?");
            option = scan.nextLine();

            switch(option) {
                case "0":
                    timer.cancel();
                    process.encerrar();
                    break;
                case "1":
                    System.out.println(process.getKnownProcess());
                    break;
                case "2":
                    System.out.println("Meu id: " + process.whoAmI());
                    break;
                case "3":
                    exibirRecursos(process);
                    System.out.println("Escolha o ID do recurso desejado: ");
                    long idRecursoSolicitar = scanRecurso.nextLong();
                    process.solicitarRecurso(idRecursoSolicitar);
                    break;
                case "4":
                    exibirRecursos(process);
                    System.out.println("Escolha o ID do recurso desejado: ");
                    long idRecursoLiberar = scanRecurso.nextLong();
                    process.liberarRecurso(idRecursoLiberar);
                    break;
                case "5":
                    exibirRecursos(process);
                    break;
                case "6":
                    exibirListaEsperaRecursos(process);
                    break;
                default:
                    System.err.println("Opção Indisponível");
                    break;
            }
        }
    }

    /**
     * Inicializa arbitrariamente dois recursos, utilizados para testar a
     * coordenação de recursos entre os processos.
     *
     * @param process [Obrigatório] - Processo que irá receber os dois processos
     * arbitrários.
     */
    private static void inicializarRecursosArbitrariamente(Process process){
        Recurso recurso1 = new Recurso(1, RELEASED, Instant.now());
        Recurso recurso2 = new Recurso(2, RELEASED, Instant.now());

        process.getRecursosDisponiveis().put(1L, recurso1);
        process.getRecursosDisponiveis().put(2L, recurso2);
    }

    /**
     * Exibe os recursos conhecidos pelo processo atual.
     * @param process 
     */
    private static void exibirRecursos(Process process){
        System.out.println("====================================");
        for(Map.Entry<Long, Recurso> recurso : process.getRecursosDisponiveis().entrySet()){
            System.out.printf("ID: %d - STATE: %s %s", recurso.getKey(), recurso.getValue().getEstadoSolicitacao().name(), System.lineSeparator());
        }
        System.out.println("====================================");
    }

    /**
     * Exibe os processos existentes na lista de espera dos recursos disponíveis.
     * A lista exibida é a lista de espera local, que não é necessáriamente identica
     * a lista de espera do processo que detém o recurso em si.
     * 
     * @param process 
     */
    private static void exibirListaEsperaRecursos(Process process){
        for(Map.Entry<Long, Recurso> recurso : process.getRecursosDisponiveis().entrySet()){
            System.out.printf("%s===== RECURSO %d ===== %s", System.lineSeparator(), recurso.getKey(), System.lineSeparator());
            List<JSONObject> listaEspera = recurso.getValue().getProcessosSolicitantes();
            if(listaEspera.isEmpty()){
                System.out.println("VAZIA");
            } else{
                for(JSONObject json : listaEspera){
                    System.out.printf("PROCESS ID: %d %s", json.getLong("id"), System.lineSeparator());
                }
            }
            System.out.println("======================");
        }
    }
}
