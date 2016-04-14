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
	EntityManager em = null;
	
	
	public Provider getProvider(Integer id){
		em = factory.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT P FROM Provider P WHERE P.id = :id");
		q.setParameter("id", id);
		Provider provider = (Provider)q.getSingleResult();
		System.out.println("=================================================");
		System.out.println(provider.getMedications().size());
		System.out.println("=================================================");
		provider.getMedications().size();
//		provider.setMedications(provider.getMedications()); 
		em.getTransaction().commit();
		return provider;
	}
	
	public List<Medication> getMedication(Integer providerId){
		em = factory.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT m FROM Medication m JOIN m.provider p WHERE p.id = :id");
		q.setParameter("id",providerId);
		q.getResultList().size();
		List<Medication> meds = q.getResultList();
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println(meds);
		em.getTransaction().commit();
		return meds;
	}

	public void prescribe(Medication med, Integer Id) {
		System.out.println("++++++++++++++++++++++++++++++++++++ADD+++");
		System.out.println(med);
		em = factory.createEntityManager();
		Provider provider = em.getReference(Provider.class, Id);
		med.setProvider(provider);
		em.getTransaction().begin();
		em.persist(med);
		em.getTransaction().commit();
	}
	
	public Provider createProvider(Provider provider){
		em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(provider);
		em.getTransaction().commit();
		return provider;
	}
	
}
