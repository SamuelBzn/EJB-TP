package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Purchase {
	@Id
	@GeneratedValue
	private int id;

	transient double unitPrice;
	private int quantity;

	@ManyToOne
	private Vehicle vehicle;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="purchase_characteristic",
			joinColumns=@JoinColumn(name="purchase_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="characteristic_id", referencedColumnName="id")
		)
	private List<Characteristic> characteristics;

	@ManyToOne
	private Delivery delivery;

	public Purchase() {

	}

	public Purchase(Vehicle vehicle, int quantity, List<Characteristic> characteristics) {
		this.vehicle         = vehicle;
		this.quantity        = quantity;
		this.characteristics = characteristics;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
	}

	public double getUnitPrice() {
		return this.vehicle.getPrice() +
				this.characteristics.stream()
					.mapToDouble(e -> e.getPrice())
					.sum();
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

}