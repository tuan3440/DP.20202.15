package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceCaculator implements DistanceStrategy {
	protected DistanceCalculator distanceCalculator;
	public final double SHIPPING_FEE = 1.2;//Replace a magic number with a named constant
	@Override
	public int caculatorDistane(String address, String province) {

        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * SHIPPING_FEE);
	}
	
	
}
