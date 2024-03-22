package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteMethodInvocationRegistry {
    public RemoteMethodInvocationRegistry() throws RemoteException {
        LocateRegistry.createRegistry(1099);
        System.out.println("RMIRegistry initialized.");
    }
}
