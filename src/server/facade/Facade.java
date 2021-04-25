package server.facade;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import server.appService.AppService;

import server.facade.IFacade;

public class Facade extends UnicastRemoteObject implements IFacade {

  private AppService appService;

	protected Facade() throws RemoteException
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
  public String operacionEjemplo() throws RemoteException{
    return appService.operacionEjemplo();
  }

  public static void main(String [] args) {

    String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try
		{
			IFacade server = new Facade();
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
