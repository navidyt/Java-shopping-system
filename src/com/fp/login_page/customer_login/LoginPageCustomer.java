package com.fp.login_page.customer_login;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Objects;



public class LoginPageCustomer {
    //singleton class
    private static final LoginPageCustomer loginPageCustomer = new LoginPageCustomer();
    public static LoginPageCustomer getInstance(){return loginPageCustomer;}
    private LoginPageCustomer(){}
     public Scene getLoginPage() throws IOException {

         Parent root = FXMLLoader.load(Objects.requireNonNull(LoginPageCustomer.class.getResource("LoginPageCustomer.fxml")));
         return new Scene(root);
    }

}
