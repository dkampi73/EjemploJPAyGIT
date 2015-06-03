package JPAyGIT.com.genericDAO;


import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionHelper {
	private static ConnectionHelper instancia=null;
	private EntityManager em;
	
	//Patron de diseño SINGLETON
	public static ConnectionHelper getInstance(){
		if (instancia==null){ 
			instancia= new ConnectionHelper();
		}
		return instancia;
	}
	
	private ConnectionHelper(){
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("TiendaOnline");
			
			em = emf.createEntityManager();
	}
	public Connection getConnection(){
		 em.getTransaction().begin();
		 Connection connection = em.unwrap(Connection.class);
		 
		 em.getTransaction().commit();  
		 return connection;
	}
	public EntityManager getEntityManager(){
		return em;
	}
	

}
