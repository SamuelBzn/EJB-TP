package beans;

import java.util.List;

import models.Delivery;
import models.Purchase;
import models.User;

public interface DeliveryRemote {
	public class OutOfStockException extends Exception {
		private static final long serialVersionUID = 1L;

		public OutOfStockException(String name, int wanted, int left) {
			super(
				"Vous essayez de commander " + wanted + " \"" + name + "\" mais " +
				"seulement " + left + " sont restants. Veuillez mettre à jour " +
				"votre panier."
			);
		}
	}

	Delivery create(List<Purchase> purchases, User user) throws OutOfStockException;

	List<Delivery> deliveriesFor(int userId);
}
