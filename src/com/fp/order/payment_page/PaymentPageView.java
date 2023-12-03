package com.fp.order.payment_page;

import com.fp.main.Main;
import com.fp.model.entity.CustomerEntity;
import com.fp.model.entity.PaymentEntity;
import com.fp.model.entity.ProductEntity;
import com.fp.model.service.EditCustomerService;
import com.fp.model.service.OrderService;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedHashSet;

public class PaymentPageView {
    public Stage paymentWindow = new Stage();
    public Group group = new Group();
    public int user_id;
    public int total_price;
    public Date date = new Date(System.currentTimeMillis());
    public Time time = new Time(System.currentTimeMillis());
    public AnchorPane aPane = new AnchorPane();

    public Image backgroundImage = new Image("resource/PaymentPageBackGround.png");
    public ImageView background = new ImageView(backgroundImage);

    public Label userNameLabel = new Label();
    public Label dateLabel = new Label();
    public Label timeLabel = new Label();
    public Label cardNumberLabel = new Label();
    public Label passwordLabel = new Label();
    public Label totalPriceLabel = new Label();

    public TextField cardNumberField = new TextField();

    public PasswordField passwordField = new PasswordField();

    public Button trueButton = new Button();
    public Button falseButton = new Button();


    public void PaymentPage(int userId, int totalPrice, LinkedHashSet<ProductEntity> set) throws SQLException {
        user_id = userId;
        total_price = totalPrice;

        CustomerEntity c = EditCustomerService.getInstance().getCustomer(user_id);

        //setting aPane and background

        aPane.setPrefHeight(640);
        aPane.setPrefWidth(720);
        aPane.getChildren().add(background);

        //setting labels

        userNameLabel.setLayoutX(140);
        userNameLabel.setLayoutY(74);
        userNameLabel.setTextFill(Color.BLACK);
        userNameLabel.setText("User : " + c.getUserName());
        userNameLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");

        dateLabel.setLayoutX(140);
        dateLabel.setLayoutY(123);
        dateLabel.setTextFill(Color.BLACK);
        dateLabel.setText("Date : "+date);
        dateLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");

        timeLabel.setLayoutX(140);
        timeLabel.setLayoutY(175);
        timeLabel.setTextFill(Color.BLACK);
        timeLabel.setText("Time : "+ time);
        timeLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");


        totalPriceLabel.setLayoutX(140);
        totalPriceLabel.setLayoutY(240);
        totalPriceLabel.setTextFill(Color.BLACK);
        totalPriceLabel.setText("Total Price : "+ totalPrice);
        totalPriceLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");


        cardNumberLabel.setLayoutX(140);
        cardNumberLabel.setLayoutY(311);
        cardNumberLabel.setTextFill(Color.BLACK);
        cardNumberLabel.setText("Card Number : ");
        cardNumberLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");

        passwordLabel.setLayoutX(140);
        passwordLabel.setLayoutY(419);
        passwordLabel.setTextFill(Color.BLACK);
        passwordLabel.setText("Password : ");
        passwordLabel.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;");


        //setting fields
        cardNumberField.setLayoutX(140);
        cardNumberField.setLayoutY(364);
        cardNumberField.setPrefWidth(360);
        cardNumberField.setPrefHeight(20);


        passwordField.setLayoutX(140);
        passwordField.setLayoutY(477);
        passwordField.setPrefWidth(360);
        passwordField.setPrefHeight(25);


        //setting buttons

        trueButton.setLayoutX(320);
        trueButton.setLayoutY(580);
        trueButton.setText("✓");
        trueButton.setStyle("-fx-background-color: #77ff00;" +
                "-fx-background-radius: 30; ");
        trueButton.setOnAction(e -> {
            if (!cardNumberField.getText().equals("")){
            PaymentEntity payment = new PaymentEntity(user_id, total_price, cardNumberField.getText(), date, time);
                try {
                    this.trueButtonAction(user_id, set, payment);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            else{
                cardNumberLabel.setText("Card Number :   please provide a card number");
            }
        });

        falseButton.setLayoutX(260);
        falseButton.setLayoutY(580);
        falseButton.setText("x");
        falseButton.setStyle("-fx-background-color: RED;" +
                "-fx-background-radius: 30; ");
        falseButton.setOnAction(e -> {
            try {
                this.falseButtonAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        group.getChildren().add(background);
        group.getChildren().add(userNameLabel);
        group.getChildren().add(dateLabel);
        group.getChildren().add(timeLabel);
        group.getChildren().add(totalPriceLabel);
        group.getChildren().add(cardNumberLabel);
        group.getChildren().add(passwordLabel);
        group.getChildren().add(cardNumberField);
        group.getChildren().add(passwordField);
        group.getChildren().add(trueButton);
        group.getChildren().add(falseButton);
        paymentWindow.setScene(new Scene(group));
        paymentWindow.setResizable(false);
        paymentWindow.show();
        paymentWindow.setOnCloseRequest(e ->{
            try {
                this.falseButtonAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

    }

    private void trueButtonAction(int user_id, LinkedHashSet<ProductEntity> set, PaymentEntity payment) throws SQLException {
        OrderService.getInstance().PlaceOrder(user_id, set, payment);
        paymentWindow.close();
        try {
            Main.showMainPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void falseButtonAction() throws SQLException {
        Main.showCartPage("Payment failed");
        paymentWindow.close();
    }
}
