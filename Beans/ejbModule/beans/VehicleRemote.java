package beans;

import java.util.Collection;
import java.util.List;

import models.Category;
import models.Characteristic;
import models.Vehicle;

public interface VehicleRemote {

	Vehicle create(String name, String description,
		double price, int stock,
		Category category, List<Characteristic> characteristics);

	Vehicle find(int id);

	Collection<Vehicle> findAll();

	void remove(int id);

	Vehicle update(int id, String newName, String description,
			double price, int stock,
			Category category, List<Characteristic> characteristics);

}