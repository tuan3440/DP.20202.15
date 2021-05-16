package subsystem.interbank;

import entity.payment.CardStrategy;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(CardStrategy card, int amount, String contents) {   // Stamp Coupling vì biến cart truyền vào nhưng không được sử dụng
		return null;
	}

	public PaymentTransaction payOrder(CardStrategy card, int amount, String contents) {  
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
