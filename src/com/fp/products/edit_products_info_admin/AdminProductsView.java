package com.fp.products.edit_products_info_admin;

import com.fp.main.Main;
import com.fp.model.entity.ProductEntity;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;

public class AdminProductsView {
    AdminProductsController controller = new AdminProductsController();

    public Group group = new Group();

    public AnchorPane aPane = new AnchorPane();

    public TextField productNameField = new TextField();
    public TextField productQuantityField = new TextField();
    public TextField productPriceField = new TextField();
    public TextField editNameField = new TextField();
    public TextField editQuantityField = new TextField();
    public TextField editPriceField = new TextField();
    public TextField editProductID = new TextField();

    public Button addButton = new Button();
    public Button deleteButton = new Button();
    public Button backButton = new Button();
    public Button editButton = new Button();

    public TableView<ProductEntity> productsListTableView = new TableView<>();

    public TableColumn<ProductEntity, String> nameColumn = new TableColumn<>("Name");
    public TableColumn<ProductEntity, Integer> priceColumn = new TableColumn<>("Price");
    public TableColumn<ProductEntity, Integer> quantityColumn = new TableColumn<>("Quantity");
    public TableColumn<ProductEntity, Integer> idColumn = new TableColumn<>("ProductID");
    public TableColumn<ProductEntity, String> categoryColumn = new TableColumn<>("Category");

    public ChoiceBox<String> categoryChoiceBox = new ChoiceBox<>();
    public ChoiceBox<String> editChoiceBox = new ChoiceBox<>();


    public Label alertLabel = new Label();

    public Group getRoot() throws SQLException {

        //Setting Pane
        aPane.setPrefHeight(720);
        aPane.setPrefWidth(1280);




        //Setting Table
        productsListTableView.setLayoutX(0);
        productsListTableView.setLayoutY(0);
        productsListTableView.setMinHeight(640);
        productsListTableView.setMinWidth(1024);
        productsListTableView.setPrefHeight(640);

        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        nameColumn.setMinWidth(300);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        categoryColumn.setMinWidth(480);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        productsListTableView = new TableView<>();
        productsListTableView.setItems(controller.getProductsList());
        productsListTableView.getColumns().add(idColumn);
        productsListTableView.getColumns().add(nameColumn);
        productsListTableView.getColumns().add(priceColumn);
        productsListTableView.getColumns().add(quantityColumn);
        productsListTableView.getColumns().add(categoryColumn);
        productsListTableView.getSortOrder().add(idColumn);
        productsListTableView.setOnMouseClicked(e ->{
            ProductEntity p ;
            p = productsListTableView.getSelectionModel().getSelectedItem();
            editNameField.setText(p.getName());
            editQuantityField.setText(String.valueOf(p.getQuantity()));
            editPriceField.setText(String.valueOf(p.getPrice()));
            editProductID.setText(String.valueOf(p.getId()));
            editChoiceBox.setValue(p.getCategory());
        });



        //Setting Fields
        productNameField.setLayoutX(15);
        productNameField.setLayoutY(675);
        productNameField.setPrefHeight(25);
        productNameField.setPrefWidth(350);
        productNameField.setPromptText("Name");

        productQuantityField.setLayoutX(635);
        productQuantityField.setLayoutY(675);
        productQuantityField.setPrefHeight(25);
        productQuantityField.setPrefWidth(200);
        productQuantityField.setPromptText("Quantity");

        productPriceField.setLayoutX(400);
        productPriceField.setLayoutY(675);
        productPriceField.setPrefHeight(25);
        productPriceField.setPrefWidth(200);
        productPriceField.setPromptText("Price");

        editNameField.setLayoutX(115);
        editNameField.setLayoutY(625);
        editNameField.setPrefHeight(25);
        editNameField.setPrefWidth(250);
        editNameField.setPromptText("Edit Name");

        editQuantityField.setLayoutX(635);
        editQuantityField.setLayoutY(625);
        editQuantityField.setPrefHeight(25);
        editQuantityField.setPrefWidth(200);
        editQuantityField.setPromptText("Edit Quantity");

        editPriceField.setLayoutX(400);
        editPriceField.setLayoutY(625);
        editPriceField.setPrefHeight(25);
        editPriceField.setPrefWidth(200);
        editPriceField.setPromptText("Edit Price");

        editProductID.setLayoutX(15);
        editProductID.setLayoutY(625);
        editProductID.setPrefHeight(25);
        editProductID.setPrefWidth(65);
        editProductID.setPromptText("Enter ID");
        editProductID.setDisable(true);


        //setting the choice box
        categoryChoiceBox.getItems().addAll("Clothing","Food","Book Stationary", "Home", "Tools", "Electronics");
        categoryChoiceBox.setLayoutX(870);
        categoryChoiceBox.setLayoutY(675);
        categoryChoiceBox.setValue("Clothing");

        editChoiceBox.getItems().addAll("Clothing","Food","Book Stationary", "Home", "Tools", "Electronics");
        editChoiceBox.setLayoutX(870);
        editChoiceBox.setLayoutY(625);
        editChoiceBox.setValue("Clothing");



        //Alert Label
        alertLabel.setLayoutX(15);
        alertLabel.setLayoutY(600);
        alertLabel.setTextFill(Color.RED);
        alertLabel.setText("");
        alertLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");



        //Setting Buttons
        addButton.setLayoutX(1040);
        addButton.setLayoutY(675);
        addButton.setText("Add");
        addButton.setOnAction(e -> this.addButtonAction());

        deleteButton.setLayoutX(1100);
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

        editButton.setLayoutX(1040);
        editButton.setLayoutY(625);
        editButton.setText("Edit");
        editButton.setOnAction(e -> this.editButtonAction());



        //Adding Nodes
        group.getChildren().add(aPane);
        group.getChildren().add(productsListTableView);
        group.getChildren().add(productNameField);
        group.getChildren().add(productPriceField);
        group.getChildren().add(productQuantityField);
        group.getChildren().add(editNameField);
        group.getChildren().add(editProductID);
        group.getChildren().add(editChoiceBox);
        group.getChildren().add(editPriceField);
        group.getChildren().add(editQuantityField);
        group.getChildren().add(backButton);
        group.getChildren().add(addButton);
        group.getChildren().add(deleteButton);
        group.getChildren().add(editButton);
        group.getChildren().add(alertLabel);
        group.getChildren().add(categoryChoiceBox);
        return group;
    }


        public void addButtonAction(){
            ProductEntity products = new ProductEntity();
            if((!productNameField.getText().equals(""))||(!productPriceField.getText().equals(""))||(!productQuantityField.getText().equals(""))){
                try {
                    products.setName(productNameField.getText());
                    products.setPrice(Integer.parseInt(productPriceField.getText()));
                    products.setQuantity(Integer.parseInt(productQuantityField.getText()));
                    products.setCategory(categoryChoiceBox.getValue());
                    try{
                        controller.addButtonAction(products);}
                    catch (SQLException exception){
                        alertLabel.setText("The Name of Product is Already Used");
                    }
                }catch (Exception exception){
                    alertLabel.setText("Please Enter The Fields Correctly");
                }
            }
            else {
                alertLabel.setText("Please Fill All The Fields");
            }
    }


        public void deleteButtonAction(){
            ProductEntity p ;
            p = productsListTableView.getSelectionModel().getSelectedItem();
            System.out.println(p.getId());
            try {
                controller.deleteButtonAction(p.getId());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }


        public void editButtonAction(){
            ProductEntity editP = new ProductEntity();
            if((!editNameField.getText().equals(""))&&(!editPriceField.getText().equals(""))&&(!editQuantityField.getText().equals(""))&&(!String.valueOf(editProductID).equals(""))){
                try{
                    editP.setId(Integer.parseInt(editProductID.getText()));
                    editP.setName(editNameField.getText());
                    editP.setPrice(Integer.parseInt(editPriceField.getText()));
                    editP.setQuantity(Integer.parseInt(editQuantityField.getText()));
                    editP.setCategory(editChoiceBox.getValue());
                    try{
                        controller.editButtonAction(editP);}
                    catch(SQLException exception){
                        System.out.println("please enter the fields correctly");
                        alertLabel.setText("Please Enter The Fields Correctly");
                        Main.showAdminProducts();
                    }
                }
                catch (Exception e2){
                    alertLabel.setText("Please Enter The EditFields Correctly");
                }

            }
            else {
                alertLabel.setText("Please Fill All The EditFields");
            }

        }
}
