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
            @SuppressWarnings("unchecked")
            Query<Investigador> investigadorQuery = this.persistentManager.newQuery("SELECT * FROM " + Investigador.class.getName());

            for (Investigador investigador : investigadorQuery.executeList()) {
                //No tengo claro como funciona el parseo de Query<Investigador> a List<Investigador>
                //System.out.println("- Selected from db: " + investigador.nombre);
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
}
