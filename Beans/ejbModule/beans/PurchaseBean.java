package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Purchase;

@Stateless
public class PurchaseBean implements PurchaseRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public Purchase save(Purchase purchase) {
		em.persist(purchase);

		return purchase;
	}

}
