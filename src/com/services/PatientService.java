package com.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dao.PatientDAO;
import model.Patient;
import model.User;

@Path("patient")
public class PatientService {
	
	PatientDAO dao = new PatientDAO();
	
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
}
