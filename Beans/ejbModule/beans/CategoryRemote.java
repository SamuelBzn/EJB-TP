package beans;

import javax.ejb.Remote;
import models.Category;

@Remote
public interface CategoryRemote {
	public Category create(String name);
}