package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Delivery implements Serializable {
	@Id
	@GeneratedValue
	private int id;

	@OneToMany(mappedBy="delivery", fetch=FetchType.EAGER)
	private List<Purchase> purchases;

	@ManyToOne
	private User user;

	private static final long serialVersionUID = 1L;

	public Delivery() {
		super();
	}

	public Delivery(User user) {
		this.user = user;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
