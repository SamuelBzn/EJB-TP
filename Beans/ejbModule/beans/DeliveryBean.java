package beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Delivery;
import models.User;

@Stateless
public class DeliveryBean implements DeliveryRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@Override
	public Delivery create(User user) {
		Delivery delivery = new Delivery(user);
		em.persist(delivery);

		return delivery;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Delivery> deliveriesFor(int userId) {
		Query query = em.createQuery("SELECT d FROM Delivery d WHERE d.user.id = :userId");

		query.setParameter("userId", userId);

		List<Delivery> deliveries = query.getResultList();

		// Technique du bled ; chargement des charactéristiques pour éviter
		// une exception lors du parcours de la liste de charactéristiques
		// dans la vue (puisque l'on est en dehors du contexte de la transaction).
		//
		// On charge explicitement la collection d'achats et les caractéristiques
		// associées. On appelle `size` pour s'assurer que la collection est bien
		// chargée.
		deliveries.forEach(d -> {
			d.getPurchases().forEach(p -> p.getCharacteristics().size());
		});

		return deliveries;
	}
}