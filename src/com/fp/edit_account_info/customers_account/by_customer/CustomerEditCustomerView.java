package com.fp.edit_account_info.customers_account.by_customer;

import com.fp.edit_account_info.customers_account.by_admin.AdminEditCustomerController;
import com.fp.model.entity.CustomerEntity;
import com.fp.model.service.EditCustomerService;
import com.fp.model.service.AdminLoginService;
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

public class CustomerEditCustomerView {
    CustomerEntity customer = new CustomerEntity();

    AdminEditCustomerController controller = new AdminEditCustomerController();

    public Group group = new Group();

    public AnchorPane aPane = new AnchorPane();

    public TextField editCustomerFirstNameField = new TextField();
    public TextField editCustomerLastNameField = new TextField();
    public TextField editCustomerPhoneField = new TextField();
    public TextField editCustomerPasswordField = new TextField();
    public TextField editCustomerBirthDateField = new TextField();
    public TextField editCustomerAddressField = new TextField();
    public Label firstNameLabel = new Label();
    public Label lastNameLabel = new Label();
    public Label phoneLabel = new Label();
    public Label passwordLabel = new Label();
    public Label birthDateLabel = new Label();
    public Label addressLabel = new Label();


    public Image backgroundImage = new Image("resource/Background.png");
    public ImageView background = new ImageView(backgroundImage);

    public Button backButton = new Button();
    public Button editButton = new Button();

    public Label alertLabel = new Label();

    public Group getRoot() throws SQLException {

        customer = EditCustomerService.getInstance().getCustomer(AdminLoginService.getInstance().getUserID());

        //setting pane
        aPane.setPrefHeight(720);
        aPane.setPrefWidth(1280);

        //Setting editFields

        editCustomerFirstNameField.setLayoutX(470);
        editCustomerFirstNameField.setLayoutY(100);
        editCustomerFirstNameField.setPrefHeight(25);
        editCustomerFirstNameField.setPrefWidth(400);
        editCustomerFirstNameField.setPromptText("Edit FirstName ");
        editCustomerFirstNameField.setText(customer.getFirstName());

        editCustomerLastNameField.setLayoutX(470);
        editCustomerLastNameField.setLayoutY(175);
        editCustomerLastNameField.setPrefHeight(25);
        editCustomerLastNameField.setPrefWidth(400);
        editCustomerLastNameField.setPromptText("Edit Last Name");
        editCustomerLastNameField.setText(customer.getLastName());

        editCustomerPhoneField.setLayoutX(470);
        editCustomerPhoneField.setLayoutY(250);
        editCustomerPhoneField.setPrefHeight(25);
        editCustomerPhoneField.setPrefWidth(400);
        editCustomerPhoneField.setPromptText("Edit Phone");
        editCustomerPhoneField.setText(customer.getPhone());

        editCustomerBirthDateField.setLayoutX(470);
        editCustomerBirthDateField.setLayoutY(325);
        editCustomerBirthDateField.setPrefHeight(25);
        editCustomerBirthDateField.setPrefWidth(400);
        editCustomerBirthDateField.setPromptText("Edit Birth Date");
        editCustomerBirthDateField.setText(customer.getBirthDate());

        editCustomerPasswordField.setLayoutX(470);
        editCustomerPasswordField.setLayoutY(400);
        editCustomerPasswordField.setPrefHeight(25);
        editCustomerPasswordField.setPrefWidth(400);
        editCustomerPasswordField.setPromptText("Edit Password");
        editCustomerPasswordField.setText(customer.getPassword());

        editCustomerAddressField.setLayoutX(470);
        editCustomerAddressField.setLayoutY(475);
        editCustomerAddressField.setPrefHeight(25);
        editCustomerAddressField.setPrefWidth(400);
        editCustomerAddressField.setPromptText("Edit Address");
        editCustomerAddressField.setText(customer.getAddress());


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

        passwordLabel.setLayoutX(380);
        passwordLabel.setLayoutY(400);
        passwordLabel.setText("Password :");
        passwordLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        passwordLabel.setTextFill(Color.WHITE);

        addressLabel.setLayoutX(380);
        addressLabel.setLayoutY(475);
        addressLabel.setText("Address :");
        addressLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        addressLabel.setTextFill(Color.WHITE);



        //setting button
        backButton.setLayoutX(720);
        backButton.setLayoutY(550);
        backButton.setText("Back");
        backButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );
        backButton.setOnAction(e -> {
            try {
                controller.BackButtonAction();
            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }
        });

        editButton.setLayoutX(570);
        editButton.setLayoutY(550);
        editButton.setText("Edit");
        editButton.setOnAction(e -> this.editButtonAction());
        editButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        alertLabel.setLayoutX(15);
        alertLabel.setLayoutY(600);
        alertLabel.setTextFill(Color.RED);
        alertLabel.setText("");
        alertLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");



        group.getChildren().add(aPane);
        group.getChildren().add(background);
        group.getChildren().add(editCustomerFirstNameField);
        group.getChildren().add(editCustomerLastNameField);
        group.getChildren().add(editCustomerPhoneField);
        group.getChildren().add(editCustomerBirthDateField);
        group.getChildren().add(editCustomerPasswordField);
        group.getChildren().add(editCustomerAddressField);
        group.getChildren().add(firstNameLabel);
        group.getChildren().add(lastNameLabel);
        group.getChildren().add(phoneLabel);
        group.getChildren().add(birthDateLabel);
        group.getChildren().add(passwordLabel);
        group.getChildren().add(addressLabel);
        group.getChildren().add(backButton);
        group.getChildren().add(editButton);
        group.getChildren().add(alertLabel);

        return group;
    }


    public void editButtonAction(){
        CustomerEntity editC = new CustomerEntity();
        if((!editCustomerFirstNameField.getText().equals(""))&&(!editCustomerLastNameField.getText().equals(""))&&(!editCustomerPhoneField.getText().equals(""))&&
                (!editCustomerBirthDateField.getText().equals(""))&&(!editCustomerPasswordField.getText().equals(""))&&(!editCustomerAddressField.getText().equals(""))){
            try{
                editC.setId(AdminLoginService.getInstance().getUserID());

                editC.setFirstName(editCustomerFirstNameField.getText());
                editC.setLastName(editCustomerLastNameField.getText());
                editC.setPhone(editCustomerPhoneField.getText());
                editC.setBirthDate(editCustomerBirthDateField.getText());
                editC.setPassword(editCustomerPasswordField.getText());
                editC.setAddress(editCustomerAddressField.getText());
                try{
                    EditCustomerService.getInstance().editCustomer(editC);
                    Main.showEditCustomersCustomer();
                }
                catch(SQLException exception){
                    exception.printStackTrace();
                    alertLabel.setText("Please Enter The Fields Correctly");
                }
            }
            catch (Exception e2){
                e2.printStackTrace();
                alertLabel.setText("Please Enter The EditFields Correctly");
            }

        }
        else {
            alertLabel.setText("Please Fill All The EditFields");
        }

    }
}
