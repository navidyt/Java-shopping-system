package com.fp.model.service;

import com.fp.model.entity.LoginEntity;
import com.fp.model.repository.CustomerLoginRepository;

import java.sql.SQLException;

public class CustomerLoginService {
    //singleton class
private static final CustomerLoginService customerLoginService = new CustomerLoginService();
public static CustomerLoginService getInstance(){return customerLoginService;}
private CustomerLoginService(){}


public boolean checkPassword(LoginEntity loginEntity) throws SQLException {
    boolean result ;
    CustomerLoginRepository repository = new CustomerLoginRepository();
    result = repository.passwordCheck(loginEntity);

    return result;
}


public boolean checkUsername(LoginEntity loginEntity) throws SQLException {
    boolean result ;
    CustomerLoginRepository repository = new CustomerLoginRepository();
    result = repository.UsernameExistence(loginEntity);
    return result;
}

    public void setUser(LoginEntity loginEntity) throws SQLException {
        CustomerLoginRepository repository = new CustomerLoginRepository();
        try {
            repository.setUser(loginEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cleanUser() throws SQLException {
        CustomerLoginRepository repository = new CustomerLoginRepository();
        repository.cleanUser();

    }
    public int getUserId() throws SQLException {
        CustomerLoginRepository repository = new CustomerLoginRepository();
        return repository.getUserIdRepo();
    }

}
