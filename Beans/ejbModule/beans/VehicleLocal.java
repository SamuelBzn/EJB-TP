package beans;

import java.util.Date;

import javax.ejb.Local;

import models.Vehicle;

@Local
public interface VehicleLocal {
	public Vehicle create(String name, String description, double price, int stock, int category_id, Date created_at);
}