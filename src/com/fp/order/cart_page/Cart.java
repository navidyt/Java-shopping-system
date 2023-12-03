package com.fp.order.cart_page;


import javafx.scene.Group;
import javafx.scene.Scene;

import java.sql.SQLException;

public class Cart {

    //singleton class
    private static final Cart cart = new Cart();
    public static Cart getInstance() {return cart;}
    private Cart(){}

    public Scene getCartPage(String status) throws SQLException {
        CartView cartView = new CartView();
        Group root = cartView.getRoot(status);
        return new Scene(root);
    }

}
