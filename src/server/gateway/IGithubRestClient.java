package server.gateway;

import java.util.HashMap;

public interface IGithubRestClient {

  public HashMap<String, String> obtenerUsuarios() throws Exception;

}
