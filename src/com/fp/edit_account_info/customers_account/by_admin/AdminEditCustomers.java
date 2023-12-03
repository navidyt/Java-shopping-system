package com.fp.edit_account_info.customers_account.by_admin;

import javafx.scene.Group;
import javafx.scene.Scene;

import java.sql.SQLException;

public class AdminEditCustomers {
    //singleton class
    private static final AdminEditCustomers editCustomer = new AdminEditCustomers();
    public static AdminEditCustomers getInstance() {return editCustomer;}
    private AdminEditCustomers(){}

    public Scene getEditCustomers() throws SQLException {
        AdminEditCustomerView adminEditCustomerView = new AdminEditCustomerView();
        Group root = adminEditCustomerView.getRoot();
        return new  Scene(root);
    }

}
