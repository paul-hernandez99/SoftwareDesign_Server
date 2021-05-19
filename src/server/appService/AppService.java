package server.appService;

import server.gateway.GithubRestClient;
import server.gateway.IGithubRestClient;

import java.util.ArrayList;
import java.util.HashMap;
import server.dao.IDAO;
import server.dao.DAO;

public class AppService {

  private IGithubRestClient restClient;
  private ArrayList<HashMap<String, String>> res;
  private IDAO IDao;

  public AppService() {
    this.IDao = (IDAO) new DAO();
    this.restClient = (IGithubRestClient) new GithubRestClient();
  }

  public String obtenerUsuarios() {

    try {
      this.res = restClient.obtenerUsuarios();
      this.IDao.uploadInvestigadores(this.res);

    } catch (Exception e) {
      System.out.println("Catched exception: " + e.getMessage());
    }
    return "Correct!";
  }
}
