package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Category;
import models.Characteristic;

@Stateless
public class CharacteristicBean implements CharacteristicRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public Characteristic create(String name, double price, Category category) {
		Characteristic c = new Characteristic(name, price, category);
		em.persist(c);
		return c;
	}


	@Override
	public Characteristic find(int id) {
		return em.find(Characteristic.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Characteristic> findAll() {
		Query query = em.createQuery("SELECT c FROM Characteristic c");
		return query.getResultList();
	}

	@Override
	public void remove(int id) {
		Characteristic c = find(id);
		if (c != null) {
			em.remove(c);
		}
	}

	@Override
	public Characteristic update(int id, String newName, double price, Category category) {
		Characteristic c = em.find(Characteristic.class, id);

		if (c != null) {
			c.setName(newName);
			c.setPrice(price);
			c.setCategory(category);
		}
		return c;
	}
}