package beans;

import javax.ejb.Local;
import models.PurchaseCharacteristics;

@Local
public interface PurchaseCharacteristicsLocal {
	public PurchaseCharacteristics create(int purchase_id, int characteristic_id);
}