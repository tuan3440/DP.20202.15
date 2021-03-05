package controller;

import entity.cart.Cart;
import entity.user.User;

import java.time.LocalDateTime;

/**
 * @author
 */
public class SessionInformation {
    //common coupling
    public static User mainUser;
    public static Cart cartInstance = new Cart();
    public static LocalDateTime expiredTime;

}
