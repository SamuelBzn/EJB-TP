package beans;

import java.util.Collection;
import java.util.Date;

import models.Purchase;

public interface PurchaseRemote {

	Purchase create(int vehicle_id, int user_id, Date created_at);

	Purchase find(int id);

	Collection<Purchase> findAll();

	void remove(int id);

	Purchase update(int id, int newID);

}