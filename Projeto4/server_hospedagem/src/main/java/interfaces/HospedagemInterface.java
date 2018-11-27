/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que define que tipos de informações podem ser consultadas ou
 * solicitadas por um cliente.
 *
 * @author Brendon & Lucas
 */
public interface HospedagemInterface extends Remote {

    String consultarHospedagens() throws RemoteException;

    boolean comprarHospedagem(Long identificador) throws RemoteException;
}
