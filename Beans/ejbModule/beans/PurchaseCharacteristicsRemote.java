package beans;

import java.util.Collection;

import models.PurchaseCharacteristics;

public interface PurchaseCharacteristicsRemote {

	PurchaseCharacteristics create(int purchase_id, int characteristic_id);

	PurchaseCharacteristics find(int id);

	Collection<PurchaseCharacteristics> findAll();

	void remove(int id);

	PurchaseCharacteristics update(int id, int newId);

}