package com.fp.model.service;


import com.fp.model.entity.CustomerEntity;
import com.fp.model.repository.EditCustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EditCustomerService {
    //singleton class
    private static final EditCustomerService editCustomerService = new EditCustomerService();
    public static EditCustomerService getInstance() {return editCustomerService;}
    private EditCustomerService(){}


    public ResultSet getCustomerNumber() throws SQLException {
        EditCustomerRepository repository = new EditCustomerRepository();
        return repository.getCustomerNumberRepo();
    }

    public CustomerEntity getCustomer(int customerID) throws SQLException {
        EditCustomerRepository repository = new EditCustomerRepository();
        String firstName = repository.getCustomerFirstNameRepo(customerID);
        String lastName = repository.getCustomerLastNameRepo(customerID);
        String phone = repository.getCustomerPhoneRepo(customerID);
        String birthDay = repository.getCustomerBirthDayRepo(customerID);
        String userName = repository.getCustomerUserNameRepo(customerID);
        String password = repository.getCustomerPasswordRepo(customerID);
        String address = repository.getCustomerAddressRepo(customerID);
        return new CustomerEntity(customerID,firstName,lastName, birthDay,phone,userName,password,address);
    }

    public void deleteCustomer(int adminID) throws SQLException {
        EditCustomerRepository repository = new EditCustomerRepository();
        repository.deleteCustomerRepo(adminID);
    }

    public void addCustomer(CustomerEntity c) throws SQLException {
        EditCustomerRepository repository = new EditCustomerRepository();
        repository.addCustomerRepo(c);
    }

    public void editCustomer(CustomerEntity editC) throws SQLException {
        EditCustomerRepository repository = new EditCustomerRepository();
        repository.editAdminRepo(editC);
    }
}
