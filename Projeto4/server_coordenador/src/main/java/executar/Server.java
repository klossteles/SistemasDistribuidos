/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import interfaces.ClientInterface;
import interfaces.ServerInterface;
import org.json.JSONArray;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Brendon & Lucas
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

//    private final ConcurrentHashMap<ClientInterface, JSONArray> interesses;

    public Server() throws RemoteException{
//        this.interesses = new ConcurrentHashMap<>();
    }

    @Override
    public String consultarPassagens() throws RemoteException{
        return passagens.consultarPassagens();
    }

    @Override
    public String consultarHospedagens() throws RemoteException{
        return hospedagens.consultarHospedagem();
    }

    @Override
    public String consultarPacotes() throws RemoteException{
        return pacotes.consultarPacotes();
    }

    @Override
    public boolean comprarPassagem(Long identificador) throws RemoteException{
        return passagens.comprarPassagem(identificador);
    }

    @Override
    public boolean comprarHospedagem(Long identificador) throws RemoteException{
        return hospedagens.comprarHospedagem(identificador);
    }

    @Override
    public boolean comprarPacote(Long id) throws RemoteException{
        return pacotes.comprarPacote(id);
    }
}
