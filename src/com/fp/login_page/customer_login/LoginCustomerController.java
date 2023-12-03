package com.fp.login_page.customer_login;

import com.fp.model.entity.LoginEntity;
import com.fp.model.service.CustomerLoginService;
import com.fp.main.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;


public class LoginCustomerController {

    @FXML
    public TextField userNameTextField;
    public PasswordField passwordTextField;
    public Label massageLabel;

    public void resetButton() {
        userNameTextField.setText("");
        passwordTextField.setText("");
    }

    public void loginButton() throws IOException, SQLException {

        massageLabel.setTextFill(Color.RED);
        String userName = userNameTextField.getText().toLowerCase();
        String password = passwordTextField.getText();
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserName(userName);
        loginEntity.setPassword(password);
        if (!userName.equals("")) {
                if (CustomerLoginService.getInstance().checkUsername(loginEntity)) {
                        if (!passwordTextField.getText().equals("")) {
                                if (CustomerLoginService.getInstance().checkPassword(loginEntity)) {
                                    CustomerLoginService.getInstance().setUser(loginEntity);
                                       Main.showMainPage();
                                }
                                else {massageLabel.setText("Wrong Password");}
                        } else {massageLabel.setText("Please Provide a Password");}
                } else {massageLabel.setText("Wrong userID");}
        } else {massageLabel.setText("Please Provide a userID");}
    }

    public void backButton() throws IOException, SQLException {
        Main.showMainPage();
    }
    public void adminButtonAction() throws IOException {
        Main.showLoginPageAdmin();
    }
    public void signUpButtonAction() throws SQLException {
        Main.showSignUpPage();
    }
}
