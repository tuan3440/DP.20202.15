package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {

	public static User mainUser;
    
    public static LocalDateTime expiredTime;
    
    
    private static Cart cart;
    
    private SessionInformation() {};
    
    public static Cart getCartInstance() {
    	if(cart == null) cart = new Cart();
    	return cart;
    }


	
}
