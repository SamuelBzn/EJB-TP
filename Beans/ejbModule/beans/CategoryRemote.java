package beans;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import models.Category;
import models.Characteristic;

public interface CategoryRemote {

	Category create(String name);

	Category find(int id);

	Collection<Category> findAll();

	void remove(int id);

	Category update(int id, String newName);

	Map<String, List<Characteristic>> groupsOfCharacteristics();
}