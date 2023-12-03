package com.fp.order.cart_page;

import com.fp.main.Main;
import com.fp.model.entity.ProductEntity;
import com.fp.model.service.CartService;
import com.fp.model.service.ProductsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;

public class CartController {




    public void deleteButtonAction(int id, int productID) throws SQLException {
            CartService.getInstance().deleteFromCart(id, productID);
        Main.showCartPage("");
    }
    public void BackButtonAction() throws SQLException, IOException {
        Main.showMainPage();
    }

    //get all the products in the cart for the user
    public ObservableList<ProductEntity> getProductsList(int userId) throws SQLException {
        ObservableList<ProductEntity> productsObservableList = FXCollections.observableArrayList();
        ResultSet ids = CartService.getInstance().getCartItemsID(userId);
        while (ids.next()){
            int id = ids.getInt(1);
            ProductEntity p ;
            p = ProductsService.getInstance().getProduct(id);
            p.setQuantityInCart(ids.getInt(2));
            p.setTotalPrice(p.getQuantityInCart()*p.getPrice());
            if (!p.getName().equals("")){
            productsObservableList.add(p);}
        }
        return productsObservableList;
    }
    public static LinkedHashSet<ProductEntity> getProductsSet(int userId) throws SQLException {
        LinkedHashSet<ProductEntity> productsObservableList = new LinkedHashSet<>();
        ResultSet ids = CartService.getInstance().getCartItemsID(userId);
        while (ids.next()){
            int id = ids.getInt(1);
            ProductEntity p ;
            p = ProductsService.getInstance().getProduct(id);
            p.setQuantityInCart(ids.getInt(2));
            p.setTotalPrice(p.getQuantityInCart()*p.getPrice());
            if (!p.getName().equals("")){
                productsObservableList.add(p);}
        }
        return productsObservableList;
    }
}
