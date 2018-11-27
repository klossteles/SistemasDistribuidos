/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import interfaces.ClientInterface;
import interfaces.CoordInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Brendon
 */
public class Client extends UnicastRemoteObject implements ClientInterface{

    private final CoordInterface server;
    
    public Client(CoordInterface server) throws RemoteException{
        this.server = server;
    }
    
    @Override
    public void notificarEvento(String mensagem) throws RemoteException{
        System.err.println(mensagem);
    }

}
