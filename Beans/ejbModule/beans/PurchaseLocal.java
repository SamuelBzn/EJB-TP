package beans;

import java.util.Date;
import javax.ejb.Local;
import models.Purchase;

@Local
public interface PurchaseLocal {
	public Purchase create(int vehicle_id, int user_id, Date created_at);
}