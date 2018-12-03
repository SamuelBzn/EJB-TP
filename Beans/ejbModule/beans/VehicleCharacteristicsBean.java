package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.VehicleCharacteristics;

@Stateless
public class VehicleCharacteristicsBean implements VehicleCharacteristicsRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see beans.VehicleCharacteristicsRemote#create(int, int)
	 */
	@Override
	public VehicleCharacteristics create(int vehicle_id, int characteristic_id) {
		VehicleCharacteristics vehc = new VehicleCharacteristics(vehicle_id, characteristic_id);
		em.persist(vehc);
		return vehc;
	}

	/* (non-Javadoc)
	 * @see beans.VehicleCharacteristicsRemote#find(int)
	 */
	@Override
	public VehicleCharacteristics find(int id) {
		return em.find(VehicleCharacteristics.class, id);
	}

	/* (non-Javadoc)
	 * @see beans.VehicleCharacteristicsRemote#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Collection<VehicleCharacteristics> findAll() {
		Query query = em.createQuery("SELECT v FROM VehicleCharacteristics v");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see beans.VehicleCharacteristicsRemote#remove(int)
	 */
	@Override
	public void remove(int id) {
		VehicleCharacteristics veh = find(id);
		if (veh != null) {
			em.remove(veh);
		}
	}


	/* (non-Javadoc)
	 * @see beans.VehicleCharacteristicsRemote#update(int, int)
	 */
	@Override
	public VehicleCharacteristics update(int id, int newId) {
		VehicleCharacteristics vehc = em.find(VehicleCharacteristics.class, id);
		if (vehc != null) {
			vehc.setId(newId);
		}
		return vehc;
	}
}