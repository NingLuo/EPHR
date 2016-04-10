package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dao.ClinicalSummaryDAO;
import dao.ContactInfoDAO;
import dao.MedicationDAO;
import dao.PatientDAO;
import dao.TestResultDAO;
import model.ClinicalSummary;
import model.ContactInfo;
import model.Medication;
import model.Patient;
import model.TestResult;

@Path("patient")
public class PatientService {
	
	PatientDAO dao = new PatientDAO();
	ClinicalSummaryDAO csdao = new ClinicalSummaryDAO();
	TestResultDAO trdao = new TestResultDAO();
	MedicationDAO meddao = new MedicationDAO();
	ContactInfoDAO contactInfoDao = new ContactInfoDAO();
	
	@POST
	@Path("/")
	@Consumes("application/json")
	public void createPatient(Patient patient) {
		System.out.println(patient);
		dao.createPatient(patient);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public void updatePatient(Patient p) {
		dao.updatePatient(p);
	}
	
	@GET
	@Path("/{id}/clinicalSummaries")
	@Consumes("application/json")
	@Produces("application/json")
	public List<ClinicalSummary> findCsByUserId(@PathParam("id") Integer userId) {
		List<ClinicalSummary> CSs = csdao.findCsByUserId(userId);
		return CSs;
	}
	
	@GET
	@Path("/{id}/testResults")
	@Consumes("application/json")
	@Produces("application/json")
	public List<TestResult> findTestResultsByPatientId(@PathParam("id") Integer patientId) {
		List<TestResult> testResults = trdao.findTestResultsByPatientId(patientId);
		return testResults;
	}
	
	@GET
	@Path("/{id}/medications")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Medication> findMedicationsByPatientId(@PathParam("id") Integer patientId) {
		List<Medication> medsList = meddao.findMedicationsByPatientId(patientId);
		return medsList;
	}
	
	@GET
	@Path("/{id}/contactInfoList")
	@Consumes("application/json")
	@Produces("application/json")
	public List<ContactInfo> findContactInfoListByPatientId(@PathParam("id") Integer patientId) {
		System.out.println("==============================");
		System.out.println("contact Info dao says hello");
		List<ContactInfo> contactInfoList = contactInfoDao.findContactInfoListByUserId(patientId);
		return contactInfoList;
	}
	
	@PUT
	@Path("/{id}/contactInfoList")
	@Consumes("application/json")
	@Produces("application/json")
	public void updateContactInfoList(@PathParam("id") Integer patientId, List<ContactInfo> contactInfoList) {
//		Patient p = new Patient();
//		p = dao.findPatientByPatientId(patientId);
//		p.setContactInfoList(contactInfoList);
		System.out.println("==============================");
		System.out.println("update contact Info List in Patient Service says hello");
		contactInfoDao.updateContactInfoByPatientId(patientId, contactInfoList);
	}
}
