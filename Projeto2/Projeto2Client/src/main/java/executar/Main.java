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
                System.out.println("2 - Consultar Hospedagens cadastradas");
                System.out.println("3 - Consultar Pacotes cadastradas");

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
                        try {
                            System.out.println(serv.consultarHospedagens());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "3":
                        try {
                            System.out.println(serv.consultarPacotes());
                        } catch (RemoteException e) {
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
