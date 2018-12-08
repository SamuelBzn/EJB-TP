package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
	private double price;
	private int stock;


	@ManyToOne
	private Category category;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="vehicle_characteristic",
		joinColumns=@JoinColumn(name="vehicle_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(name="characteristic_id", referencedColumnName="id")
	)
	private List<Characteristic> characteristics;

	transient private Set<Integer> characteristicIds;

	public Vehicle() {

	}

	public Vehicle(String name, String description, double price, int stock) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Characteristic> getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(List<Characteristic> characteristics) {
		this.characteristics = characteristics;
		this.characteristicIds = null;
	}

	public Set<Integer> getCharacteristicIds() {
		if (characteristics == null)
			return new HashSet<Integer>();

		if (characteristicIds == null) {
			characteristicIds = characteristics.stream()
					.map(c -> c.getId())
					.collect(Collectors.toSet());
		}

		return characteristicIds;
	}

	/**
	 * Permet de facilement retirer `n` éléments du stock.
	 *
	 * @param quantity - Quantité à retirer du stock.
	 */
	public void decreaseStock(int quantity) {
		this.stock = this.stock - quantity;
	}
}