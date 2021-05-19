package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IFacade extends Remote{

  String sayHello() throws RemoteException;
  String descargarUsuarios() throws RemoteException;
  String descargarOrganizaciones() throws RemoteException;
}
