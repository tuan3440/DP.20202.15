package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

public class DeliveryInfo {

	protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected IDistanceCaculator distanceCalculator;  //SOLID: vi pham nguyen ly OCP vi sau nay neu su dung thu vien khac se phai sua truc tiep ma nguon
    protected IShippingFeeCaculator shippingFeeCaculator;
    
    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
    }
    //SOLID: vi pham nguyen ly OCP vi sau nay se thay doi cach tinh phi ship
    public int calculateShippingFee(Order order) {   // stamp coupling vì biến order không được sử dụng
        int distance = distanceCalculator.caculateDistance(address, province);
        return shippingFeeCaculator.calculateShippingFee(order, distance);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
		return shippingInstructions;
	}

	public void setDistanceCaculator (IDistanceCaculator caculateDistance) {
    	this.distanceCalculator = caculateDistance;
    }

	public void setShippingFeeCaculator(IShippingFeeCaculator shippingFeeCaculator) {
		this.shippingFeeCaculator = shippingFeeCaculator;
	}
   
}
