package executar;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import naming.Naming;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private static Server server;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        server = new Server();

        //Inicializa o serviço de nomes na porta 1099. Registra a classe Server
        //com o nome "server" no Serviço de Nomes.
        Naming naming = new Naming(server);

        server.getPassagens().cadastrarNovaPassagem("São Paulo", "Curitiba", 1, 1, "28/09/2018", "29/09/2018", 20);
        server.getPassagens().cadastrarNovaPassagem("Rio de Janeiro", "Curitiba", 1, 1, "28/09/2018", "29/09/2018", 20);

        server.getHospedagens().cadastrarNovaHospedagem("São Paulo", "20/10/2018", "23/10/2018", 1, 2, 700.0);
        server.getHospedagens().cadastrarNovaHospedagem("Rio de Janeiro", "03/12/2018", "10/12/2018", 2, 4, 731.9);

        new Thread(menu).start();
    }

    /**
     *
     * Thread para rodar o menu do servidor, nele será possível cadastrar novas
     * passagens, hotéis e pacotes.
     *
     * @author Lucas
     */
    public static Runnable menu = new Runnable() {
        @Override
        public void run(){
            Scanner scan = new Scanner(System.in);
            String option = "";
            while(!option.equalsIgnoreCase("0")){
                System.out.println("0 - Sair");
                System.out.println("1 - Cadastrar nova Passagem");
                System.out.println("2 - Consultar passagens cadastradas");
                System.out.println("3 - Cadastrar nova Hospedagem");
                System.out.println("4 - Consultar Hospedagens cadastradas");
                System.out.println("5 - Cadastrar novo Pacote");
                System.out.println("6 - Consultar Pacotes cadastradas");

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        cadastrarPassagem(scan);
                        break;
                    case "2":
                        server.getPassagens().consultarPassagensPorDestino();
                        break;
                    case "3":
                        cadastrarHospedagem(scan);
                        break;
                    case "4":
                        server.getHospedagens().consultarHospedagemPorDestino();
                        break;
                    case "5":
                        cadastrarPacote(scan);
                        break;
                    case "6":
                        server.getPacotes().consultarPacotesPorDestino();
                        break;
                    default:
                        System.err.println("Opção Indisponível");
                        break;
                }
            }
        }
    };

    private static void cadastrarPassagem(Scanner scan){
        String aux;
        String destino, origem, data_ida, data_volta;
        int ida, volta, num_pessoas;
        System.out.println("Insira o destino: ");
        destino = scan.nextLine();
        System.out.println("Insira a origem: ");
        origem = scan.nextLine();
        System.out.println("Passagem de ida: (1- Sim / 0- Não)");
        aux = scan.nextLine();
        ida = Integer.parseInt(aux);
        System.out.println("Passagem de volta: (1- Sim / 0- Não)");
        aux = scan.nextLine();
        volta = Integer.parseInt(aux);
        if(ida == 1){
            System.out.println("Data da ida: ");
            data_ida = scan.nextLine();
        } else{
            data_ida = "";
        }
        if(volta == 1){
            System.out.println("data de volta: ");
            data_volta = scan.nextLine();
        } else{
            data_volta = "";
        }
        System.out.println("Número de pessoas: ");
        aux = scan.nextLine();
        num_pessoas = Integer.parseInt(aux);
        server.getPassagens().cadastrarNovaPassagem(destino, origem, ida, volta, data_ida, data_volta, num_pessoas);
    }

    private static void cadastrarHospedagem(Scanner scan){
        //Atributos da Hospedagem
        String destino, dataEntrada, dataSaida;
        int numeroQuartos, numeroPessoas;
        double preco;

        System.out.println("Insira o Nome/Destino:");
        destino = scan.nextLine();

        System.out.println("Data de Entrada:");
        dataEntrada = scan.nextLine();

        System.out.println("Data de Saída:");
        dataSaida = scan.nextLine();

        System.out.println("Número de Quartos:");
        numeroQuartos = Integer.parseInt(scan.nextLine());

        System.out.println("Número de Pessoas:");
        numeroPessoas = Integer.parseInt(scan.nextLine());

        System.out.println("Preço:");
        preco = Double.parseDouble(scan.nextLine());

        server.getHospedagens().cadastrarNovaHospedagem(destino, dataEntrada, dataSaida, numeroQuartos, numeroPessoas, preco);
    }

    /**
     * Cadastra um novo pacote. Considera que existem apenas uma passagem e uma
     * hospedagem para cada destino.
     *
     * @param scan
     * @return
     */
    private static boolean cadastrarPacote(Scanner scan){
        System.out.println("Escolha a Passagem Aérea do Pacote:");
        JSONObject passagens = getPassagem(scan);

        System.out.println("Escolha a Hospedagem para o Pacote:");
        JSONObject hospedagens = getHospedagem(scan);

        if(passagens == null || hospedagens == null){
            return false;
        }

        server.getPacotes().cadastrarNovoPacote(passagens, hospedagens);
        return true;
    }

    private static JSONObject getPassagem(Scanner scan){
        System.out.println("===== Passagens =====");
        for(Map.Entry<String, JSONArray> entry : server.getPassagens().getPassagensAereas().entrySet()){
            System.out.print(String.format("    - %s %s", entry.getKey(), System.lineSeparator()));
        }

        System.out.println("Opção: ");
        String op = scan.nextLine();

        return server.getPassagens().getPassagensAereas().get(op).getJSONObject(0);
    }

    private static JSONObject getHospedagem(Scanner scan){
        System.out.println("===== Hospedagens =====");
        for(Map.Entry<String, JSONArray> entry : server.getHospedagens().getHospedagens().entrySet()){
            System.out.print(String.format("    - %s %s", entry.getKey(), System.lineSeparator()));
        }

        System.out.println("Opção: ");
        String op = scan.nextLine();

        return server.getHospedagens().getHospedagens().get(op).getJSONObject(0);
    }
}
