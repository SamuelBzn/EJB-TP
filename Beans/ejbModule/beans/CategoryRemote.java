package beans;

import java.util.Date;

import javax.ejb.Remote;

import models.Category;
import models.Vehicle;

@Remote
public interface CategoryRemote {
	public Category create(String name);
}