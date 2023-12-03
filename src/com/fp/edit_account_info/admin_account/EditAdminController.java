package com.fp.edit_account_info.admin_account;

import com.fp.model.entity.AdminEntity;
import com.fp.model.service.EditAdminService;
import com.fp.main.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditAdminController {


    public ObservableList<AdminEntity> getAdminList() throws SQLException {
        ObservableList<AdminEntity> adminList= FXCollections.observableArrayList();
        ResultSet result = EditAdminService.getInstance().getAdminNumber();
        while (result.next()){
            AdminEntity a;
            a = EditAdminService.getInstance().getAdmin(result.getInt(1));
            if (!a.getUserName().equals("")){
                adminList.add(a);}
        }
        return adminList;
    }



    public void deleteButtonAction(int adminID) throws SQLException {
        EditAdminService.getInstance().deleteAdmin(adminID);
        Main.showEditAdmins();
    }
    public void addButtonAction(AdminEntity a) throws SQLException {
        EditAdminService.getInstance().addAdmin(a);
        Main.showEditAdmins();
    }

    public void BackButtonAction() throws SQLException, IOException {
        Main.showMainPage();
    }

    public void editButtonAction(AdminEntity editA) throws SQLException {
        EditAdminService.getInstance().editAdmin(editA);
        Main.showEditAdmins();
    }
}
