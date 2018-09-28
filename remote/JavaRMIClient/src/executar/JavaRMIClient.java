/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import implementacoes.CliImpl;
import interfaces.InterfaceServ;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *`
 * @author a1061380
 */
public class JavaRMIClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry referenciaServicoNomes = LocateRegistry.getRegistry();
        InterfaceServ interfaceServ = (InterfaceServ) referenciaServicoNomes.lookup("server");
        new CliImpl(interfaceServ);

    }
    
}
