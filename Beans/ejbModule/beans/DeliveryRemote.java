package beans;

import java.util.List;

import models.Delivery;
import models.User;

public interface DeliveryRemote {
	Delivery create(User user);

	List<Delivery> deliveriesFor(int userId);
}
