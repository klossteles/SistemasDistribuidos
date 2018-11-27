/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import interfaces.CoordPassagemInterface;
import interfaces.PassagemInterface;
import org.json.JSONArray;
import passagemAerea.PassagemAerea;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Brendon & Lucas
 */
public class CoordPassagem extends UnicastRemoteObject implements CoordPassagemInterface {

    private final PassagemAerea passagens;

    public CoordPassagem() throws RemoteException{
        this.passagens = new PassagemAerea();
    }

    public PassagemAerea getPassagens(){
        return passagens;
    }

    @Override
    public String consultarPassagens() throws RemoteException{
        return passagens.consultarPassagens();
    }

    @Override
    public boolean comprarPassagem(Long identificador) throws RemoteException{
        return passagens.comprarPassagem(identificador);
    }
}
