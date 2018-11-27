/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import interfaces.CoordHospedagemInterface;
import interfaces.HospedagemInterface;
import org.json.JSONArray;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Brendon & Lucas
 */
public class Hospedagem extends UnicastRemoteObject implements HospedagemInterface {

    private final hospedagem.Hospedagem hospedagens;

    public Hospedagem() throws RemoteException{
        this.hospedagens = new hospedagem.Hospedagem();
    }

    public hospedagem.Hospedagem getHospedagens(){
        return hospedagens;
    }

    @Override
    public String consultarHospedagens() throws RemoteException{
        return hospedagens.consultarHospedagem();
    }

    @Override
    public boolean comprarHospedagem(Long identificador) throws RemoteException{
        return hospedagens.comprarHospedagem(identificador);
    }
}
