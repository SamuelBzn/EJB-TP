package beans;

import javax.ejb.Remote;
import models.VehicleCharacteristics;

@Remote
public interface VehicleCharacteristicsRemote {
	public VehicleCharacteristics create(int vehicle_id, int characteristic_id);
}