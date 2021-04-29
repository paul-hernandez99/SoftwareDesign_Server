package server.appService;

import server.gateway.GithubRestClient;
import server.gateway.IGithubRestClient;

import java.util.ArrayList;
import java.util.HashMap;

public class AppService {

  private IGithubRestClient restClient;

  public AppService() {

    this.restClient = (IGithubRestClient) new GithubRestClient();
  }

  public String obtenerUsuarios(ArrayList<String> arrayParams) {

    String name = "";

    try {

      HashMap<String, String> res = restClient.obtenerUsuarios();
      System.out.println(res);
      name = (String)res.get("login");


    } catch (Exception e) {

      System.out.println("Catched exception: " + e.getMessage());
    }

    return name;
  }
}
