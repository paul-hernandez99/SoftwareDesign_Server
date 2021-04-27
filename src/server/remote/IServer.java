package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServer extends Remote{

  String sayHello() throws RemoteException;
  String descarga(ArrayList <String> arrayParams) throws RemoteException;

}
