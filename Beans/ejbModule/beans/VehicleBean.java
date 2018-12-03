package beans;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Vehicle;

@Stateless
public class VehicleBean implements VehicleRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see beans.VehicleRemote#create(java.lang.String, java.lang.String, double, int, int, java.util.Date)
	 */
	@Override
	public Vehicle create(String name, String description, double price, int stock, int category_id, Date created_at) {
		Vehicle veh = new Vehicle(name, description, price, stock, category_id, created_at);
		em.persist(veh);
		return veh;
	}

	/* (non-Javadoc)
	 * @see beans.VehicleRemote#find(int)
	 */
	@Override
	public Vehicle find(int id) {
		return em.find(Vehicle.class, id);
	}

	/* (non-Javadoc)
	 * @see beans.VehicleRemote#findAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Vehicle> findAll() {
		Query query = em.createQuery("SELECT v FROM Vehicle v");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see beans.VehicleRemote#remove(int)
	 */
	@Override
	public void remove(int id) {
		Vehicle veh = find(id);
		if (veh != null) {
			em.remove(veh);
		}
	}


	/* (non-Javadoc)
	 * @see beans.VehicleRemote#update(int, java.lang.String)
	 */
	@Override
	public Vehicle update(int id, String newName) {
		Vehicle veh = em.find(Vehicle.class, id);
		if (veh != null) {
			veh.setName(newName);
		}
		return veh;
	}
}