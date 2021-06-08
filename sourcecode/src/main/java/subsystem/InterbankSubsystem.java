package subsystem;

import entity.payment.CardStrategy;
import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
public class InterbankSubsystem implements InterbankInterface {

	/**
	 * Represent the controller of the subsystem
	 */
	private InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}

	/**
	 * @see InterbankInterface#payOrder(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(CardStrategy card, int amount, String contents) {   
		return ctrl.payOrder(card, amount, contents);  //Move an expression inline
	}

	/**
	 * @see InterbankInterface#refund(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction refund(CardStrategy card, int amount, String contents) {     
		return ctrl.refund(card, amount, contents);   //Move an expression inline
	}
}
