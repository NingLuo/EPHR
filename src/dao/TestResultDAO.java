package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Patient;
import model.TestResult;

public class TestResultDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EPHR");
	EntityManager em = null;
	
	public TestResultDAO() {
		em = factory.createEntityManager();
	}
	
	public List<TestResult> findTestResultsByPatientId(Integer patientId) {
		em.getTransaction().begin();
		Patient p = new Patient();
		p = em.find(Patient.class, patientId);
		System.out.println("==============================================");
		System.out.println(p);
		List<TestResult> restResults = p.getTestResults();
		em.getTransaction().commit();
		return restResults;
	}
}
