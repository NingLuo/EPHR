package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.User;

public class UserDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("EPHR");
	EntityManager em = null;
	
	public UserDAO() {
		em = factory.createEntityManager();
	}
	
	public User findUserByCredentials(String username, String password) {
		em.getTransaction().begin();
		Query query = em.createQuery("select u from User u where u.username=:username and u.password=:password", User.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		User user = (User)query.getSingleResult();
		em.getTransaction().commit();
		return user;
	}
	
	public User findUserById(Integer userId) {
		em.getTransaction().begin();
		Query query = em.createQuery("select u from User u where u.id=:userId");
		query.setParameter("userId", userId);
		User user = (User)query.getSingleResult();
		em.getTransaction().commit();
		return user;
	}
}
