package executar;

import naming.Naming;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {

    private static Server server;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        server = new Server();

        //Inicializa o serviço de nomes na porta 1099. Registra a classe Server
        //com o nome "server" no Serviço de Nomes.
        Naming naming = new Naming(server);

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
                System.out.println("SERVER COORDENADOR");
                System.out.println("0 - Sair");
                System.out.println("1 - Consultar passagens");
                System.out.println("2 - Consultar Hospedagens");

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Opção Indisponível");
                        break;
                }
            }
        }
    };
}
