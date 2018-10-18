/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import interfaces.ServerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.json.JSONArray;

/**
 *
 * @author Brendon
 */
public class Server extends UnicastRemoteObject implements ServerInterface{
    private final ServerInterface server;

    public Server(ServerInterface server) throws RemoteException{
        this.server = server;
    }
    
    /*
    Aqui dentro fazer os métodos locais que irão chamar os métodos remotos do
    servidor. Verificar exemplo do RMIHelloWorld feito em sala.
    */

    @Override
    public String consultarPassagens() throws RemoteException{
        return server.consultarPassagens();
    }

    @Override
    public String consultarHospedagens() throws RemoteException{
        return server.consultarHospedagens();
    }

    @Override
    public String consultarPacotes() throws RemoteException{
        return server.consultarPacotes();
    }

    @Override
    public boolean registrarInteressePassagem(String passagem) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarInteresseHospedagem(String hospedagem) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registrarInteressePacote(String pacote) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removerInteressePassagem(String passagem) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removerInteresseHospedagem(String hospedagem) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removerInteressePacote(String pacote) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean comprarPassagem(Long identificador) throws RemoteException {
        return server.comprarPassagem(identificador);
    }

    @Override
    public boolean comprarHospedagem(Long identificador) throws RemoteException {
        return server.comprarHospedagem(identificador);
    }

    @Override
    public boolean comprarPacote(Long id) throws RemoteException {
        return server.comprarPacote(id);
    }
}
