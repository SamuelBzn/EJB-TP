package beans;

import java.util.Collection;

import models.User;

public interface UserRemote {

	User create(String name, String email, String password, int devise, int rank);

	boolean login(String username, String password);

	User find(int id);

	Collection<User> findAll();

	void remove(int id);

	User update(int id, String newName);

}