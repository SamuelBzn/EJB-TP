package beans;

import java.util.Collection;
import java.util.Date;

import models.Vehicle;

public interface VehicleRemote {

	Vehicle create(String name, String description, double price, int stock, int category_id, Date created_at);

	Vehicle find(int id);

	Collection<Vehicle> findAll();

	void remove(int id);

	Vehicle update(int id, String newName);

}