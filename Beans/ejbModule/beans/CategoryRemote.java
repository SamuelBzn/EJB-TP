package beans;

import java.util.Collection;

import javax.ejb.Remote;

import models.Category;

@Remote
public interface CategoryRemote {
	public Category create(String name);

	public Category find(int id);

	public Collection<Category> findAll();

	public void remove(int id);

	public Category update(int id, String newName);
}