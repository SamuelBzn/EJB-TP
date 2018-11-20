package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Characteristics;

@Stateless
public class CharacteristicsBean implements CharacteristicsRemote, CharacteristicsLocal {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	public Characteristics create(String name, double price) {
		Characteristics c = new Characteristics(name, price);
		em.persist(c);
		return c;
	}

	public Characteristics find(int id) {
		return em.find(Characteristics.class, id);
	}

	public Collection<Characteristics> findAll() {
		Query query = em.createQuery("SELECT c FROM User c");
		return (Collection<Characteristics>) query.getResultList();
	}

	public void remove(int id) { 
		Characteristics c = find(id);
		if (c != null) {
			em.remove(c);
		}
	}


	public Characteristics update(int id, String newName) {
		Characteristics c = em.find(Characteristics.class, id);
		if (c != null) {
			c.setName(newName);
		}
		return c;
	}
}