/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author a1061380
 */
public class NamingService {
    
    private Registry referenciaServicoNome;
    
    public void init() throws RemoteException{
        referenciaServicoNome = LocateRegistry.createRegistry(1099);
    }
    
}
