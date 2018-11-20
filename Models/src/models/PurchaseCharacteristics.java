package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PurchaseCharacteristics {
	@Id
	@GeneratedValue
	private int id;
	private int purchase_id;
	private int characteristic_id;

	public PurchaseCharacteristics() {

	}

	public PurchaseCharacteristics(int purchase_id, int characteristic_id) {
		this.purchase_id = purchase_id;
		this.characteristic_id = characteristic_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getCharacteristic_id() {
		return characteristic_id;
	}

	public void setCharacteristic_id(int characteristic_id) {
		this.characteristic_id = characteristic_id;
	}
}