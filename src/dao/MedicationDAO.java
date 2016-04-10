package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Medication;
import model.Patient;

public class MedicationDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EPHR");
	EntityManager em = null;
	
	public MedicationDAO() {
		em = factory.createEntityManager();
	}
	
	public List<Medication> findMedicationsByPatientId(Integer patientId) {
		em.getTransaction().begin();
		Patient p = new Patient();
		p = em.find(Patient.class, patientId);
		p.getMedications().size();
		List<Medication> medsList = p.getMedications();
		System.out.println("========================================");
		System.out.println(medsList);
		em.getTransaction().commit();
		return medsList;
	}
}
