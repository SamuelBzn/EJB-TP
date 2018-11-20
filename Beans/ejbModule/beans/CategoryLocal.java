package beans;

import javax.ejb.Local;
import models.Category;

@Local
public interface CategoryLocal {
	public Category create(String name);
}