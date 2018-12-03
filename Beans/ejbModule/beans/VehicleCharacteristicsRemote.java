package beans;

import java.util.Collection;

import models.VehicleCharacteristics;

public interface VehicleCharacteristicsRemote {

	VehicleCharacteristics create(int vehicle_id, int characteristic_id);

	VehicleCharacteristics find(int id);

	Collection<VehicleCharacteristics> findAll();

	void remove(int id);

	VehicleCharacteristics update(int id, int newId);

}