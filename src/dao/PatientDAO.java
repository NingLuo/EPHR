package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Gender;
import model.Patient;

public class PatientDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EPHR");
	EntityManager em = null;
	
	public PatientDAO() {
		em = factory.createEntityManager();
	}
	
	public void createPatient(Patient patient) {
		em.getTransaction().begin();
		em.persist(patient);
		em.getTransaction().commit();
	}

	public void updatePatient(Patient p) {
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
	}
}
