package beans;

import javax.ejb.Local;
import models.VehicleCharacteristics;

@Local
public interface VehicleCharacteristicsLocal {
	public VehicleCharacteristics create(int vehicle_id, int characteristic_id);
}