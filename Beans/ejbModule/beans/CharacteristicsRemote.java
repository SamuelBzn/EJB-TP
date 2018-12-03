package beans;

import java.util.Collection;

import models.Characteristics;

public interface CharacteristicsRemote {

	Characteristics create(String name, double price);

	Characteristics find(int id);

	Collection<Characteristics> findAll();

	void remove(int id);

	Characteristics update(int id, String newName);

}