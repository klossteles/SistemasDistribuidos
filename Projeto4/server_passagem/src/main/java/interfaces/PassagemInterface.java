/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Brendon
 */
public interface PassagemInterface extends Remote{
    String consultarPassagens() throws RemoteException;
    boolean comprarPassagem(Long identificador) throws RemoteException;
}
