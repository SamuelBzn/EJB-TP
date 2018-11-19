package voitiou;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface VehicleRemote {
	public Vehicle create(String name, String description, double price, int stock, int category_id, Date created_at);
}