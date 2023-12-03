package com.fp.products.shop_page;

import javafx.scene.Group;
import javafx.scene.Scene;

import java.sql.SQLException;

public class ShowProducts {

    //singleton class
    private static final ShowProducts showProducts = new ShowProducts();
    public static ShowProducts getInstance() {
        return showProducts;
    }
    private ShowProducts(){}

    public Scene getShowProducts() throws SQLException {
        ShowProductsView showProductsView = new ShowProductsView();
        Group root = showProductsView.getRoot();
        return new Scene(root);
    }

}
