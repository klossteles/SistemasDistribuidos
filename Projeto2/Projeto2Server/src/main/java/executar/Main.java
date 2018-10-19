package executar;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Logger;
import naming.Naming;
import org.json.JSONObject;

public class Main {

    private static final String TIPO_INTERESSE_PASSAGEM = "PASSAGEM";
    private static final String TIPO_INTERESSE_HOSPEDAGEM = "HOSPEDAGEM";
    private static final String TIPO_INTERESSE_PACOTE = "PACOTE";
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private static Server server;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        server = new Server();

        //Inicializa o serviço de nomes na porta 1099. Registra a classe Server
        //com o nome "server" no Serviço de Nomes.
        Naming naming = new Naming(server);

        server.getPassagens().cadastrarNovaPassagem("São Paulo", "Curitiba", 1, 1, "28/09/2018", "29/09/2018", 20, 150.00);
        server.getPassagens().cadastrarNovaPassagem("Rio de Janeiro", "Curitiba", 1, 1, "28/09/2018", "29/09/2018", 20, 500.00);

        server.getHospedagens().cadastrarNovaHospedagem("São Paulo", "20/10/2018", "23/10/2018", 1, 350.00, 700);
        server.getHospedagens().cadastrarNovaHospedagem("Rio de Janeiro", "03/12/2018", "10/12/2018", 2, new Double(4), 731);

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
            JSONObject registroCadastrado;
            Scanner scan = new Scanner(System.in);
            String option = "";
            while(!option.equalsIgnoreCase("0")){
                System.out.println("0 - Sair");
                System.out.println("1 - Cadastrar nova Passagem");
                System.out.println("2 - Consultar passagens cadastradas");
                System.out.println("3 - Cadastrar nova Hospedagem");
                System.out.println("4 - Consultar Hospedagens cadastradas");
                System.out.println("5 - Cadastrar novo Pacote");
                System.out.println("6 - Consultar Pacotes cadastrados");

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        registroCadastrado = cadastrarPassagem(scan);
                        if(registroCadastrado != null){
                            server.notificarClientesInteresse(TIPO_INTERESSE_PASSAGEM, registroCadastrado);
                        }
                        break;
                    case "2":
                        System.out.println(server.getPassagens().consultarPassagens());
                        break;
                    case "3":
                        registroCadastrado = cadastrarHospedagem(scan);
                        if(registroCadastrado != null){
                            server.notificarClientesInteresse(TIPO_INTERESSE_HOSPEDAGEM, registroCadastrado);
                        }
                        break;
                    case "4":
                        System.out.println(server.getHospedagens().consultarHospedagem());
                        break;
                    case "5":
                        registroCadastrado = cadastrarPacote(scan);
                        if(registroCadastrado != null){
                            server.notificarClientesInteresse(TIPO_INTERESSE_PACOTE, registroCadastrado);
                        }
                        break;
                    case "6":
                        System.out.println(server.getPacotes().consultarPacotes());
                        break;
                    default:
                        System.err.println("Opção Indisponível");
                        break;
                }
            }
        }
    };

    private static JSONObject cadastrarPassagem(Scanner scan){
        String aux;
        String destino, origem, data_ida, data_volta;
        int ida, volta, num_pessoas;
        Double preco;
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
        System.out.println("Preço: ");
        aux = scan.nextLine();
        preco = Double.parseDouble(aux);
        return server.getPassagens().cadastrarNovaPassagem(destino, origem, ida, volta, data_ida, data_volta, num_pessoas, preco);
    }

    private static JSONObject cadastrarHospedagem(Scanner scan){
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

        return server.getHospedagens().cadastrarNovaHospedagem(destino, dataEntrada, dataSaida, numeroPessoas, preco, numeroQuartos);
    }

    /**
     * Cadastra um novo pacote. Considera que existem apenas uma passagem e uma
     * hospedagem para cada destino.
     *
     * @param scan
     * @return
     */
    private static JSONObject cadastrarPacote(Scanner scan){
        System.out.println("==== PASSAGENS ====");
        System.out.println(server.getPassagens().consultarPassagens());
        System.out.println("Escolha a Passagem Aérea do Pacote:");
        String aux = scan.nextLine();
        Long id_passagem = Long.parseLong(aux);

        System.out.println("==== HOSPEDAGENS ====");
        System.out.println(server.getHospedagens().consultarHospedagem());
        System.out.println("Escolha a Hospedagem para o Pacote:");
        aux = scan.nextLine();
        Long id_hospedagem = Long.parseLong(aux);

        return server.getPacotes().cadastrarNovoPacote(id_hospedagem, id_passagem, server.getHospedagens().getHospedagens(), server.getPassagens().getPassagensAereas());
    }
}
