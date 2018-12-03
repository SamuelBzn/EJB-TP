package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.PurchaseCharacteristics;

@Stateless
public class PurchaseCharacteristicsBean implements PurchaseCharacteristicsRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see beans.PurchaseCharacteristicsRemote#create(int, int)
	 */
	@Override
	public PurchaseCharacteristics create(int purchase_id, int characteristic_id) {
		PurchaseCharacteristics pc = new PurchaseCharacteristics(purchase_id, characteristic_id);
		em.persist(pc);
		return pc;
	}

	/* (non-Javadoc)
	 * @see beans.PurchaseCharacteristicsRemote#find(int)
	 */
	@Override
	public PurchaseCharacteristics find(int id) {
		return em.find(PurchaseCharacteristics.class, id);
	}

	/* (non-Javadoc)
	 * @see beans.PurchaseCharacteristicsRemote#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Collection<PurchaseCharacteristics> findAll() {
		Query query = em.createQuery("SELECT p FROM PurchaseCharacteristics p");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see beans.PurchaseCharacteristicsRemote#remove(int)
	 */
	@Override
	public void remove(int id) {
		PurchaseCharacteristics veh = find(id);
		if (veh != null) {
			em.remove(veh);
		}
	}


	/* (non-Javadoc)
	 * @see beans.PurchaseCharacteristicsRemote#update(int, int)
	 */
	@Override
	public PurchaseCharacteristics update(int id, int newId) {
		PurchaseCharacteristics vehc = em.find(PurchaseCharacteristics.class, id);
		if (vehc != null) {
			vehc.setId(newId);
		}
		return vehc;
	}
}