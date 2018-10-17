/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.json.JSONArray;

/**
 * Interface que define que tipos de informações podem ser consultadas ou 
 * solicitadas por um cliente.
 * 
 * @author Brendon & Lucas
 */
public interface ServerInterface extends Remote{
    JSONArray consultarPassagensPorDestino()   throws RemoteException;
    JSONArray consultarHospedagensPorDestino() throws RemoteException;
    JSONArray consultarPacotesPorDestino()     throws RemoteException;
    
    boolean registrarInteressePassagem(String passagem)  throws RemoteException;
    boolean registrarInteresseHospedagem(String hospedagem) throws RemoteException;
    boolean registrarInteressePacote(String pacote)             throws RemoteException;
    
    boolean removerInteressePassagem(String passagem)  throws RemoteException;
    boolean removerInteresseHospedagem(String hospedagem) throws RemoteException;
    boolean removerInteressePacote(String pacote)             throws RemoteException;
}
