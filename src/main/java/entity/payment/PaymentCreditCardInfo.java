package entity.payment;

import java.util.Calendar;

import common.exception.InvalidCardException;

public class PaymentCreditCardInfo{
	private String cardNumber;
	private String cardHolderName;

	private String expirationDate;
	private String securityCode;
	
	public PaymentCreditCardInfo(String cardNumber, String cardHolderName, String expirationDate, String securityCode) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
	}
	// Clean Method: Thêm phương thức checkErrorDate
	private String[] checkErrorDate(){
		String[] strs = expirationDate.split("/");
		if (strs.length != 2) {
			throw new InvalidCardException();
		}
		return strs;
	}
	
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

	public String getExpirationDate() throws InvalidCardException {
		String[] strs = checkErrorDate();

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

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	
}
