package server.remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import server.appService.AppService;

public class Facade extends UnicastRemoteObject implements IFacade {

	protected Facade() throws RemoteException
	{
		super();
	}

  @Override
  public String sayHello() throws RemoteException {
    System.out.println("Client connected!");
    return "Hello World!";
  }

  @Override
  public String descargarUsuarios() throws RemoteException{
    return AppService.getInstance().obtenerUsuarios();
  }

  @Override
  public String descargarOrganizaciones() throws RemoteException {
		return AppService.getInstance().obtenerOrganizaciones();
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
