package voitiou;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VehicleBean implements VehicleRemote, VehicleLocal {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;
    
	@Override
	public Vehicle create(String name, String description, double price, int stock, int category_id, Date created_at) {
		Vehicle veh = new Vehicle(name, description, price, stock, category_id, created_at);
		
		em.persist(veh);

		return veh;
	}
}