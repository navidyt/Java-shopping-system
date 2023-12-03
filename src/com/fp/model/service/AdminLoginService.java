package com.fp.model.service;

import com.fp.model.entity.LoginEntity;
import com.fp.model.repository.AdminLoginRepository;

import java.sql.SQLException;

public class AdminLoginService {
    //singleton class
private static final AdminLoginService AdminLoginService = new AdminLoginService();
public static AdminLoginService getInstance(){return AdminLoginService;}
private AdminLoginService(){}


public boolean checkPassword(LoginEntity loginEntity) throws SQLException {
    boolean result ;
    AdminLoginRepository repository = new AdminLoginRepository();
    result = repository.passwordCheck(loginEntity);

    return result;
}


public boolean checkUsername(LoginEntity loginEntity) throws SQLException {
    boolean result ;
    AdminLoginRepository repository = new AdminLoginRepository();
    result = repository.UsernameExistence(loginEntity);
    return result;
}

    public void setUser(LoginEntity loginEntity) throws SQLException {
        AdminLoginRepository repository = new AdminLoginRepository();
        try {
            repository.setUser(loginEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getUserID() throws SQLException {
        AdminLoginRepository repository = new AdminLoginRepository();
        return repository.getUserIDRepo();
    }
}
