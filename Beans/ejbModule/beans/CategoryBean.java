package beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Category;
import models.Characteristic;

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

	@Override
	public Category find(int id) {
		return em.find(Category.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Collection<Category> findAll() {
		Query query = em.createQuery("SELECT c FROM Category c");
		return query.getResultList();
	}

	@Override
	public void remove(int id) {
		Category cat = find(id);
		if (cat != null) {
			em.remove(cat);
		}
	}


	@Override
	public Category update(int id, String newName) {
		Category cat = em.find(Category.class, id);
		if (cat != null) {
			cat.setName(newName);
		}
		return cat;
	}

	@Override
	public Map<String, List<Characteristic>> groupsOfCharacteristics() {
		Collection<Category> categories = findAll();

		Map<String, List<Characteristic>> groups = new HashMap<>();

		categories.stream().forEach(category -> {
			List<Characteristic> items = category.getCharacteristics();

			// TODO: Trouver une meilleur solution que le stream + collect
			//
			// Technique du bled pour charger la liste des éléments
			// et éviter une `LazyInitializationEception` dans les vues
			// JSP quand on essaie de parcourir la liste.
			groups.put(category.getName(), items.stream()
				.map(e -> e)
				.collect(Collectors.toList()));
		});

		return groups;
	}
}