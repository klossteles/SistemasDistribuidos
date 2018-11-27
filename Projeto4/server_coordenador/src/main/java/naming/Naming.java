/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naming;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Brendon
 */
public class Naming {
    private final Registry servicoNomes;

    public Naming(Remote server) throws RemoteException {
        this.servicoNomes = LocateRegistry.createRegistry(1099);
        this.servicoNomes.rebind("server", server);
    }
}
