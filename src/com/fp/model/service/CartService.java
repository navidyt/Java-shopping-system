package com.fp.model.service;

import com.fp.model.entity.CartEntity;
import com.fp.model.repository.CartRepository;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CartService {
    //singleton class
    private static final CartService cartService = new CartService();
    public static CartService getInstance(){return cartService;}
    private CartService(){}
    public ResultSet getCartItemsID(int userId) throws SQLException {
        CartRepository repository = new CartRepository();
        return repository.getProductsIDRepo(userId);
    }
    public void addToCart(CartEntity e) throws SQLException {
        CartRepository repository = new CartRepository();
        repository.addToCartRepo(e);
    }
    public int getTotalPrice (int userId) throws SQLException{
        CartRepository repository = new CartRepository();
        return repository.getTotalPriceRepo(userId);
    }
    public void deleteFromCart(int user_id, int product_id) throws SQLException {
        CartRepository repository = new CartRepository();
        repository.deleteFromCartRepo(user_id, product_id);
    }

    public void emptyCart(int user_id) throws SQLException {
        CartRepository repository = new CartRepository();
        repository.emptyCartRepo(user_id);
    }
}
