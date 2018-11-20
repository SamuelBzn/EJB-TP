package beans;

import java.util.Date;
import javax.ejb.Remote;
import models.Purchase;

@Remote
public interface PurchaseRemote {
	public Purchase create(int vehicle_id, int user_id, Date created_at);
}