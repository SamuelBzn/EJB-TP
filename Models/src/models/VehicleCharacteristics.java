package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VehicleCharacteristics {
	@Id
	@GeneratedValue
	private int id;
	private int vehicle_id;
	private int characteristic_id;

	public VehicleCharacteristics() {

	}

	public VehicleCharacteristics(int vehicle_id, int characteristic_id) {
		this.vehicle_id = vehicle_id;
		this.characteristic_id = characteristic_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public int getCharacteristic_id() {
		return characteristic_id;
	}

	public void setCharacteristic_id(int characteristic_id) {
		this.characteristic_id = characteristic_id;
	}

	


}