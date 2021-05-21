package server.dao;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import server.LD.Investigador;
import server.LD.Organizacion;
import server.LD.Repositorio;
import javax.jdo.Extent;

public class DAO implements IDAO
{
    PersistenceManagerFactory persistentManagerFactory;
    PersistenceManager persistentManager;
    Transaction transaction;

    public DAO()
    {
        this.persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        this.persistentManager = this.persistentManagerFactory.getPersistenceManager();
        this.transaction = this.persistentManager.currentTransaction();
    }

    @Override
    public ArrayList<Investigador> getInvestigadores(){

        ArrayList<Investigador> listaInvestigadores = new ArrayList<Investigador>();

        try {
            transaction.begin();

            Extent<Investigador> extentInv = persistentManager.getExtent(Investigador.class, true);

            for (Investigador i : extentInv)
            {
                listaInvestigadores.add(i);
            }
            transaction.commit();
        }
        catch(Exception ex) {
            System.err.println("* Exception executing a query: " + ex.getMessage());
        }
        finally {
            if (transaction.isActive())
            transaction.rollback();
            persistentManager.close();
        }
        return listaInvestigadores;
    }

    @Override
    public void uploadInvestigadores(ArrayList<HashMap<String, String>> investigadores) {

      try {
          this.transaction.begin();

        for(int i=0; i<investigadores.size(); i++) {
          persistentManager.makePersistent(new Investigador(investigadores.get(i).get("login"),"","",0));
        }

			  this.transaction.commit();

			} catch(Exception ex) {

				System.err.println("* Exception executing a query: " + ex.getMessage());

			} finally {

				if (this.transaction.isActive())
        	this.transaction.rollback();
				this.persistentManager.close();
			}
  }

    @Override
    public void uploadOrganizaciones(ArrayList<HashMap<String, String>> organizaciones) {

        try {
            this.transaction.begin();

            for(int i=0; i<organizaciones.size(); i++) {
                persistentManager.makePersistent(new Organizacion(organizaciones.get(i).get("login"),"",organizaciones.get(i).get("description"),""));
            }

            this.transaction.commit();

        } catch(Exception ex) {

            System.err.println("* Exception executing a query: " + ex.getMessage());

        } finally {

            if (this.transaction.isActive())
                this.transaction.rollback();
            this.persistentManager.close();
        }
    }

    @Override
    public void uploadRepositorios(ArrayList<HashMap<String, String>> repositorios) {

        try {
            this.transaction.begin();
            for(int i=0; i<repositorios.size(); i++) {

                persistentManager.makePersistent(new Repositorio(repositorios.get(i).get("name"), "", ""));
            }

            this.transaction.commit();

            System.out.println("Repositories of the user saved in the BD correctly!");

        } catch(Exception ex) {

            System.err.println("* Exception executing a query: " + ex.getMessage());

        } finally {

            if (this.transaction.isActive())
                this.transaction.rollback();
            this.persistentManager.close();
        }
    }
}
