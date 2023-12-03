package com.fp.products.edit_products_info_admin;



import javafx.scene.Group;
import javafx.scene.Scene;
import java.sql.SQLException;

public class AdminProducts {

    //singleton class
    private static final AdminProducts adminProducts = new AdminProducts();
    public static AdminProducts getInstance() {return adminProducts;}
    private AdminProducts(){}

    public Scene getAdminProducts() throws SQLException {
        AdminProductsView adminProductsView = new AdminProductsView();
        Group root = adminProductsView.getRoot();
        return new Scene(root);
    }

}
