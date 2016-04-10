package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Provider;
import model.Medication;

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
	
	public List<Medication> getMedication(Integer providerId){
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT Medication FROM Medication, Provider WHERE Provider.id = :id");
		q.setParameter("id",providerId);
		List<Medication> meds = q.getResultList();
		em.getTransaction().commit();
		return meds;
	}

	public void prescribe(Medication med) {
		em.getTransaction().begin();
		em.persist(med);
		em.getTransaction().commit();
	}
	
}
