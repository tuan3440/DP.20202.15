package entity.shipping;

import entity.order.Order;

public class OldShippingFeeCaculator implements IShippingFeeCaculator{

	public final double SHIPPING_FEE = 1.2;//Replace a magic number with a named constant
    
	@Override
	public int calculateShippingFee(Order order,int distance) {
		return (int) (distance * SHIPPING_FEE);
	}

}
