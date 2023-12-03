package com.fp.main_page;

import com.fp.model.service.MainPageService;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.SQLException;

public class MainPageView {
    public MainPageController mainPageController = new MainPageController();
    public Group group = new Group();
    public Image backgroundImage = new Image("resource/Background MainPage.png");
    public ImageView background = new ImageView(backgroundImage);
    public AnchorPane aPane = new AnchorPane();
    public Button loginButton = new Button();
    public Button logoutButton = new Button();
    public Button shopButton = new Button();
    public Button cartButton= new Button();
    public Button editProfileButton= new Button();
    public Button commentsButton = new Button();
    public Label welcomeLabel = new Label();
    public Label alertLabel = new Label();
    public Button adminProductsButton= new Button();
    public Button editAdminsButton= new Button();
    public Button editCustomersButton= new Button();

    public Group getRoot() throws SQLException {


        aPane.setPrefHeight(720);
        aPane.setPrefWidth(1280);
        loginButton.setLayoutX(30);
        loginButton.setLayoutY(30);
        loginButton.setText("Login");
        loginButton.setOnAction(e -> {
            try {
                mainPageController.loginAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        loginButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        logoutButton.setLayoutX(1160);
        logoutButton.setLayoutY(660);
        logoutButton.setText("Logout");
        logoutButton.setOnAction(e -> mainPageController.logoutAction());
        logoutButton.setDisable(true);
        logoutButton.setVisible(false);
        logoutButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );



        welcomeLabel.setLayoutX(40);
        welcomeLabel.setLayoutY(10);
        welcomeLabel.prefHeight(110);
        welcomeLabel.setPrefWidth(570);
        welcomeLabel.setText("");
        welcomeLabel.setTextFill(Color.RED);
        welcomeLabel.setVisible(false);
        welcomeLabel.setDisable(true);
        welcomeLabel.setStyle("-fx-font-size: 50px ;" +
                "-fx-font-weight : bold ;");


        shopButton.setLayoutX(90);
        shopButton.setLayoutY(205);
        shopButton.setText("Shop");
        shopButton.setOnAction(e -> {
            try {
                mainPageController.shopButtonAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        shopButton.setDisable(true);
        shopButton.setPrefHeight(155);
        shopButton.setPrefWidth(170);
        shopButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);"+
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        cartButton.setLayoutX(271);
        cartButton.setLayoutY(205);
        cartButton.setText("Cart");
        cartButton.setOnAction(e -> {
            try {
                mainPageController.CartButtonAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        cartButton.setDisable(true);
        cartButton.setPrefHeight(155);
        cartButton.setPrefWidth(170);
        cartButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);"+
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        editProfileButton.setLayoutX(90);
        editProfileButton.setLayoutY(371);
        editProfileButton.setText("Edit Profile");
        editProfileButton.setOnAction(e -> {
            try {
                mainPageController.editProfileButtonAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        editProfileButton.setDisable(true);
        editProfileButton.setPrefHeight(155);
        editProfileButton.setPrefWidth(170);
        editProfileButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);"+
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        commentsButton.setLayoutX(271);
        commentsButton.setLayoutY(371);
        commentsButton.setText("Comment");
        commentsButton.setOnAction(e -> {
            try {
                mainPageController.commentButtonAction();
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
        });
        commentsButton.setDisable(true);
        commentsButton.setPrefHeight(155);
        commentsButton.setPrefWidth(170);
        commentsButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);"+
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        adminProductsButton.setLayoutX(90);
        adminProductsButton.setLayoutY(205);
        adminProductsButton.setText("Products");
        adminProductsButton.setOnAction(e -> {
            try {
                mainPageController.adminProductsAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        adminProductsButton.setDisable(true);
        adminProductsButton.setVisible(false);
        adminProductsButton.setPrefHeight(155);
        adminProductsButton.setPrefWidth(170);
        adminProductsButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);"+
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );



        editAdminsButton.setLayoutX(90);
        editAdminsButton.setLayoutY(371);
        editAdminsButton.setText("Admins");
        editAdminsButton.setOnAction(e -> {
            try {
                mainPageController.editAdminsAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        editAdminsButton.setDisable(true);
        editAdminsButton.setVisible(false);
        editAdminsButton.setPrefHeight(155);
        editAdminsButton.setPrefWidth(170);
        editAdminsButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);"+
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        editCustomersButton.setLayoutX(271);
        editCustomersButton.setLayoutY(205);
        editCustomersButton.setText("Customers");
        editCustomersButton.setOnAction(e -> {
            try {
                mainPageController.editCustomersAction();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        editCustomersButton.setDisable(true);
        editCustomersButton.setVisible(false);
        editCustomersButton.setPrefHeight(155);
        editCustomersButton.setPrefWidth(170);
        editCustomersButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);"+
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        alertLabel.setLayoutX(90);
        alertLabel.setLayoutY(537);
        alertLabel.setText("Please Login to Use...");
        alertLabel.setTextFill(Color.RED);
        alertLabel.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");

        String role = MainPageService.getInstance().getRole();

        if (role.equals("customer")){
            System.out.println("customer");
            welcomeLabel.setDisable(false);
            welcomeLabel.setVisible(true);
            welcomeLabel.setText("Hello "+MainPageService.getInstance().getUserName());
            loginButton.setVisible(false);
            loginButton.setDisable(true);
            logoutButton.setDisable(false);
            logoutButton.setVisible(true);
            shopButton.setDisable(false);
            cartButton.setDisable(false);
            editProfileButton.setDisable(false);
            commentsButton.setDisable(false);
            alertLabel.setVisible(false);
            alertLabel.setDisable(true);
        }
        if (role.equals("admin")){
            System.out.println("admin");
            welcomeLabel.setDisable(false);
            welcomeLabel.setVisible(true);
            welcomeLabel.setText("Admin : "+MainPageService.getInstance().getUserName());

            alertLabel.setVisible(false);
            alertLabel.setDisable(true);

            loginButton.setVisible(false);
            loginButton.setDisable(true);
            logoutButton.setDisable(false);
            logoutButton.setVisible(true);

            adminProductsButton.setDisable(false);
            adminProductsButton.setVisible(true);


            editAdminsButton.setDisable(false);
            editAdminsButton.setVisible(true);

            editCustomersButton.setDisable(false);
            editCustomersButton.setVisible(true);

            //disable customers Buttons

            shopButton.setDisable(true);
            shopButton.setVisible(false);

            cartButton.setDisable(true);
            cartButton.setVisible(false);

            editProfileButton.setDisable(true);
            editProfileButton.setVisible(false);

            commentsButton.setDisable(true);
            commentsButton.setVisible(false);

        }


        group.getChildren().add(aPane);
        group.getChildren().add(background);
        group.getChildren().add(loginButton);
        group.getChildren().add(logoutButton);
        group.getChildren().add(welcomeLabel);
        group.getChildren().add(shopButton);
        group.getChildren().add(cartButton);
        group.getChildren().add(editProfileButton);
        group.getChildren().add(commentsButton);
        group.getChildren().add(alertLabel);
        group.getChildren().add(adminProductsButton);
        group.getChildren().add(editAdminsButton);
        group.getChildren().add(editCustomersButton);

        return group;
    }
}
