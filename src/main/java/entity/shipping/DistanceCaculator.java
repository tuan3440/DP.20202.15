package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceCaculator implements ICaculateDistance{

	@Override
	public int CaculateDistance(String provice, String address) {
		return new DistanceCalculator().calculateDistance(address, provice);
	}

}
