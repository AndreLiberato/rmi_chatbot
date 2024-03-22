package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import contract.RemoteInterface;

public class Client implements Runnable {
    private Registry registry;
    private RemoteInterface server;

    public Client() {
        try {
            this.registry = LocateRegistry.getRegistry("localhost");
            this.server = (RemoteInterface) registry.lookup("remote");
        } catch (RemoteException | NotBoundException e) {
            System.err.println("Constructor Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        boolean exit = false;
        Scanner scannerIn = new Scanner(System.in);
        do {
            System.out.print("Client: ");
            String clientMessage = scannerIn.nextLine();

            String serverResponse = new String();

            try {
                serverResponse = server.send(clientMessage);
            } catch (RemoteException e) {
                System.err.println("Error to send message to server!");
                e.printStackTrace();
            }

            System.out.println("Resposta do servidor: " + serverResponse);

            if (serverResponse.equals("Tchau")) {
                exit = true;
            }
        } while (!exit);

        scannerIn.close();
    }
}
