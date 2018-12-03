package beans;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Category;

@Stateless
public class CategoryBean implements CategoryRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public Category create(String name) {
		Category cat = new Category(name);
		em.persist(cat);
		return cat;
	}

	public Category find(int id) {
		return em.find(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	public Collection<Category> findAll() {
		Query query = em.createQuery("SELECT c FROM Category c");
		return query.getResultList();
	}

	public void remove(int id) {
		Category cat = find(id);
		if (cat != null) {
			em.remove(cat);
		}
	}


	public Category update(int id, String newName) {
		Category cat = em.find(Category.class, id);
		if (cat != null) {
			cat.setName(newName);
		}
		return cat;
	}
}