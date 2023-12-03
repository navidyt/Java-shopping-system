package com.fp.edit_account_info.admin_account;


import javafx.scene.Group;
import javafx.scene.Scene;
import java.sql.SQLException;

public class EditAdmins {
    //singleton class
    private static final EditAdmins editAdmins = new EditAdmins();
    public static EditAdmins getInstance() {return editAdmins;}
    private EditAdmins(){}

    public Scene getEditAdmins() throws SQLException {
        EditAdminView editAdminView = new EditAdminView();
        Group root = editAdminView.getRoot();
        return new Scene(root);
    }
}
