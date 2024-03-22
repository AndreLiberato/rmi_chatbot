import java.rmi.RemoteException;

import client.Client;

public class AppClient {
    public static void main(String[] args) throws RemoteException {

        Runnable clientRunnable = new Client();
        Thread clientThread = new Thread(clientRunnable);
        clientThread.start();
    }
}