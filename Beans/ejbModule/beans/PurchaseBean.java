package beans;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Purchase;

@Stateless
public class PurchaseBean implements PurchaseRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public Purchase create(int vehicle_id, int user_id, Date created_at) {
		Purchase p = new Purchase(vehicle_id, user_id, created_at);
		em.persist(p);
		return p;
	}

	public Purchase find(int id) {
		return em.find(Purchase.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Purchase> findAll() {
		Query query = em.createQuery("SELECT p FROM Purchase p");
		return query.getResultList();
	}

	public void remove(int id) {
		Purchase p = find(id);
		if (p != null) {
			em.remove(p);
		}
	}


	public Purchase update(int id, int newID) {
		Purchase p = em.find(Purchase.class, id);
		if (p != null) {
			p.setId(newID);
		}
		return p;
	}
}