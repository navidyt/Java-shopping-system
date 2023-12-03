package com.fp.edit_account_info.admin_account;


import com.fp.model.entity.AdminEntity;
import com.fp.model.service.CustomerLoginService;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;

public class EditAdminView {
    EditAdminController controller = new EditAdminController();

    public Group group = new Group();

    public AnchorPane aPane = new AnchorPane();

    public TextField adminFirstNameField = new TextField();
    public TextField adminLastNameField = new TextField();
    public TextField adminPhoneField = new TextField();
    public TextField adminUserNameField = new TextField();
    public TextField adminPasswordField = new TextField();
    public TextField adminBirthDateField = new TextField();
    public TextField editFirstNameField = new TextField();
    public TextField editLastNameField = new TextField();
    public TextField editPhoneField = new TextField();
    public TextField editAdminPasswordField = new TextField();
    public TextField editAdminBirthDateField = new TextField();
    public TextField editAdminID = new TextField();

    public Button addButton = new Button();
    public Button deleteButton = new Button();
    public Button backButton = new Button();
    public Button editButton = new Button();

    public TableView<AdminEntity> tableView = new TableView<>();

    public TableColumn<AdminEntity, String> firstNameColumn = new TableColumn<>("First Name");
    public TableColumn<AdminEntity, String> lastNameColumn = new TableColumn<>("Last Name");
    public TableColumn<AdminEntity, Integer> phoneColumn = new TableColumn<>("Phone");
    public TableColumn<AdminEntity, Integer> adminIDColumn = new TableColumn<>("AdminID");
    public TableColumn<AdminEntity, String> adminUserNameColumn = new TableColumn<>("User Name");
    public TableColumn<AdminEntity, String> adminPasswordColumn = new TableColumn<>("Password");
    public TableColumn<AdminEntity, String> adminBirthDateColumn = new TableColumn<>("BirthDate");


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


        adminIDColumn.setMinWidth(50);
        adminIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        firstNameColumn.setMinWidth(250);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        lastNameColumn.setMinWidth(250);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        phoneColumn.setMinWidth(150);
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        adminBirthDateColumn.setMinWidth(180);
        adminBirthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));

        adminUserNameColumn.setMinWidth(200);
        adminUserNameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

        adminPasswordColumn.setMinWidth(200);
        adminPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

        tableView = new TableView<>();
        tableView.setItems(controller.getAdminList());
        tableView.getColumns().add(adminIDColumn);
        tableView.getColumns().add(firstNameColumn);
        tableView.getColumns().add(lastNameColumn);
        tableView.getColumns().add(phoneColumn);
        tableView.getColumns().add(adminBirthDateColumn);
        tableView.getColumns().add(adminUserNameColumn);
        tableView.getColumns().add(adminPasswordColumn);
        tableView.getSortOrder().add(adminIDColumn);
        tableView.setOnMouseClicked(e -> {
            AdminEntity a ;
            a = tableView.getSelectionModel().getSelectedItem();
            editFirstNameField.setText(a.getFirstName());
            editLastNameField.setText(a.getLastName());
            editPhoneField.setText(a.getPhone());
            editAdminPasswordField .setText(a.getPassword());
            editAdminBirthDateField .setText(a.getBirthDate());
            editAdminID.setText(String.valueOf(a.getId()));
        });


        //Setting Fields
        adminFirstNameField.setLayoutX(18);
        adminFirstNameField.setLayoutY(675);
        adminFirstNameField.setPrefHeight(25);
        adminFirstNameField.setPrefWidth(196);
        adminFirstNameField.setPromptText("First Name");

        adminLastNameField.setLayoutX(228);
        adminLastNameField.setLayoutY(675);
        adminLastNameField.setPrefHeight(25);
        adminLastNameField.setPrefWidth(150);
        adminLastNameField.setPromptText("Last Name");

        adminPhoneField.setLayoutX(392);
        adminPhoneField.setLayoutY(675);
        adminPhoneField.setPrefHeight(25);
        adminPhoneField.setPrefWidth(150);
        adminPhoneField.setPromptText("Phone");

        adminBirthDateField.setLayoutX(556);
        adminBirthDateField.setLayoutY(675);
        adminBirthDateField.setPrefHeight(25);
        adminBirthDateField.setPrefWidth(150);
        adminBirthDateField.setPromptText("Birth Date");

        adminUserNameField.setLayoutX(720);
        adminUserNameField.setLayoutY(675);
        adminUserNameField.setPrefHeight(25);
        adminUserNameField.setPrefWidth(150);
        adminUserNameField.setPromptText("User Name");

        adminPasswordField.setLayoutX(884);
        adminPasswordField.setLayoutY(675);
        adminPasswordField.setPrefHeight(25);
        adminPasswordField.setPrefWidth(150);
        adminPasswordField.setPromptText("Password");

        //Setting editFields
        editAdminID.setLayoutX(18);
        editAdminID.setLayoutY(625);
        editAdminID.setPrefHeight(25);
        editAdminID.setPrefWidth(31);
        editAdminID.setPromptText("ID");
        editAdminID.setDisable(true);

        editFirstNameField.setLayoutX(64);
        editFirstNameField.setLayoutY(625);
        editFirstNameField.setPrefHeight(25);
        editFirstNameField.setPrefWidth(150);
        editFirstNameField.setPromptText("Edit FirstName ");

        editLastNameField.setLayoutX(228);
        editLastNameField.setLayoutY(625);
        editLastNameField.setPrefHeight(25);
        editLastNameField.setPrefWidth(150);
        editLastNameField.setPromptText("Edit Last Name");

        editPhoneField.setLayoutX(392);
        editPhoneField.setLayoutY(625);
        editPhoneField.setPrefHeight(25);
        editPhoneField.setPrefWidth(150);
        editPhoneField.setPromptText("Edit Phone");

        editAdminBirthDateField.setLayoutX(556);
        editAdminBirthDateField.setLayoutY(625);
        editAdminBirthDateField.setPrefHeight(25);
        editAdminBirthDateField.setPrefWidth(150);
        editAdminBirthDateField.setPromptText("Edit Birth Date");

        editAdminPasswordField.setLayoutX(720);
        editAdminPasswordField.setLayoutY(625);
        editAdminPasswordField.setPrefHeight(25);
        editAdminPasswordField.setPrefWidth(150);
        editAdminPasswordField.setPromptText("Edit Password");




        //Alert Label
        alertLabel.setLayoutX(15);
        alertLabel.setLayoutY(600);
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
        deleteButton.setOnAction(e -> {
            try {
                this.deleteButtonAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
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

        editButton.setLayoutX(884);
        editButton.setLayoutY(625);
        editButton.setText("Edit");
        editButton.setOnAction(e -> this.editButtonAction());



        //Adding Nodes
        group.getChildren().add(aPane);
        group.getChildren().add(tableView);
        group.getChildren().add(adminFirstNameField);
        group.getChildren().add(adminLastNameField);
        group.getChildren().add(adminPhoneField);
        group.getChildren().add(adminBirthDateField);
        group.getChildren().add(adminUserNameField);
        group.getChildren().add(adminPasswordField);
        group.getChildren().add(editFirstNameField);
        group.getChildren().add(editLastNameField);
        group.getChildren().add(editPhoneField);
        group.getChildren().add(editAdminBirthDateField);
        group.getChildren().add(editAdminPasswordField);
        group.getChildren().add(editAdminID);
        group.getChildren().add(backButton);
        group.getChildren().add(addButton);
        group.getChildren().add(deleteButton);
        group.getChildren().add(editButton);
        group.getChildren().add(alertLabel);
        return group;
    }

    public void addButtonAction(){
        AdminEntity adminEntity = new AdminEntity();
        if((!adminFirstNameField.getText().equals(""))&&(!adminLastNameField.getText().equals(""))&&(!adminPhoneField.getText().equals(""))&&
           (!adminBirthDateField.getText().equals(""))&&(!adminUserNameField.getText().equals(""))&&(!adminPasswordField.getText().equals(""))){
            try {
                adminEntity.setFirstName(adminFirstNameField.getText());
                adminEntity.setLastName(adminLastNameField.getText());
                adminEntity.setPhone(adminPhoneField.getText());
                adminEntity.setBirthDate(adminBirthDateField.getText());
                adminEntity.setUserName(adminUserNameField.getText());
                adminEntity.setPassword(adminPasswordField.getText());
                try{
                    controller.addButtonAction(adminEntity);}
                catch (SQLException exception){
                    alertLabel.setText("The UserName of Admin is Already Used");
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


    public void deleteButtonAction() throws SQLException {
        AdminEntity a ;
        a = tableView.getSelectionModel().getSelectedItem();
        if (a.getId()== CustomerLoginService.getInstance().getUserId()){
            alertLabel.setText("you cant delete yourself");
        }
        else {
            try {
                controller.deleteButtonAction(a.getId());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void editButtonAction(){
        AdminEntity editA = new AdminEntity();
        if((!editFirstNameField.getText().equals(""))&&(!editLastNameField.getText().equals(""))&&(!editPhoneField.getText().equals(""))&&
                (!editAdminBirthDateField.getText().equals(""))&&(!editAdminPasswordField.getText().equals(""))){
            try{
                //
                editA.setId(Integer.parseInt(editAdminID.getText()));
                editA.setFirstName(editFirstNameField.getText());
                editA.setLastName(editLastNameField.getText());
                editA.setPhone(editPhoneField.getText());
                editA.setBirthDate(editAdminBirthDateField.getText());
                editA.setPassword(editAdminPasswordField.getText());
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
