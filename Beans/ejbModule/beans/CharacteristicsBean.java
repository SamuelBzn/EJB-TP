package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Characteristics;

@Stateless
public class CharacteristicsBean implements CharacteristicsRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public Characteristics create(String name, double price) {
		Characteristics c = new Characteristics(name, price);
		em.persist(c);
		return c;
	}


	@Override
	public Characteristics find(int id) {
		return em.find(Characteristics.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Characteristics> findAll() {
		Query query = em.createQuery("SELECT c FROM Characteristics c");
		return query.getResultList();
	}

	@Override
	public void remove(int id) {
		Characteristics c = find(id);
		if (c != null) {
			em.remove(c);
		}
	}

	@Override
	public Characteristics update(int id, String newName) {
		Characteristics c = em.find(Characteristics.class, id);
		if (c != null) {
			c.setName(newName);
		}
		return c;
	}
}