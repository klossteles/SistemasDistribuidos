/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import interfaces.ServerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Brendon
 */
public class Main {
    public static Server serv ;
    public static void main(String[] args) throws RemoteException, NotBoundException{
        Registry servicoNomes = LocateRegistry.getRegistry();
        ServerInterface server = (ServerInterface) servicoNomes.lookup("server");
        serv = new Server(server);

        new Thread(menu).start();
    }

    public static Runnable menu = new Runnable() {
        @Override
        public void run(){
            Scanner scan = new Scanner(System.in);
            String option = "";
            while(!option.equalsIgnoreCase("0")){
                System.out.println("0 - Sair");
                System.out.println("1 - Consultar passagens cadastradas");
                System.out.println("2 - Comprar passagem");
                System.out.println("3 - Consultar Hospedagens cadastradas");
                System.out.println("4 - Comprar hospedagem");
                System.out.println("5 - Consultar Pacotes cadastradas");
                System.out.println("6 - Comprar pacotes");

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        try {
                            System.out.println(serv.consultarPassagens());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "2":
                        try {System.out.println("=====PASSAGENS=====");
                            System.out.println(serv.consultarPassagens());
                            System.out.println("Informar o identificador da passagem");
                            String aux = scan.nextLine();
                            Long id = Long.parseLong(aux);
                            boolean result = serv.comprarPassagem(id);
                            if (result) {
                                System.out.println("Passagem comprada.");
                            } else {
                                System.out.println("Ocorreu um erro ao comprar a passagem");
                            }
                        } catch (RemoteException e){
                            e.printStackTrace();
                        }
                        break;
                    case "3":
                        try {
                            System.out.println(serv.consultarHospedagens());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "4":
                        try {
                            System.out.println("=====HOSPEDAGENS=====");
                            System.out.println(serv.consultarHospedagens());
                            System.out.println("Informar o identificador da hospedagem");
                            String aux = scan.nextLine();
                            Long id = Long.parseLong(aux);
                            boolean result = serv.comprarHospedagem(id);
                            if (result) {
                                System.out.println("Hospedagem comprada.");
                            } else {
                                System.out.println("Ocorreu um erro ao comprar a hospedagem");
                            }
                        } catch (RemoteException e){
                            e.printStackTrace();
                        }
                        break;
                    case "5":
                        try {
                            System.out.println(serv.consultarPacotes());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "6":
                        try {
                            System.out.println("=====PACOTES=====");
                            System.out.println(serv.consultarPacotes());
                            System.out.println("Informar o identificador do pacote");
                            String aux = scan.nextLine();
                            Long id = Long.parseLong(aux);
                            boolean result = serv.comprarPacote(id);
                            if (result) {
                                System.out.println("Pacote comprado.");
                            } else {
                                System.out.println("Ocorreu um erro ao comprar o pacote");
                            }
                        } catch (RemoteException e){
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.err.println("Opção Indisponível");
                        break;
                }
            }
        }
    };
}
