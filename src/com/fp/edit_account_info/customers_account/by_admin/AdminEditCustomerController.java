package com.fp.edit_account_info.customers_account.by_admin;

import com.fp.model.entity.CustomerEntity;
import com.fp.model.service.EditCustomerService;
import com.fp.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminEditCustomerController {


    public ObservableList<CustomerEntity> getCustomerList() throws SQLException {
        ObservableList<CustomerEntity> customerList = FXCollections.observableArrayList();
        ResultSet result = EditCustomerService.getInstance().getCustomerNumber();
        while (result.next()){
            CustomerEntity a;
            a = EditCustomerService.getInstance().getCustomer(result.getInt(1));
            if (!a.getUserName().equals("")){
                customerList.add(a);}
        }
        return customerList;
    }



    public void deleteButtonAction(int customerID) throws SQLException {
        EditCustomerService.getInstance().deleteCustomer(customerID);
        Main.showEditCustomers();
    }
    public void addButtonAction(CustomerEntity c) throws SQLException {
        EditCustomerService.getInstance().addCustomer(c);
        Main.showEditCustomers();
    }

    public void BackButtonAction() throws SQLException, IOException {
        Main.showMainPage();
    }

    public void editButtonAction(CustomerEntity editC) throws SQLException {
        EditCustomerService.getInstance().editCustomer(editC);
        Main.showEditCustomers();
    }
}
