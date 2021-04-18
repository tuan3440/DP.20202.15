package controller;

import common.exception.InvalidDeliveryInfoException;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.invoice.Invoice;
import entity.order.Order;
import entity.order.OrderItem;
import entity.shipping.DeliveryInfo;
import entity.shipping.ShippingConfigs;
import utils.ValidatorUtils;

import org.example.DistanceCalculator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class controls the flow of place order usecase in our AIMS project
 * @author nguyenlm
 */
//SOLID: vi pham nguyen tac SRP  vi 1 lop PlaceOrderController co 2 nhiem vu : 1 la Order , 2 la Validate cac thanh phan cua Order
public class PlaceOrderController extends BaseController {
	
    /**
     * Just for logging purpose
     */
    private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());

    /**
     * This method checks the availability of product when user click PlaceOrder button
     * @throws SQLException
     */
    //Functional Conhesion
  //Uncoupled coupling
    public void placeOrder() throws SQLException {
        SessionInformation.cart.checkAvailabilityOfProduct();
    }

    /**
     * This method creates the new Order based on the Cart
     * @return Order
     * @throws SQLException
     */
    //Functional Conhesion
    public Order createOrder() throws SQLException {
        return new Order(SessionInformation.cart);
    }

    /**
     * This method creates the new Invoice based on order
     * @param order
     * @return Invoice
     */
    //Functional Conhesion
  //Data coupling
    public Invoice createInvoice(Order order) {
        return new Invoice(order);
    }

    /**
     * This method takes responsibility for processing the shipping info from user
     * @param info
     * @throws InterruptedException
     * @throws IOException
     */
    //Functional Conhesion
  //Data coupling
    public DeliveryInfo processDeliveryInfo(HashMap info) throws InterruptedException, IOException, InvalidDeliveryInfoException {
        LOGGER.info("Process Delivery Info");
        LOGGER.info(info.toString());
        validateDeliveryInfo(info);
        DeliveryInfo deliveryInfo = new DeliveryInfo(
                String.valueOf(info.get("name")),
                String.valueOf(info.get("phone")),
                String.valueOf(info.get("province")),
                String.valueOf(info.get("address")),
                String.valueOf(info.get("instructions")),
                new DistanceCalculator());
        System.out.println(deliveryInfo.getProvince());
        return deliveryInfo;
    }
    
    /**
   * The method validates the info
   * @param info
   * @throws InterruptedException
   * @throws IOException
   */
    //SOLID: OCP vi sau nay neu info thay doi va so luong du lieu can validator thay doi thi phan code nay cung phai thay doi theo
    //(Bui Minh Tuan) minh nghi cho nay là Data coupling vi 3 bien trong ham if thi khac nhau va cac gia tri cua no co the kiem soat duoc
    //Control coupling do info lÃ  tham sá»‘ vá»� máº·t control
    //Tá»©c lÃ  nÃ³ Ä‘iá»ƒu kiá»ƒu luá»“ng cá»§a module Ä‘Æ°á»£c gá»�i
    public void validateDeliveryInfo(HashMap<String, String> info) throws InterruptedException, IOException, InvalidDeliveryInfoException {
    	 final boolean isPhoneNumber = ValidatorUtils.getInstance().validatePhoneNumber(info.get("phone"));
         final boolean isName = ValidatorUtils.getInstance().validateString(info.get("name"));
         final boolean isAddress = ValidatorUtils.getInstance().validateString(info.get("address"));

     	if (isPhoneNumber
         || isName
         || isAddress) return;
        else throw new InvalidDeliveryInfoException();
    } 
}
