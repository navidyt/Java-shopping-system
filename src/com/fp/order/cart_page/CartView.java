package com.fp.order.cart_page;

import com.fp.model.entity.ProductEntity;
import com.fp.model.service.CartService;
import com.fp.model.service.CustomerLoginService;
import com.fp.order.payment_page.PaymentPageView;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashSet;

public class CartView {
    CartController controller = new CartController();

    public int userId = CustomerLoginService.getInstance().getUserId();

    public Group group = new Group();

    public AnchorPane aPane = new AnchorPane();
    public Image backgroundImage = new Image("resource/Background.png");
    public ImageView background = new ImageView(backgroundImage);


    public Button deleteButton = new Button();
    public Button backButton = new Button();
    public Button purchaseButton = new Button();

    public TableView<ProductEntity> productsListTableView = new TableView<>();

    public TableColumn<ProductEntity, String> nameColumn = new TableColumn<>("Name");
    public TableColumn<ProductEntity, Integer> priceColumn = new TableColumn<>("Price");
    public TableColumn<ProductEntity, Integer> idColumn = new TableColumn<>("ProductID");
    public TableColumn<ProductEntity, String> categoryColumn = new TableColumn<>("Category");
    public TableColumn<ProductEntity, String> quantityInCartColumn = new TableColumn<>("InCart");
    public TableColumn<ProductEntity, String> totalPriceColumn = new TableColumn<>("Total Price");

    public Label alertLabel = new Label();
    public Label totalPriceLabel = new Label();

    public String alert = "";

    public LinkedHashSet<ProductEntity> cartSet = new LinkedHashSet<>();

    public CartView() throws SQLException {
    }

    public Group getRoot(String status) throws SQLException {
        cartSet = CartController.getProductsSet(userId);

        //Setting Pane
        aPane.setPrefHeight(720);
        aPane.setPrefWidth(1280);
        aPane.getChildren().add(background);



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


        categoryColumn.setMinWidth(430);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        quantityInCartColumn.setMinWidth(100);
        quantityInCartColumn.setCellValueFactory(new PropertyValueFactory<>("quantityInCart"));

        totalPriceColumn.setMinWidth(148);
        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        productsListTableView = new TableView<>();
        productsListTableView.setItems(controller.getProductsList(userId));
        productsListTableView.getColumns().add(idColumn);
        productsListTableView.getColumns().add(nameColumn);
        productsListTableView.getColumns().add(categoryColumn);
        productsListTableView.getColumns().add(priceColumn);
        productsListTableView.getColumns().add(quantityInCartColumn);
        productsListTableView.getColumns().add(totalPriceColumn);
        productsListTableView.getSortOrder().add(idColumn);



        //Setting Label
        alertLabel.setLayoutX(15);
        alertLabel.setLayoutY(600);
        alertLabel.setTextFill(Color.RED);
        alertLabel.setText(status);
        alertLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        totalPriceLabel.setLayoutX(300);
        totalPriceLabel.setLayoutY(560);
        totalPriceLabel.setTextFill(Color.WHITE);
        totalPriceLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");
        totalPriceLabel.setText("Total Price : " + CartService.getInstance().getTotalPrice(userId));

        //Setting Buttons
        deleteButton.setLayoutX(1100);
        deleteButton.setLayoutY(675);
        deleteButton.setText("Delete");
        deleteButton.setOnAction(e -> this.deleteButtonAction());
        deleteButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );

        backButton.setLayoutX(1200);
        backButton.setLayoutY(675);
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




        purchaseButton.setLayoutX(1000);
        purchaseButton.setLayoutY(675);
        purchaseButton.setText("Purchase");
        purchaseButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );
        purchaseButton.setOnAction(e -> {
            PaymentPageView payment = new PaymentPageView();
            try {
                payment.PaymentPage(userId, CartService.getInstance().getTotalPrice(userId), cartSet);
            } catch (SQLException ex) {
                System.out.println("can not call payment page");
                ex.printStackTrace();
            }
        });

        if (!checkWithInventory()){
            purchaseButton.setDisable(true);
            alertLabel.setText("remove items with these ids to purchase : "+alert);
            totalPriceLabel.setVisible(false);
        }


        //Adding Nodes
        group.getChildren().add(aPane);
        group.getChildren().add(productsListTableView);
        group.getChildren().add(backButton);
        group.getChildren().add(deleteButton);
        group.getChildren().add(purchaseButton);
        group.getChildren().add(alertLabel);
        group.getChildren().add(totalPriceLabel);

        return group;
    }


    public boolean checkWithInventory() {
            boolean result = true;
            for (ProductEntity cartP : cartSet){
                if ((cartP.getQuantity() - cartP.getQuantityInCart())<0){
                alert = alert +"  "+ cartP.getId();
                System.out.println(alert);
                result = false;
                }
            }
        return result;
        }

        public void deleteButtonAction(){
            ProductEntity p ;
            p = productsListTableView.getSelectionModel().getSelectedItem();
            if( p != null){
            try {
                controller.deleteButtonAction(userId,p.getId());
            } catch (SQLException ex) {
                ex.printStackTrace();
                    }
                }
            }
        }

