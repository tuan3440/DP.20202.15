package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

public class Cart {
	private static final int TOTAL_INITIALIZATION = 0; 
    private static Cart cart;

    private List<CartItem> lstCartItem;

    public synchronized static Cart getInstance() {
        if(cart == null) cart = new Cart();
        return cart;
    }

    private Cart() {
        lstCartItem = new ArrayList<>();
    }

    public void addCartMedia(CartItem cm){
        lstCartItem.add(cm);
    }

    public void removeCartMedia(CartItem cm){
        lstCartItem.remove(cm);
    }

    public List getListMedia(){
        return lstCartItem;
    }

    public void emptyCart(){
        lstCartItem.clear();
    }
    //Data coupling
    //Functional Conhesion
    public int getTotalMedia(){
        int total = TOTAL_INITIALIZATION;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getQuantity();
        }
        return total;
    }
   

    //Data coupling
    //Functional Conhesion
    // thay the bieu thuc tinh toan bang loi goi phuong thuc
    public int calSubtotal(){
        int total = TOTAL_INITIALIZATION;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.calPriceOneProduct(cm.getPrice(), cm.getQuantity());
        }
        return total;
    }
    //Data coupling
    //Functional Conhesion
    public void checkAvailabilityOfProduct() throws SQLException{
        boolean allAvailable = true;
        for (Object object : lstCartItem) {
            CartItem cartItem = (CartItem) object;
            int requiredQuantity = cartItem.getQuantity();
            int availQuantity = cartItem.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvailable = false;
        }
        if (!allAvailable) throw new MediaNotAvailableException("Some media not available");
    }
    //Functional Conhesion
    //Stamp coupling vi no chi su dung 1 thuoc tinh id trong bien media truyen vao
    // thay the tham so truyen vao media bang tham so IdMedia vi trong phuong thuc chi can dung den idMedia
    public CartItem checkMediaInCart(int idMedia){
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == idMedia) return cartItem;
        }
        return null;
    }

}