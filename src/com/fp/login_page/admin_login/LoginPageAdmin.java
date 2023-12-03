package com.fp.login_page.admin_login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Objects;



public class LoginPageAdmin {
    //singleton class
    private static final LoginPageAdmin loginPageAdmin = new LoginPageAdmin();
    public static com.fp.login_page.admin_login.LoginPageAdmin getInstance(){return loginPageAdmin;}
    private LoginPageAdmin(){}
    public Scene getLoginPage() throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(LoginPageAdmin.class.getResource("LoginPageAdmin.fxml")));
        return new Scene(root);
    }

}
