package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ContactInfo;
import model.Medication;
import model.Patient;

public class ContactInfoDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EPHR");
	EntityManager em = null;
	
	public ContactInfoDAO() {
		em = factory.createEntityManager();
	}
	
	public List<ContactInfo> findContactInfoListByUserId(Integer patientId) {
		em.getTransaction().begin();
		Patient p = new Patient();
		p = em.find(Patient.class, patientId);
		p.getContactInfoList().size();
		List<ContactInfo> contactInfoList = p.getContactInfoList();
		System.out.println("========================================");
		System.out.println(contactInfoList);
		em.getTransaction().commit();
		return contactInfoList;
	}
}
