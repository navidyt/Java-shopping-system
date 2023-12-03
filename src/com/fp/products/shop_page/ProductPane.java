package com.fp.products.shop_page;

import com.fp.model.entity.CartEntity;
import com.fp.model.entity.ProductEntity;
import com.fp.model.service.CartService;
import com.fp.model.service.CustomerLoginService;
import com.fp.model.service.ProductsService;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class ProductPane {
    public Pane pane = new Pane();

    public Button addButton = new Button();

    public Image pBack = new Image("resource/P back.png");

    public Label nameLabel = new Label("");
    public Label priceLabel = new Label("");
    public Label alertLabel = new Label("");


    public ChoiceBox<Integer> quantityChoiceBox = new ChoiceBox<>();

    public ProductPane() {
    }

    public Pane getProductPane(int id) throws SQLException {
        if (id != 0) {
            ProductEntity product = ProductsService.getInstance().getProduct(id);
            nameLabel.setText(product.getName());
            nameLabel.setLayoutX(150);
            nameLabel.setLayoutY(1);
            nameLabel.setTextFill(Color.WHITE);
            nameLabel.setStyle("-fx-font-size : 20px;\n" +
                    "-fx-font-weight : BOLD;");
        if (product.getQuantity()!=0)   {
            priceLabel.setText(String.valueOf(product.getPrice()));
            priceLabel.setTextFill(Color.web("#77ff00"));
        }
        else   {
            priceLabel.setText("Out of Stock");
            priceLabel.setTextFill(Color.RED);
            quantityChoiceBox.setDisable(true);
            addButton.setDisable(true);
        }

            priceLabel.setLayoutX(150);
            priceLabel.setLayoutY(43);
            priceLabel.setStyle("-fx-font-size : 20px;\n" +
                    "-fx-font-weight : BOLD;");

            alertLabel.setLayoutX(150);
            alertLabel.setLayoutY(75);
            alertLabel.setStyle("-fx-font-size : 20px;\n" +
                    "-fx-font-weight : BOLD;");

            addButton.setLayoutX(22);
            addButton.setLayoutY(43);
            addButton.setText("<");
            addButton.setOnAction(e -> {
                try {
                    this.addProductButton(product);
                    alertLabel.setTextFill(Color.web("#77ff00"));
                    alertLabel.setText("Added to Cart");
                } catch (SQLException ex) {
                    alertLabel.setTextFill(Color.RED);
                    alertLabel.setText("Already in the Cart");
                }
            });
            addButton.setStyle("-fx-background-color: #77ff00;" +
                    "-fx-background-radius: 30; ");



            if (product.getQuantity()>=10){
                quantityChoiceBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
            }
            else{
                for (int i=1;i <= product.getQuantity();i++){
                    quantityChoiceBox.getItems().add(i);
                }
            }
            quantityChoiceBox.setLayoutX(53);
            quantityChoiceBox.setLayoutY(43);
            quantityChoiceBox.setStyle("-fx-background-color: #77ff00;" +
                    "-fx-background-radius: 30; ");
            quantityChoiceBox.setValue(1);

            pane.setPrefHeight(110);
            pane.setPrefWidth(500);
            pane.getChildren().add(new ImageView(pBack));
            pane.getChildren().add(addButton);
            pane.getChildren().add(nameLabel);
            pane.getChildren().add(priceLabel);
            pane.getChildren().add(quantityChoiceBox);
            pane.getChildren().add(alertLabel);
        }

        return pane;
    }
    public void addProductButton(ProductEntity product) throws SQLException {
        CartEntity e = new CartEntity();
        e.setProductId(product.getId());
        e.setQuantity(quantityChoiceBox.getValue());
        e.setCustomerId(CustomerLoginService.getInstance().getUserId());
        e.setCode(CustomerLoginService.getInstance().getUserId()+"!"+product.getId());
        e.setPrice(product.getPrice());
        CartService.getInstance().addToCart(e);
    }

}
