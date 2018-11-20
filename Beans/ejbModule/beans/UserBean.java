package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.User;

@Stateless
public class UserBean implements UserRemote, UserLocal {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	public User create(String name, String email, String password, int devise, int rank) {
		User u = new User(name, email, password, devise, rank);
		em.persist(u);
		return u;
	}

	public User find(int id) {
		return em.find(User.class, id);
	}

	public Collection<User> findAll() {
		Query query = em.createQuery("SELECT u FROM User u");
		return (Collection<User>) query.getResultList();
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