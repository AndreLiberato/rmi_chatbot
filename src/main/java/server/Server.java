package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import contract.RemoteInterface;

public class Server extends UnicastRemoteObject implements RemoteInterface, Runnable {
    private Registry registry;

    public Server() throws RemoteException {
        super();
    }

    @Override
    public String send(String message) throws RemoteException {
        // ChatBot cBot = new ChatBot("auxiliar/menssage.txt");

        System.out.println("Client message: " + message);
        return message;
        // return cBot.Mensagem(message);
    }

    @Override
    public void run() {
            try {
                this.registry  = LocateRegistry.getRegistry("localhost");
                registry.rebind("remote", this);
            } catch (RemoteException e) {
                System.err.println("Run error: " + e.getMessage());
                e.printStackTrace();
            }
        System.out.println("Server online.");
    }
}
