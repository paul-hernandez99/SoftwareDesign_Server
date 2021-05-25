package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;


public interface IFacade extends Remote{

  String sayHello() throws RemoteException;
  String descargarUsuarios(HashMap<String,String> datos) throws RemoteException;
  String descargarOrganizaciones(HashMap<String,String> datos) throws RemoteException;
  String descargarRepositorios(HashMap<String,String> datos) throws RemoteException;
}
