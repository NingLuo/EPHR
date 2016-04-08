package com.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import model.User;
import dao.UserDAO;

@Path("user")
public class UserService {
	UserDAO dao = new UserDAO();
	
	@POST
	@Path("/")
	@Consumes("application/json")
	public void createUser(User user) {
		System.out.println(user);
		dao.createUser(user);
	}
}
