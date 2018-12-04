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

	@Override
	public User login(String name, String password) throws User.LoginException {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.name = :name AND u.password = :password");
		query.setParameter("name", name);
		query.setParameter("password", password);

		User user = (User) query.getSingleResult();

		if (user == null)
			throw new User.LoginException();

		return user;
	}

	@Override
	public User find(int id) {
		return em.find(User.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<User> findAll() {
		Query query = em.createQuery("SELECT u FROM User u");
		return query.getResultList();
	}

	@Override
	public void remove(int id) {
		User u = find(id);
		if (u != null) {
			em.remove(u);
		}
	}

	@Override
	public User update(int id, String newName) {
		User u = em.find(User.class, id);
		if (u != null) {
			u.setName(newName);
		}
		return u;
	}
}