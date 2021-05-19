package server.gateway;

import java.util.ArrayList;
import java.util.HashMap;

public interface IGithubRestClient {

  public ArrayList<HashMap<String, String>> obtenerUsuarios() throws Exception;

}
