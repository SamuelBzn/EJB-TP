package beans;

import java.util.Collection;
import java.util.List;

import models.Category;
import models.Characteristic;

public interface CharacteristicRemote {

	Characteristic create(String name, double price, Category category);

	Characteristic find(int id);

	Collection<Characteristic> findAll();

	void remove(int id);

	Characteristic update(int id, String newName, double price, Category category);

	List<Characteristic> findSome(List<Integer> ids);
}