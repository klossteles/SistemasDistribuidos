package executar;

import naming.Naming;
import org.json.JSONObject;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {

    private static Hospedagem server;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        server = new Hospedagem();

        //Inicializa o serviço de nomes na porta 1099. Registra a classe Hospedagem
        //com o nome "server" no Serviço de Nomes.
        Naming naming = new Naming(server);

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
            Scanner scan = new Scanner(System.in);
            String option = "";
            while(!option.equalsIgnoreCase("0")){
                System.out.println("0 - Sair");
                System.out.println("1 - Cadastrar nova Hospedagem");
                System.out.println("2 - Consultar Hospedagens cadastradas");

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        cadastrarHospedagem(scan);
                        break;
                    case "2":
                        System.out.println(server.getHospedagens().consultarHospedagem());
                        break;
                    default:
                        System.err.println("Opção Indisponível");
                        break;
                }
            }
        }
    };


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
}
