package entity.shipping;

import entity.order.Order;

public interface IShippingFeeCaculator {
	public int calculateShippingFee(Order order,int distance);
}
