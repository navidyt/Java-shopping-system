package com.fp.edit_account_info.customers_account.by_customer;

import javafx.scene.Group;
import javafx.scene.Scene;

import java.sql.SQLException;

public class CustomerEditCustomer {
    //singleton class
    private static final CustomerEditCustomer customerEditCustomer = new CustomerEditCustomer();
    public static CustomerEditCustomer getInstance() {return customerEditCustomer;}
    private CustomerEditCustomer() {}
    public Scene getCustomerCustomer() throws SQLException {
        CustomerEditCustomerView customerEditCustomerView = new CustomerEditCustomerView();
        Group root = customerEditCustomerView.getRoot();
        return new  Scene(root);
    }
}
