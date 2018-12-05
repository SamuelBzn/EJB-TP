package beans;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Category;
import models.Characteristic;
import models.Vehicle;

@Stateless
public class VehicleBean implements VehicleRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public Vehicle create(String name, String description,
			double price, int stock,
			Category category, List<Characteristic> characteristics) {
		Vehicle veh = new Vehicle(name, description, price, stock);

		veh.setCategory(category);
		veh.setCharacteristics(characteristics);

		em.persist(veh);
		return veh;
	}

	@Override
	public Vehicle find(int id) {
		return em.find(Vehicle.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Vehicle> findAll() {
		Query query = em.createQuery("SELECT v FROM Vehicle v");
		return query.getResultList();
	}

	@Override
	public void remove(int id) {
		Vehicle veh = find(id);
		if (veh != null) {
			em.remove(veh);
		}
	}

	@Override
	public Vehicle update(int id, String newName, String description,
			double price, int stock,
			Category category, List<Characteristic> characteristics) {
		Vehicle veh = em.find(Vehicle.class, id);

		if (veh != null) {
			veh.setName(newName);
			veh.setDescription(description);
			veh.setPrice(price);
			veh.setStock(stock);
			veh.setCategory(category);
			veh.setCharacteristics(characteristics);
		}

		return veh;
	}
}