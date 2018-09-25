/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author a1061380
 */
import java.rmi.*;

public interface InterfaceServ extends Remote {
    void chamar(String nome, InterfaceCli ref) throws RemoteException;
}