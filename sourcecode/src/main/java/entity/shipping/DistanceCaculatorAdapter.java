package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceCaculatorAdapter implements IDistanceCaculator {

	private DistanceCalculator distanceCalculator;
	
	public DistanceCaculatorAdapter() {
		super();
		distanceCalculator = new DistanceCalculator();
	}

	@Override
	public int caculateDistance(String address, String provice) {		
		return distanceCalculator.calculateDistance(address, provice);
	}
}
