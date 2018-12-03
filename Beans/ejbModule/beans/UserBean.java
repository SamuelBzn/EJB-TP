package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.User;

@Stateless
public class UserBean implements UserRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public User create(String name, String email, String password, int devise, int rank) {
		User u = new User(name, email, password, devise, rank);
		em.persist(u);
		return u;
	}
	
	public boolean login(String username, String password) {
		try {
			Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User find(int id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<User> findAll() {
		Query query = em.createQuery("SELECT u FROM User u");
		return query.getResultList();
	}

	public void remove(int id) {
		User u = find(id);
		if (u != null) {
			em.remove(u);
		}
	}


	public User update(int id, String newName) {
		User u = em.find(User.class, id);
		if (u != null) {
			u.setName(newName);
		}
		return u;
	}
}