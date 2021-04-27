package server.remote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import server.appService.AppService;

import server.remote.IServer;

public class Server extends UnicastRemoteObject implements IServer {

  private AppService appService;

	protected Server() throws RemoteException
	{
		super();
    this.appService = new AppService();
	}

  @Override
  public String sayHello() throws RemoteException {
    System.out.println("Client connected!");
    return "Hello World!";
  }

  @Override
  public String descarga(ArrayList <String> arrayParams) throws RemoteException{
    return appService.descarga(arrayParams);
  }

  public static void main(String [] args) {

    String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try
		{
			IServer server = new Server();
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			registry.rebind(name, server);
			System.out.println("* Server '" + name + "' active and waiting...");
		}
		catch (Exception e)
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
  }
}
