package com.fp.signup_page;

import com.fp.model.entity.CustomerEntity;
import com.fp.model.service.EditCustomerService;
import com.fp.main.Main;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.SQLException;

public class SighUpView {

    public Group group = new Group();

    public AnchorPane aPane = new AnchorPane();

    public TextField customerFirstNameField = new TextField();
    public TextField customerLastNameField = new TextField();
    public TextField customerPhoneField = new TextField();
    public TextField customerUserNameField = new TextField();
    public TextField customerPasswordField = new TextField();
    public TextField customerBirthDateField = new TextField();
    public TextField customerAddressField = new TextField();

    public Label firstNameLabel = new Label();
    public Label lastNameLabel = new Label();
    public Label phoneLabel = new Label();
    public Label passwordLabel = new Label();
    public Label birthDateLabel = new Label();
    public Label addressLabel = new Label();
    public Label userNameLabel = new Label();
    public Label alertLabel = new Label();

    public Image backgroundImage = new Image("resource/Background.png");
    public ImageView background = new ImageView(backgroundImage);

    public Button backButton = new Button();
    public Button addButton = new Button();


    public Group getRoot() throws SQLException {

        customerFirstNameField.setLayoutX(470);
        customerFirstNameField.setLayoutY(100);
        customerFirstNameField.setPrefHeight(25);
        customerFirstNameField.setPrefWidth(400);
        customerFirstNameField.setPromptText("First Name");

        customerLastNameField.setLayoutX(470);
        customerLastNameField.setLayoutY(175);
        customerLastNameField.setPrefHeight(25);
        customerLastNameField.setPrefWidth(400);
        customerLastNameField.setPromptText("Last Name");

        customerPhoneField.setLayoutX(470);
        customerPhoneField.setLayoutY(250);
        customerPhoneField.setPrefHeight(25);
        customerPhoneField.setPrefWidth(400);
        customerPhoneField.setPromptText("Phone");

        customerBirthDateField.setLayoutX(470);
        customerBirthDateField.setLayoutY(325);
        customerBirthDateField.setPrefHeight(25);
        customerBirthDateField.setPrefWidth(400);
        customerBirthDateField.setPromptText("Birth Date");

        customerUserNameField.setLayoutX(470);
        customerUserNameField.setLayoutY(400);
        customerUserNameField.setPrefHeight(25);
        customerUserNameField.setPrefWidth(400);
        customerUserNameField.setPromptText("User Name");

        customerPasswordField.setLayoutX(470);
        customerPasswordField.setLayoutY(475);
        customerPasswordField.setPrefHeight(25);
        customerPasswordField.setPrefWidth(400);
        customerPasswordField.setPromptText("Password");

        customerAddressField.setLayoutX(470);
        customerAddressField.setLayoutY(550);
        customerAddressField.setPrefHeight(25);
        customerAddressField.setPrefWidth(400);
        customerAddressField.setPromptText("Address");

        //setting labels


        firstNameLabel.setLayoutX(380);
        firstNameLabel.setLayoutY(100);
        firstNameLabel.setText("First Name :");
        firstNameLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        firstNameLabel.setTextFill(Color.WHITE);


        lastNameLabel.setLayoutX(380);
        lastNameLabel.setLayoutY(175);
        lastNameLabel.setText("Last Name :");
        lastNameLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        lastNameLabel.setTextFill(Color.WHITE);


        phoneLabel.setLayoutX(380);
        phoneLabel.setLayoutY(250);
        phoneLabel.setText("Phone :");
        phoneLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        phoneLabel.setTextFill(Color.WHITE);


        birthDateLabel.setLayoutX(380);
        birthDateLabel.setLayoutY(325);
        birthDateLabel.setText("Birth Date :");
        birthDateLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        birthDateLabel.setTextFill(Color.WHITE);


        userNameLabel.setLayoutX(380);
        userNameLabel.setLayoutY(400);
        userNameLabel.setText("User Name :");
        userNameLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        userNameLabel.setTextFill(Color.WHITE);


        passwordLabel.setLayoutX(380);
        passwordLabel.setLayoutY(475);
        passwordLabel.setText("Password :");
        passwordLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        passwordLabel.setTextFill(Color.WHITE);


        addressLabel.setLayoutX(380);
        addressLabel.setLayoutY(550);
        addressLabel.setText("Address :");
        addressLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        addressLabel.setTextFill(Color.WHITE);



        //setting buttons
        backButton.setLayoutX(720);
        backButton.setLayoutY(625);
        backButton.setText("Back");
        backButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );
        backButton.setOnAction(e -> {
            try {
                Main.showLoginPage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        addButton.setLayoutX(570);
        addButton.setLayoutY(625);
        addButton.setText("Add");
        addButton.setOnAction(e -> this.addButtonAction());
        addButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );

        //Alert Label
        alertLabel.setLayoutX(15);
        alertLabel.setLayoutY(550);
        alertLabel.setTextFill(Color.RED);
        alertLabel.setText("");
        alertLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");

        group.getChildren().add(aPane);
        group.getChildren().add(background);
        group.getChildren().add(customerFirstNameField);
        group.getChildren().add(customerLastNameField);
        group.getChildren().add(customerPhoneField);
        group.getChildren().add(customerBirthDateField);
        group.getChildren().add(customerUserNameField);
        group.getChildren().add(customerPasswordField);
        group.getChildren().add(customerAddressField);
        group.getChildren().add(backButton);
        group.getChildren().add(addButton);
        group.getChildren().add(alertLabel);
        group.getChildren().add(firstNameLabel);
        group.getChildren().add(lastNameLabel);
        group.getChildren().add(phoneLabel);
        group.getChildren().add(birthDateLabel);
        group.getChildren().add(passwordLabel);
        group.getChildren().add(addressLabel);
        group.getChildren().add(userNameLabel);

        return group;
    }

    public void addButtonAction(){
        CustomerEntity adminEntity = new CustomerEntity();
        if((!customerFirstNameField.getText().equals(""))&&(!customerLastNameField.getText().equals(""))&&(!customerPhoneField.getText().equals(""))&&
                (!customerBirthDateField.getText().equals(""))&&(!customerUserNameField.getText().equals(""))&&(!customerPasswordField.getText().equals("")&&
                (!customerAddressField.getText().equals("")))){
            try {
                adminEntity.setFirstName(customerFirstNameField.getText());
                adminEntity.setLastName(customerLastNameField.getText());
                adminEntity.setPhone(customerPhoneField.getText());
                adminEntity.setBirthDate(customerBirthDateField.getText());
                adminEntity.setUserName(customerUserNameField.getText());
                adminEntity.setPassword(customerPasswordField.getText());
                adminEntity.setAddress(customerAddressField.getText());
                try{
                    EditCustomerService.getInstance().addCustomer(adminEntity);
                    Main.showMainPage();
                }
                catch (SQLException exception){
                    alertLabel.setText("The UserName of Customer is Already Used");
                }
            }catch (Exception ex){
                ex.printStackTrace();
                alertLabel.setText("Please Enter The Fields Correctly");
            }
        }
        else {
            alertLabel.setText("Please Fill All The Fields");
        }
    }


}
