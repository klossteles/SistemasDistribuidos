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

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCli extends Remote {
   void echo(String nome) throws RemoteException;
}
