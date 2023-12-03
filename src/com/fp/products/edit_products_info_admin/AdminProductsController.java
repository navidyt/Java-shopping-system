package com.fp.products.edit_products_info_admin;

import com.fp.main.Main;
import com.fp.model.entity.ProductEntity;
import com.fp.model.service.ProductsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminProductsController {




    public void addButtonAction(ProductEntity p) throws SQLException {
    ProductsService.getInstance().addProduct(p);
    Main.showAdminProducts();
    }
    public void deleteButtonAction(int productID) throws SQLException {
            ProductsService.getInstance().deleteProduct(productID);
        Main.showAdminProducts();
    }
    public void BackButtonAction() throws SQLException, IOException {
        Main.showMainPage();
    }

    //get all the products
    public ObservableList<ProductEntity> getProductsList() throws SQLException {
        ObservableList<ProductEntity> productsObservableList = FXCollections.observableArrayList();
        ResultSet ids = ProductsService.getInstance().getProductsID();
        while (ids.next()){
            ProductEntity p ;
            p = ProductsService.getInstance().getProduct(ids.getInt(1));
            if (!p.getName().equals("")){
            productsObservableList.add(p);}
        }
        return productsObservableList;
    }
        public void editButtonAction(ProductEntity editP) throws SQLException {
            ProductsService.getInstance().editProduct(editP);
            Main.showAdminProducts();
        }
}
