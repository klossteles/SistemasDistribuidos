package executar;

import PassagemAerea.PassagemAerea;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    public static PassagemAerea passagensAereas;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        passagensAereas = new PassagemAerea();
        passagensAereas.cadastrarNovaPassagem("São Paulo", "Curitiba",1,1,"28/09/2018", "29/09/2018", 20);
        passagensAereas.cadastrarNovaPassagem("Rio de Janeiro", "Curitiba",1,1,"28/09/2018", "29/09/2018", 20);
        new Thread(menu).start();
    }

    /**
     *
     * Thread para rodar o menu do servidor,
     * nele será possível cadastrar novas passagens, hotéis e pacotes.
     *
     * @author Lucas
     */
    public static Runnable menu = new Runnable() {
        @Override
        public void run() {
            Scanner scan = new Scanner(System.in);
            String option = "";
            while(!option.equalsIgnoreCase("0")){
                System.out.println("0 - Sair");
                System.out.println("1 - Cadastrar nova passagem");
                System.out.println("2 - Consultar passagens cadastradas");

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        break;
                    case "1":
                        String aux = "";
                        String destino, origem, data_ida, data_volta="";
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
                        if (ida == 1) {
                            System.out.println("Data da ida: ");
                            data_ida = scan.nextLine();
                        } else {
                            data_ida = "";
                        }
                        if (volta == 1) {
                            System.out.println("data de volta: ");
                            data_volta = scan.nextLine();
                        } else {
                            data_volta = "";
                        }
                        System.out.println("Número de pessoas: ");
                        aux = scan.nextLine();
                        num_pessoas = Integer.parseInt(aux);
                        passagensAereas.cadastrarNovaPassagem(destino, origem, ida, volta, data_ida, data_volta, num_pessoas);
                        break;
                    case "2":
                        passagensAereas.consultarPassagensPorDestino();
                        break;
                    default:
                        System.err.println("Opção Indisponível");
                        break;
                }
            }
        }
    };
}
