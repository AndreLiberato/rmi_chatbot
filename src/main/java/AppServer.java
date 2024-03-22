import java.rmi.RemoteException;

import rmi.RemoteMethodInvocationRegistry;
import server.Server;

public class AppServer {
    public static void main(String[] args) {
        try {
            new RemoteMethodInvocationRegistry();
        } catch (RemoteException e) {
            System.err.println("RMIRegistry error: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            Runnable serverRunnable = new Server();
            Thread serverThread = new Thread(serverRunnable);
            serverThread.start();
        } catch (RemoteException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
