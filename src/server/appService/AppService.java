package server.appService;

import server.gateway.GithubRestClient;
import server.gateway.IGithubRestClient;

import java.util.ArrayList;
import java.util.HashMap;
import server.dao.IDAO;
import server.dao.DAO;
import server.LD.Investigador;

public class AppService {

  private IGithubRestClient restClient;
  private ArrayList<HashMap<String, String>> res;
  private IDAO IDao;

  private static AppService appservice = new AppService();//Singleton

  private AppService() {

    this.restClient = (IGithubRestClient) new GithubRestClient();
  }
  //Método para obtener instancia única del appService
  public static AppService getInstance()
  {
    return appservice;
  }

  public String obtenerUsuarios() {

    try {
      this.res = restClient.obtenerUsuarios();
      this.IDao = (IDAO) new DAO();
      this.IDao.uploadInvestigadores(this.res);

      /*DAO a = new DAO();
      ArrayList <Investigador> ab = a.getInvestigadores();
      System.out.println(ab);*//

    } catch (Exception e) {
      System.out.println("Catched exception: " + e.getMessage());
    }
    return "Correct!";
  }

  public String obtenerOrganizaciones() {

    try {
      this.res = restClient.obtenerOrganizaciones();
      this.IDao = (IDAO) new DAO();
      this.IDao.uploadOrganizaciones(this.res);

    } catch (Exception e) {
      System.out.println("Catched exception: " + e.getMessage());
    }
    return "Correct download organizations!";
  }

  public String obtenerRepositorios() {

    try {
      this.IDao = (IDAO) new DAO();
      ArrayList <Investigador> ab = this.IDao.getInvestigadores();

      this.res = restClient.obtenerRepositorios();

      this.IDao.uploadRepositorios(this.res);

    } catch (Exception e) {
      System.out.println("Catched exception: " + e.getMessage());
    }
    return "Correct download repositorios!";
  }

}
