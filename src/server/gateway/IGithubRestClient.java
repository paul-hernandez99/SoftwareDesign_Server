package server.gateway;

import java.util.ArrayList;
import java.util.HashMap;

public interface IGithubRestClient {

  public ArrayList<HashMap<String, String>> obtenerUsuarios() throws Exception;
  public ArrayList<HashMap<String, String>> obtenerOrganizaciones() throws Exception;
  public ArrayList<HashMap<String, String>> obtenerRepositorios() throws Exception;
}
