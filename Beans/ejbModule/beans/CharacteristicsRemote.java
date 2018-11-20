package beans;

import javax.ejb.Remote;
import models.Characteristics;

@Remote
public interface CharacteristicsRemote {
	public Characteristics create(String name, double price);
}