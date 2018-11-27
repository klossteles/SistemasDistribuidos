package executar;

import naming.Naming;
import org.json.JSONObject;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    private static CoordPassagem server;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        server = new CoordPassagem();

        //Inicializa o serviço de nomes na porta 1099. Registra a classe CoordPassagem
        //com o nome "server" no Serviço de Nomes.
        Naming naming = new Naming(server);

        server.getPassagens().cadastrarNovaPassagem("São Paulo", "Curitiba", 1, 1, "28/09/2018", "29/09/2018", 20, 150.00);
        server.getPassagens().cadastrarNovaPassagem("Rio de Janeiro", "Curitiba", 1, 1, "28/09/2018", "29/09/2018", 20, 500.00);
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

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        cadastrarPassagem(scan);
                        break;
                    case "2":
                        System.out.println(server.getPassagens().consultarPassagens());
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
}
