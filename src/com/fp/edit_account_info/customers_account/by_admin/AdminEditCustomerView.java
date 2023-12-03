package com.fp.edit_account_info.customers_account.by_admin;


import com.fp.model.entity.CustomerEntity;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;

public class AdminEditCustomerView {
    AdminEditCustomerController controller = new AdminEditCustomerController();

    public Group group = new Group();

    public AnchorPane aPane = new AnchorPane();

    public TextField customerFirstNameField = new TextField();
    public TextField customerLastNameField = new TextField();
    public TextField customerPhoneField = new TextField();
    public TextField customerUserNameField = new TextField();
    public TextField customerPasswordField = new TextField();
    public TextField customerBirthDateField = new TextField();
    public TextField customerAddressField = new TextField();
    public TextField editCustomerFirstNameField = new TextField();
    public TextField editCustomerLastNameField = new TextField();
    public TextField editCustomerPhoneField = new TextField();
    public TextField editCustomerPasswordField = new TextField();
    public TextField editCustomerBirthDateField = new TextField();
    public TextField editCustomerIDField = new TextField();
    public TextField editCustomerAddressField = new TextField();

    public Button addButton = new Button();
    public Button deleteButton = new Button();
    public Button backButton = new Button();
    public Button editButton = new Button();

    public TableView<CustomerEntity> tableView = new TableView<>();

    public TableColumn<CustomerEntity, String> customerFirstNameColumn = new TableColumn<>("First Name");
    public TableColumn<CustomerEntity, String> customerLastNameColumn = new TableColumn<>("Last Name");
    public TableColumn<CustomerEntity, Integer> customerPhoneColumn = new TableColumn<>("Phone");
    public TableColumn<CustomerEntity, Integer> customerIDColumn = new TableColumn<>("CustomerID");
    public TableColumn<CustomerEntity, String> customerUserNameColumn = new TableColumn<>("User Name");
    public TableColumn<CustomerEntity, String> customerPasswordColumn = new TableColumn<>("Password");
    public TableColumn<CustomerEntity, String> customerBirthDateColumn = new TableColumn<>("BirthDate");
    public TableColumn<CustomerEntity, String> customerAddressColumn = new TableColumn<>("Address");

    public Label alertLabel = new Label();

    public Group getRoot() throws SQLException {

        //Setting Pane
        aPane.setPrefHeight(720);
        aPane.setPrefWidth(1280);



        //Setting Table
        tableView.setLayoutX(0);
        tableView.setLayoutY(0);
        tableView.setMinHeight(640);
        tableView.setMinWidth(1280);
        tableView.setPrefHeight(640);


        customerIDColumn.setMinWidth(50);
        customerIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        customerFirstNameColumn.setMinWidth(200);
        customerFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        customerLastNameColumn.setMinWidth(200);
        customerLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        customerPhoneColumn.setMinWidth(100);
        customerPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        customerBirthDateColumn.setMinWidth(180);
        customerBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));

        customerUserNameColumn.setMinWidth(150);
        customerUserNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        customerPasswordColumn.setMinWidth(200);
        customerPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        customerAddressColumn.setMinWidth(200);
        customerAddressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        tableView = new TableView<>();
        tableView.setItems(controller.getCustomerList());
        tableView.getColumns().add(customerIDColumn);
        tableView.getColumns().add(customerFirstNameColumn);
        tableView.getColumns().add(customerLastNameColumn);
        tableView.getColumns().add(customerPhoneColumn);
        tableView.getColumns().add(customerBirthDateColumn);
        tableView.getColumns().add(customerUserNameColumn);
        tableView.getColumns().add(customerPasswordColumn);
        tableView.getColumns().add(customerAddressColumn);
        tableView.getSortOrder().add(customerIDColumn);
        tableView.setOnMouseClicked(e -> {
            CustomerEntity a ;
            a = tableView.getSelectionModel().getSelectedItem();
            editCustomerIDField.setText(String.valueOf(a.getId()));
            editCustomerFirstNameField.setText(a.getFirstName());
            editCustomerLastNameField .setText(a.getLastName());
            editCustomerPhoneField.setText(a.getPhone());
            editCustomerBirthDateField.setText(a.getBirthDate());
            editCustomerPasswordField.setText(a.getPassword());
            editCustomerAddressField.setText(a.getAddress());
        });


        //Setting Fields
        customerFirstNameField.setLayoutX(18);
        customerFirstNameField.setLayoutY(640);
        customerFirstNameField.setPrefHeight(25);
        customerFirstNameField.setPrefWidth(196);
        customerFirstNameField.setPromptText("First Name");

        customerLastNameField.setLayoutX(228);
        customerLastNameField.setLayoutY(640);
        customerLastNameField.setPrefHeight(25);
        customerLastNameField.setPrefWidth(150);
        customerLastNameField.setPromptText("Last Name");

        customerPhoneField.setLayoutX(392);
        customerPhoneField.setLayoutY(640);
        customerPhoneField.setPrefHeight(25);
        customerPhoneField.setPrefWidth(150);
        customerPhoneField.setPromptText("Phone");

        customerBirthDateField.setLayoutX(556);
        customerBirthDateField.setLayoutY(640);
        customerBirthDateField.setPrefHeight(25);
        customerBirthDateField.setPrefWidth(150);
        customerBirthDateField.setPromptText("Birth Date");

        customerUserNameField.setLayoutX(720);
        customerUserNameField.setLayoutY(640);
        customerUserNameField.setPrefHeight(25);
        customerUserNameField.setPrefWidth(150);
        customerUserNameField.setPromptText("User Name");

        customerPasswordField.setLayoutX(884);
        customerPasswordField.setLayoutY(640);
        customerPasswordField.setPrefHeight(25);
        customerPasswordField.setPrefWidth(150);
        customerPasswordField.setPromptText("Password");

        customerAddressField.setLayoutX(18);
        customerAddressField.setLayoutY(678);
        customerAddressField.setPrefHeight(25);
        customerAddressField.setPrefWidth(196);
        customerAddressField.setPromptText("Address");

        //Setting editFields
        editCustomerIDField.setLayoutX(18);
        editCustomerIDField.setLayoutY(582);
        editCustomerIDField.setPrefHeight(25);
        editCustomerIDField.setPrefWidth(31);
        editCustomerIDField.setPromptText("ID");
        editCustomerIDField.setDisable(true);

        editCustomerFirstNameField.setLayoutX(64);
        editCustomerFirstNameField.setLayoutY(582);
        editCustomerFirstNameField.setPrefHeight(25);
        editCustomerFirstNameField.setPrefWidth(150);
        editCustomerFirstNameField.setPromptText("Edit FirstName ");

        editCustomerLastNameField.setLayoutX(228);
        editCustomerLastNameField.setLayoutY(582);
        editCustomerLastNameField.setPrefHeight(25);
        editCustomerLastNameField.setPrefWidth(150);
        editCustomerLastNameField.setPromptText("Edit Last Name");

        editCustomerPhoneField.setLayoutX(392);
        editCustomerPhoneField.setLayoutY(582);
        editCustomerPhoneField.setPrefHeight(25);
        editCustomerPhoneField.setPrefWidth(150);
        editCustomerPhoneField.setPromptText("Edit Phone");

        editCustomerBirthDateField.setLayoutX(556);
        editCustomerBirthDateField.setLayoutY(582);
        editCustomerBirthDateField.setPrefHeight(25);
        editCustomerBirthDateField.setPrefWidth(150);
        editCustomerBirthDateField.setPromptText("Edit Birth Date");

        editCustomerPasswordField.setLayoutX(720);
        editCustomerPasswordField.setLayoutY(582);
        editCustomerPasswordField.setPrefHeight(25);
        editCustomerPasswordField.setPrefWidth(150);
        editCustomerPasswordField.setPromptText("Edit Password");

        editCustomerAddressField.setLayoutX(884);
        editCustomerAddressField.setLayoutY(582);
        editCustomerAddressField.setPrefHeight(25);
        editCustomerAddressField.setPrefWidth(150);
        editCustomerAddressField.setPromptText("Edit Address");


        //Alert Label
        alertLabel.setLayoutX(15);
        alertLabel.setLayoutY(550);
        alertLabel.setTextFill(Color.RED);
        alertLabel.setText("");
        alertLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");



        //Setting Buttons
        addButton.setLayoutX(1061);
        addButton.setLayoutY(675);
        addButton.setText("Add");
        addButton.setOnAction(e -> this.addButtonAction());

        deleteButton.setLayoutX(1125);
        deleteButton.setLayoutY(675);
        deleteButton.setText("Delete");
        deleteButton.setOnAction(e -> this.deleteButtonAction());
        backButton.setLayoutX(1200);
        backButton.setLayoutY(675);
        backButton.setText("Back");
        backButton.setOnAction(e -> {
            try {
                controller.BackButtonAction();
            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }
        });

        editButton.setLayoutX(1061);
        editButton.setLayoutY(582);
        editButton.setText("Edit");
        editButton.setOnAction(e -> this.editButtonAction());



        //Adding Nodes
        group.getChildren().add(aPane);
        group.getChildren().add(tableView);
        group.getChildren().add(customerFirstNameField);
        group.getChildren().add(customerLastNameField);
        group.getChildren().add(customerPhoneField);
        group.getChildren().add(customerBirthDateField);
        group.getChildren().add(customerUserNameField);
        group.getChildren().add(customerPasswordField);
        group.getChildren().add(customerAddressField);
        group.getChildren().add(editCustomerFirstNameField);
        group.getChildren().add(editCustomerLastNameField);
        group.getChildren().add(editCustomerPhoneField);
        group.getChildren().add(editCustomerBirthDateField);
        group.getChildren().add(editCustomerPasswordField);
        group.getChildren().add(editCustomerIDField);
        group.getChildren().add(editCustomerAddressField);
        group.getChildren().add(backButton);
        group.getChildren().add(addButton);
        group.getChildren().add(deleteButton);
        group.getChildren().add(editButton);
        group.getChildren().add(alertLabel);
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
                    controller.addButtonAction(adminEntity);}
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


    public void deleteButtonAction(){
        CustomerEntity a ;
        a = tableView.getSelectionModel().getSelectedItem();
        System.out.println(a.getId());
        try {
                controller.deleteButtonAction(a.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public void editButtonAction(){
        CustomerEntity editA = new CustomerEntity();
        if((!editCustomerFirstNameField.getText().equals(""))&&(!editCustomerLastNameField.getText().equals(""))&&(!editCustomerPhoneField.getText().equals(""))&&
                (!editCustomerBirthDateField.getText().equals(""))&&(!editCustomerPasswordField.getText().equals(""))&&(!editCustomerAddressField.getText().equals(""))){
            try{
                //
                editA.setId(Integer.parseInt(editCustomerIDField.getText()));
                editA.setFirstName(editCustomerFirstNameField.getText());
                editA.setLastName(editCustomerLastNameField.getText());
                editA.setPhone(editCustomerPhoneField.getText());
                editA.setBirthDate(editCustomerBirthDateField.getText());
                editA.setPassword(editCustomerPasswordField.getText());
                editA.setAddress(editCustomerAddressField.getText());
                try{
                    controller.editButtonAction(editA);}
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
