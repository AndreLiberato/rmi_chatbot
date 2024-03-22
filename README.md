## Compile files

```
javac -d target/classes src/main/java/client/Client.java src/main/java/rmi/RemoteMethodInvocationRegistry.java src/main/java/server/Server.java src/main/java/contract/RemoteInterface.java src/main/java/AppClient.java src/main/java/AppServer.java
```

## Starting Server Application

```
java -cp target/classes AppServer
```

## Starting Client Application

```
java -cp target/classes AppClient
```