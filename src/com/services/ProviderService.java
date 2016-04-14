package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import dao.PatientDAO;
import dao.ProviderDAO;
import model.Medication;
import model.Patient;
import model.User;
import model.Provider;

@Path("/provider")
public class ProviderService {
	ProviderDAO dao = new ProviderDAO();
	
	@GET
	@Path("/{providerId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Provider providerProfile(@PathParam("providerId") Integer id){
	Provider p;
	p = dao.getProvider(id);
	return p;
	}
	
	@GET
	@Path("/{providerId}/medication")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Medication> getMedication(@PathParam("providerId") Integer providerId){
		List<Medication> meds = dao.getMedication(providerId);
		return meds;
	}
	
	@POST
	@Path("/medication/{providerId}")
	@Consumes("application/json")
	public void prescribe(Medication med,@PathParam("providerId") Integer providerId){
//		System.out.println("__prescribe____"+med.getProvider()+"_________");
		dao.prescribe(med,providerId);	
	}	
	
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Provider createUser(Provider user){
			Provider provider = (Provider)user;
			return dao.createProvider(provider);
		}
}