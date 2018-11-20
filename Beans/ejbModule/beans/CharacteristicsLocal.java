package beans;

import javax.ejb.Local;
import models.Characteristics;

@Local
public interface CharacteristicsLocal {
	public Characteristics create(String name, double price);
}