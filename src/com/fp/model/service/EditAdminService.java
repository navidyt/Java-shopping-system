package com.fp.model.service;

import com.fp.model.entity.AdminEntity;
import com.fp.model.repository.EditAdminRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EditAdminService {
    //singleton class
    private static final EditAdminService editAdminService = new EditAdminService();
    public static EditAdminService getInstance() {return editAdminService;}
    private EditAdminService (){}


    public ResultSet getAdminNumber() throws SQLException {
        EditAdminRepository repository = new EditAdminRepository();
        return repository.getAdminNumberRepo();
    }

    public AdminEntity getAdmin(int adminID) throws SQLException {
        EditAdminRepository repository = new EditAdminRepository();
        String firstName = repository.getAdminFirstNameRepo(adminID);
        String lastName = repository.getAdminLastNameRepo(adminID);
        String phone = repository.getAdminPhoneRepo(adminID);
        String birthDay = repository.getAdminBirthDayRepo(adminID);
        String userName = repository.getAdminUserNameRepo(adminID);
        String password = repository.getAdminPasswordRepo(adminID);
        return new AdminEntity(adminID,firstName,lastName, birthDay,phone,userName,password);
    }

    public void deleteAdmin(int adminID) throws SQLException {
        EditAdminRepository repository = new EditAdminRepository();
        repository.deleteAdminRepo(adminID);
    }

    public void addAdmin(AdminEntity a) throws SQLException {
        EditAdminRepository repository = new EditAdminRepository();
        repository.addAdminRepo(a);
    }

    public void editAdmin(AdminEntity editA) throws SQLException {
        EditAdminRepository repository = new EditAdminRepository();
        repository.editAdminRepo(editA);
    }
}
