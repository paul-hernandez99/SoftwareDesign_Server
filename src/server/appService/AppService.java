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
  private ArrayList<Investigador> investigadores;

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
      this.IDao = (IDAO) new DAO();
      this.res = restClient.obtenerUsuarios();
      this.IDao.uploadInvestigadores(this.res);

      /*DAO a = new DAO();
      ArrayList <Investigador> ab = a.getInvestigadores();
      System.out.println(ab);*/

    } catch (Exception e) {
      System.out.println("Catched exception: " + e.getMessage());
    }
    return "Correct dowload users!";
  }

  public String obtenerOrganizaciones() {

    try {
      this.IDao = (IDAO) new DAO();
      this.res = restClient.obtenerOrganizaciones();
      this.IDao.uploadOrganizaciones(this.res);

    } catch (Exception e) {
      System.out.println("Catched exception: " + e.getMessage());
    }
    return "Correct download organizations!";
  }

  public String obtenerRepositorios() {

    try {
      this.IDao = (IDAO) new DAO();
      this.investigadores = this.IDao.getInvestigadores();
      for(int i=0; i<3; i++) {
        this.IDao = (IDAO) new DAO();
        this.res = this.restClient.obtenerRepositorios("users/"+investigadores.get(i).getNombre()+"/repos");
        this.IDao.uploadRepositorios(this.res);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    return "Correct download repositories!";
  }

}
