package entity.payment;

/**
 * @author
 */
public class CreditCard implements CardStrategy {

    private String cardCode;
    private String owner;
    private String dateExpired;
    protected int cvvCode;

	public CreditCard(String cardCode, String owner, String dateExpired, int cvvCode) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
        this.cvvCode = cvvCode;
    }

	public CreditCard(PaymentCreditCardInfo paymentCreditCardInfo) {
		this.cardCode = paymentCreditCardInfo.getCardNumber();
        this.owner = paymentCreditCardInfo.getCardHolderName();
        this.dateExpired = paymentCreditCardInfo.getExpirationDate();
        this.cvvCode = Integer.parseInt(paymentCreditCardInfo.getSecurityCode());
	}
}
