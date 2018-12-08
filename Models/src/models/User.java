package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	public static class LoginException extends Exception {
		private static final long serialVersionUID = 1L;

		public LoginException() {
			super("Mauvaise combinaison pseudo / mot de passe");
		}
	}

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String password;
	private int devise;
	private int rank;

	public User() {

	}

	public User(String name, String email, String password, int devise, int rank) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.devise = devise;
		this.rank = rank;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDevise() {
		return devise;
	}

	public void setDevise(int devise) {
		this.devise = devise;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * Prédicat permettant de déterminer si un utilisateur est
	 * admin ou non.
	 */
	public boolean isAdmin() {
		return this.rank == 1;
	}
}
