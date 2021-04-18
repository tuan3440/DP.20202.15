package controller;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Map;

import common.exception.InvalidCardException;
import common.exception.PaymentException;
import common.exception.UnrecognizedException;
import entity.cart.Cart;
import entity.order.PayOrderInfo;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.InterbankInterface;
import subsystem.InterbankSubsystem;


/**
 * This {@code PaymentController} class control the flow of the payment process
 * in our AIMS Software.
 * 
 * @author hieud
 *
 */
public class PaymentController extends BaseController {

	/**
	 * Represent the card used for payment
	 */
	private CreditCard creditCard;

	/**
	 * Represent the Interbank subsystem
	 */
	private InterbankInterface interbankInterface;

	/**
	 * Validate the input date which should be in the format "mm/yy", and then
	 * return a {@link String String} representing the date in the
	 * required format "mmyy" .
	 * 
	 * @param date - the {@link String String} represents the input date
	 * @return {@link String String} - date representation of the required
	 *         format
	 * @throws InvalidCardException - if the string does not represent a valid date
	 *                              in the expected format
	 */
	
	//Functional Conhesion
	//Data coupling
	// Clean Method: Thêm phương thức checkErrorDate
	private String[] checkErrorDate(String date){
		String[] strs = date.split("/");
		if (strs.length != 2) {
			throw new InvalidCardException();
		}
		return strs;
	}

	private String getExpirationDate(String date) throws InvalidCardException {
		String[] strs = checkErrorDate(date);
		String expirationDate = null;
		int month = -1;
		int year = -1;

		try {
			month = Integer.parseInt(strs[0]);
			year = Integer.parseInt(strs[1]);
			if (month < 1 || month > 12 || year < Calendar.getInstance().get(Calendar.YEAR) % 100 || year > 100) {
				throw new InvalidCardException();
			}
			expirationDate = strs[0] + strs[1];

		} catch (Exception ex) {
			throw new InvalidCardException();
		}

		return expirationDate;
	}

	//SOLID: vi pham nguyen tac OCP va DIP vi khi thay doi cach thuc thanh toan se phai sua code
	//Data coupling
	// thay the nhieu tham so bang 1 doi tuong moi
	public Map<String, String> payOrder(PayOrderInfo payOrderInfo) {
		Map<String, String> result = new Hashtable<String, String>();
		result.put("RESULT", "PAYMENT FAILED!");
		try {
			this.creditCard = new CreditCard(
					payOrderInfo.getCardNumber(),
					payOrderInfo.getCardHolderName(),
					getExpirationDate(payOrderInfo.getExpirationDate()),
					Integer.parseInt(payOrderInfo.getSecurityCode()));

			this.interbankInterface = new InterbankSubsystem();
			PaymentTransaction transaction = interbankInterface.payOrder(creditCard, payOrderInfo.getAmount(), payOrderInfo.getContents());

			result.put("RESULT", "PAYMENT SUCCESSFUL!");
			result.put("MESSAGE", "You have successfully paid the order!");
		} catch (PaymentException | UnrecognizedException ex) {
			result.put("MESSAGE", ex.getMessage());
		}
		return result;
	}
	//Functional Conhesion
	//Data coupling
	public void emptyCart(){
        SessionInformation.cart.emptyCart();
    }
}