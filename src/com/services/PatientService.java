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
import dao.PatientDAO;
import dao.TestResultDAO;
import model.ClinicalSummary;
import model.Patient;
import model.TestResult;

@Path("patient")
public class PatientService {
	
	PatientDAO dao = new PatientDAO();
	ClinicalSummaryDAO csdao = new ClinicalSummaryDAO();
	TestResultDAO trdao = new TestResultDAO();
	
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
}
