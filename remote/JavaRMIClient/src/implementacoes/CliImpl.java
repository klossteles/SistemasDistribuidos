package implementacoes;

import interfaces.InterfaceCli;
import interfaces.InterfaceServ;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CliImpl extends UnicastRemoteObject implements InterfaceCli {

    private InterfaceServ interfaceServ;

    public CliImpl(InterfaceServ interfaceServ) throws RemoteException {
        this.interfaceServ = interfaceServ;
        this.interfaceServ.chamar("HUE", this);
    }

    @Override
    public void echo(String nome) throws RemoteException {
        System.out.println(nome);
    }
}
