package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

import model.ClinicalSummary;
import model.Patient;

public class ClinicalSummaryDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EPHR");
	EntityManager em = null;
	
	public ClinicalSummaryDAO() {
		em = factory.createEntityManager();
	}
	
	public List<ClinicalSummary> findCsByUserId(Integer userId) {
		System.out.println("=================================================");
		System.out.println(userId);
		em.getTransaction().begin();
		Patient p = em.find(Patient.class, userId);
		System.out.println("=================================================");
		System.out.println(p.getUsername());
		p.getClinicalSummaries().size();
		List<ClinicalSummary> CSs = p.getClinicalSummaries();
		System.out.println("=================================================");
		System.out.println(CSs.toString());
		em.getTransaction().commit();
		return CSs;
	}
}
