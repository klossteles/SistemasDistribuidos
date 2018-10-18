/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executar;

import PassagemAerea.PassagemAerea;
import hospedagem.Hospedagem;
import interfaces.ServerInterface;
import pacotes.Pacote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Brendon & Lucas
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

    private final PassagemAerea passagens;
    private final Hospedagem hospedagens;
    private final Pacote pacotes;

    public Server() throws RemoteException{
        this.passagens = new PassagemAerea();
        this.hospedagens = new Hospedagem();
        this.pacotes = new Pacote();
    }

    public PassagemAerea getPassagens(){
        return passagens;
    }

    public Hospedagem getHospedagens(){
        return hospedagens;
    }

    public Pacote getPacotes(){
        return pacotes;
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
}
