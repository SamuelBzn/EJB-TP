package beans;

import java.util.Date;

import javax.ejb.Local;

import models.Category;
import models.Vehicle;

@Local
public interface CategoryLocal {
	public Category create(String name);
}