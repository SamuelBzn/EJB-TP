package beans;

import java.util.Collection;

import models.Category;

public interface CategoryRemote {

	Category create(String name);

	Category find(int id);

	Collection<Category> findAll();

	void remove(int id);

	Category update(int id, String newName);

}