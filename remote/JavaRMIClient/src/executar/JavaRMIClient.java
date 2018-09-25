/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *`
 * @author a1061380
 */
public class JavaRMIClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry referenciaServicoNomes = LocateRegistry.getRegistry();
        } catch (RemoteException ex) {
            Logger.getLogger(JavaRMIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
