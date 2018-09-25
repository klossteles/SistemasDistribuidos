/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacoes;

import interfaces.InterfaceCli;
import interfaces.InterfaceServ;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author a1061380
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ {

    private final Map<String, InterfaceCli> clientes;

    public ServImpl() {
        clientes = new HashMap<>();
    }
    
    @Override
    public void chamar(String nome, InterfaceCli ref) throws RemoteException {
        clientes.put(nome, ref);
        ref.echo(nome);
    }
    
}
