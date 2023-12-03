package com.fp.signup_page;

import javafx.scene.Group;
import javafx.scene.Scene;

import java.sql.SQLException;

public class SignUp {
    //singleton class
    private static final SignUp signUp = new SignUp();
    public static SignUp getInstance() {return signUp;}
    private SignUp(){}

    public Scene getSignUpPage() throws SQLException {
        SighUpView sighUpView = new SighUpView();
        Group root = sighUpView.getRoot();
        return new Scene(root);
    }

}
