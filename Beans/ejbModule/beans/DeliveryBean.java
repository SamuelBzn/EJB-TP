package beans;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import models.Delivery;
import models.Purchase;
import models.User;
import models.Vehicle;

@Stateless
public class DeliveryBean implements DeliveryRemote {
	@PersistenceContext(unitName="ExampleDS")
	private EntityManager em;

	@EJB
	private PurchaseRemote purchaseBean;

	@EJB
	private VehicleRemote vehicleBean;

	@Override
	public Delivery create(List<Purchase> purchases, User user) throws OutOfStockException {
		Delivery delivery = new Delivery(user);

		// On est obligé de récupérer le véhicule en base de données car
		// l'instance chargée en mémoire pointe peut être vers une valeur
		// du stock qui n'est plus à jour.
		//
		// On stocke le tout dans une liste puisque l'on a besoin d'accéder
		// au véhicule dans 2 boucles différentes. On diminue ainsi la charge
		// sur la base de données.
		List<Vehicle> vehicles = purchases
				.stream()
				.map(p -> vehicleBean.find(p.getVehicle().getId()))
				.collect(Collectors.toList());

		int index = 0;

		// On n'utilise pas de notation Lambda pour pouvoir lancer
		// l'exception ; puisque c'est pas le même scope, il faudrait
		// définir une exception maison.
		//
		// Et accessoirement les Lambda en Java ne proposent pas d'avoir
		// accés à l'index de l'élément courant.
		for (Purchase purchase : purchases) {
			Vehicle vehicle = vehicles.get(index);

			if (purchase.getQuantity() > vehicle.getStock()) {
				throw new OutOfStockException(
					vehicle.getName(),
					purchase.getQuantity(),
					vehicle.getStock()
				);
			}

			index++;
		}

		// S'il n'y eu aucune erreur de stock, on enregistre les achats
		// et la commande en elle même.
		index = 0;

		for (Purchase purchase : purchases) {
			vehicles.get(index).decreaseStock(purchase.getQuantity());
			purchase.setDelivery(delivery);

			purchaseBean.save(purchase);

			index++;
		}

		delivery.setPurchases(purchases);

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