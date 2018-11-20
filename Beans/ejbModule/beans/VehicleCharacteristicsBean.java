package beans;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.VehicleCharacteristics;

@Stateless
public class VehicleCharacteristicsBean implements VehicleCharacteristicsRemote, VehicleCharacteristicsLocal {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	public VehicleCharacteristics create(int vehicle_id, int characteristic_id) {
		VehicleCharacteristics vehc = new VehicleCharacteristics(vehicle_id, characteristic_id);
		em.persist(vehc);
		return vehc;
	}

	public VehicleCharacteristics find(int id) {
		return em.find(VehicleCharacteristics.class, id);
	}

	public Collection<VehicleCharacteristics> findAll() {
		Query query = em.createQuery("SELECT v FROM VehicleCharacteristics v");
		return (Collection<VehicleCharacteristics>) query.getResultList();
	}

	public void remove(int id) { 
		VehicleCharacteristics veh = find(id);
		if (veh != null) {
			em.remove(veh);
		}
	}


	public VehicleCharacteristics update(int id, int newId) {
		VehicleCharacteristics vehc = em.find(VehicleCharacteristics.class, id);
		if (vehc != null) {
			vehc.setId(newId);
		}
		return vehc;
	}
}