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
import java.time.Instant;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Brendon
 */
public class Main {

    private static final String TIPO_INTERESSE_PASSAGEM = "PASSAGEM";
    private static final String TIPO_INTERESSE_HOSPEDAGEM = "HOSPEDAGEM";
    private static final String TIPO_INTERESSE_PACOTE = "PACOTE";

    public static ServerInterface server;
    public static Client client;

    public static void main(String[] args) throws RemoteException, NotBoundException{
        Registry servicoNomes = LocateRegistry.getRegistry();
        server = (ServerInterface) servicoNomes.lookup("server");
        client = new Client(server);

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
                System.out.println("7 - Cadastrar Registro de Interesse");
                System.out.println("8 - Remover Registro de Interesse");

                option = scan.nextLine();
                switch(option) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        try {
                            System.out.println(server.consultarPassagens());
                        } catch(RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "2":
                        try {
                            System.out.println("=====PASSAGENS=====");
                            System.out.println(server.consultarPassagens());
                            System.out.println("Informar o identificador da passagem");
                            String aux = scan.nextLine();
                            Long id = Long.parseLong(aux);
                            boolean result = server.comprarPassagem(id);
                            if(result){
                                System.out.println("Passagem comprada.");
                            } else{
                                System.out.println("Ocorreu um erro ao comprar a passagem");
                            }
                        } catch(RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "3":
                        try {
                            System.out.println(server.consultarHospedagens());
                        } catch(RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "4":
                        try {
                            System.out.println("=====HOSPEDAGENS=====");
                            System.out.println(server.consultarHospedagens());
                            System.out.println("Informar o identificador da hospedagem");
                            String aux = scan.nextLine();
                            Long id = Long.parseLong(aux);
                            boolean result = server.comprarHospedagem(id);
                            if(result){
                                System.out.println("Hospedagem comprada.");
                            } else{
                                System.out.println("Ocorreu um erro ao comprar a hospedagem");
                            }
                        } catch(RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "5":
                        try {
                            System.out.println(server.consultarPacotes());
                        } catch(RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "6":
                        try {
                            System.out.println();
                            System.out.println("=====PACOTES=====");
                            String pacotes = server.consultarPacotes();

                            if(!pacotes.isEmpty()){
                                System.out.println(pacotes);
                                System.out.println("Informar o identificador do pacote");
                                String aux = scan.nextLine();
                                Long id = Long.parseLong(aux);
                                boolean result = server.comprarPacote(id);
                                if(result){
                                    System.out.println("Pacote comprado.");
                                } else{
                                    System.out.println("Ocorreu um erro ao comprar o pacote");
                                }
                            }else{
                                System.out.println("Não existem Pacotes disponíveis para compra.");
                                System.out.println();
                            }
                        } catch(RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "7": {
                        try {
                            menuRegistroInteresse(scan);
                        } catch(RemoteException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    case "8":
                        removerRegistroInteresse(scan);
                        break;
                    default:
                        System.err.println("Opção Indisponível");
                        break;
                }
            }
        }
    };

    private static void menuRegistroInteresse(Scanner scan) throws RemoteException{
        System.out.println();
        System.out.println("===== REGISTRO DE INTERESSE =====");
        System.out.println("1 - Passagem");
        System.out.println("2 - Hospedagem");
        System.out.println("3 - Pacote");
        System.out.println();
        System.out.println("Opcão: ");
        String opcao = scan.nextLine();

        JSONObject dadosInteresse = new JSONObject();
        switch(opcao) {
            case "1":
                dadosInteresse.put("TIPO_INTERESSE", TIPO_INTERESSE_PASSAGEM);
                getDadosInteresse(scan, dadosInteresse);
                server.registrarInteresse(dadosInteresse.toString(), client);
                break;
            case "2":
                dadosInteresse.put("TIPO_INTERESSE", TIPO_INTERESSE_HOSPEDAGEM);
                getDadosInteresse(scan, dadosInteresse);
                server.registrarInteresse(dadosInteresse.toString(), client);
                break;
            case "3":
                dadosInteresse.put("TIPO_INTERESSE", TIPO_INTERESSE_PACOTE);
                getDadosInteresse(scan, dadosInteresse);
                server.registrarInteresse(dadosInteresse.toString(), client);
                break;
            default:
                System.out.println("Opção inválida");
        }
        System.out.println();
    }

    private static void getDadosInteresse(Scanner scan, JSONObject dadosInteresse){
        String destino, precoMaximo;

        System.out.println("Informe o Destino desejado:");
        destino = scan.nextLine();

        System.out.println("Informe o Preço Máximo:");
        precoMaximo = scan.nextLine();

        dadosInteresse.put("ID", Instant.now().toEpochMilli());
        dadosInteresse.put("DESTINO", destino);
        dadosInteresse.put("PRECO", Double.parseDouble(precoMaximo));
    }

    private static void removerRegistroInteresse(Scanner scan){
        try {
            //Consulta os registros
            String registrosDeInteresse = client.consultarRegistrosInteresse();

            if(registrosDeInteresse.equals("VAZIO")){
                System.out.println();
                System.out.println("Não há registro de interesse cadastrados para esse cliente.");
            } else{
                System.out.println(registrosDeInteresse);
                System.out.println("Insira o Identificador do registro a ser Removido:");
                String opcao = scan.nextLine();
                if(!opcao.isEmpty()){
                    Long id = Long.parseLong(opcao);
                    server.removerInteresse(id, client);
                }
            }
        } catch(RemoteException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
