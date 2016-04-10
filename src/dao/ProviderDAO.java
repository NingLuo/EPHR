package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Provider;

public class ProviderDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EPHR");
	EntityManager em = factory.createEntityManager();
	
	
	public Provider getProvider(Integer id){
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT Provider FROM Provider WHERE Provider.id = :id");
		q.setParameter("id", id);
		Provider provider = (Provider)q.getSingleResult();
		em.getTransaction().commit();
		return provider;
	}
}
