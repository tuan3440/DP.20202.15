package entity.order;

public class PayOrderInfo {
	private int amount;
	private String contents;
	private String cardNumber;
	private String cardHolderName;
	
	private String expirationDate;
	private String securityCode;
	
	
	
	public PayOrderInfo(int amount, String contents, String cardNumber, String cardHolderName, String expirationDate,
			String securityCode) {
		super();
		this.amount = amount;
		this.contents = contents;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
	}
	
	public int getAmount() {
		return amount;
	}
	public String getContents() {
		return contents;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	
	
}
