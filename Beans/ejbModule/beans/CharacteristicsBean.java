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

	/* (non-Javadoc)
	 * @see beans.CharacteristicsRemote#create(java.lang.String, double)
	 */
	@Override
	public Characteristics create(String name, double price) {
		Characteristics c = new Characteristics(name, price);
		em.persist(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see beans.CharacteristicsRemote#find(int)
	 */
	@Override
	public Characteristics find(int id) {
		return em.find(Characteristics.class, id);
	}

	/* (non-Javadoc)
	 * @see beans.CharacteristicsRemote#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Characteristics> findAll() {
		Query query = em.createQuery("SELECT c FROM Characteristics c");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see beans.CharacteristicsRemote#remove(int)
	 */
	@Override
	public void remove(int id) {
		Characteristics c = find(id);
		if (c != null) {
			em.remove(c);
		}
	}


	/* (non-Javadoc)
	 * @see beans.CharacteristicsRemote#update(int, java.lang.String)
	 */
	@Override
	public Characteristics update(int id, String newName) {
		Characteristics c = em.find(Characteristics.class, id);
		if (c != null) {
			c.setName(newName);
		}
		return c;
	}
}