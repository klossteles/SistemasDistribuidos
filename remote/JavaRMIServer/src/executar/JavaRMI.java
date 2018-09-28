/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import implementacoes.ServImpl;
import interfaces.InterfaceServ;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author a1061380
 */
public class JavaRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry referenciaServicoNomes = LocateRegistry.createRegistry(1099);
        InterfaceServ serv = new ServImpl();
        referenciaServicoNomes.bind("server", serv);
    }
    
}
