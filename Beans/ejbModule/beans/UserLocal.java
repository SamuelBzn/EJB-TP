package beans;

import javax.ejb.Local;
import models.User;

@Local
public interface UserLocal {
	public User create(String name, String email, String password, int devise, int rank);
}