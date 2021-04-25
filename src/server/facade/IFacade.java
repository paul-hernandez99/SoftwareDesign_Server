package server.facade;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacade extends Remote{

  String sayHello() throws RemoteException;
  String operacionEjemplo() throws RemoteException;

}
