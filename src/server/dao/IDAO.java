package server.dao;

import server.LD.Investigador;
import java.util.ArrayList;
import java.util.HashMap;

public interface IDAO
{
    public ArrayList<Investigador> getInvestigadores();
    public void uploadInvestigadores(ArrayList<HashMap<String, String>> investigadores); //Nose si tendremos en list o en jsonarray o en qué.
    public void uploadOrganizaciones(ArrayList<HashMap<String, String>> organizaciones);
    public void uploadRepositorios(ArrayList<HashMap<String, String>> repositorios);
}
