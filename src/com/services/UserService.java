package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import model.ClinicalSummary;
import model.Provider;
import model.Patient;
import model.User;
import dao.ClinicalSummaryDAO;
import dao.UserDAO;
import dao.PatientDAO;
import dao.ProviderDAO;

@Path("user")
public class UserService {
	UserDAO dao = new UserDAO();
	PatientDAO patientDao = new PatientDAO();
	ProviderDAO providerDao = new ProviderDAO();
		
	@GET
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public User findUserByCredentials(@QueryParam("username") String username, @QueryParam("password") String password) {
		User p;
		p = dao.findUserByCredentials(username, password);
		if(p.getRole() == 1)
			{
				Provider R = (Provider) dao.findUserByCredentials(username, password);
				return R;
			}
		return p;
	}
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public User findUserById(@PathParam("id") Integer userId) {
		Provider p = new Provider();
		p = (Provider)dao.findUserById(userId);
		if(p.getRole() == 0)
		{
			Patient R = (Patient) dao.findUserById(userId);
			return R;
		}
		return p;
	}
}
