package beans;

import javax.ejb.Remote;
import models.PurchaseCharacteristics;

@Remote
public interface PurchaseCharacteristicsRemote {
	public PurchaseCharacteristics create(int purchase_id, int characteristic_id);
}