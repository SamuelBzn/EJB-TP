package beans;

import javax.ejb.Remote;
import models.User;

@Remote
public interface UserRemote {
	public User create(String name, String email, String password, int devise, int rank);
}