package server.dao;

import server.LD.Investigador;

public interface DAO
{
    public List<Investigador> getInvestigadores();
    public void uploadInvestigadores(List<Investigador>); //Nose si tendremos en list o en jsonarray o en qué.

}
