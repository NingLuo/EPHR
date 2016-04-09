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
import model.Patient;
import model.User;
import dao.ClinicalSummaryDAO;
import dao.UserDAO;

@Path("user")
public class UserService {
	UserDAO dao = new UserDAO();
		
	@GET
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public User findUserByCredentials(@QueryParam("username") String username, @QueryParam("password") String password) {
		Patient p = new Patient();
		p = (Patient)dao.findUserByCredentials(username, password);
		return p;
	}
	
	@GET
	@Path("/{id}")
	@Consumes("application/json")
	@Produces("application/json")
	public User findUserById(@PathParam("id") Integer userId) {
		Patient p = new Patient();
		p = (Patient)dao.findUserById(userId);
		return p;
	}
}
