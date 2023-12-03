package com.fp.products.shop_page;



import com.fp.main.Main;
import com.fp.model.service.ProductsService;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowProductsView {
    public Group group = new Group();

    public AnchorPane aPane = new AnchorPane();

    public Image backgroundImage = new Image("resource/Background.png");
    public ImageView background = new ImageView(backgroundImage);

    public Button backButton = new Button();
    public Button showButton = new Button();
    public Button selectButton = new Button();

    public int productsNum = 0;
    public int pageNum = 0;

    public ChoiceBox<String> categoryChoiceBox = new ChoiceBox<>();
    public ChoiceBox<Integer> pageChoiceBox = new ChoiceBox<>();

    public ResultSet productsResultSet;

    public Pane p1 = new Pane();
    public Pane p2 = new Pane();
    public Pane p3 = new Pane();
    public Pane p4 = new Pane();
    public Pane p5 = new Pane();
    public Pane p6 = new Pane();
    public Pane p7 = new Pane();
    public Pane p8 = new Pane();
    public Pane p9 = new Pane();
    public Pane p10 = new Pane();

    public static String category = "";

    public ShowProductsView() {

        //setting aPane and background


        aPane.setPrefHeight(720);
        aPane.setPrefWidth(1280);
        aPane.getChildren().add(background);


        //setting buttons


        backButton.setLayoutX(14);
        backButton.setLayoutY(14);
        backButton.setText("Back");
        backButton.setOnAction(e -> {
            try {
                Main.showMainPage();
            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }
        });
        backButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );

        showButton.setLayoutX(1214);
        showButton.setLayoutY(14);
        showButton.setText("Show");
        showButton.setOnAction(e -> {
            try {
                this.showButton();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        showButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );
        showButton.setDisable(true);

        selectButton.setLayoutX(250);
        selectButton.setLayoutY(14);
        selectButton.setText("Select");
        selectButton.setOnAction(e -> {
            try {
                this.selectButton();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        selectButton.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
                "-fx-background-radius: 30; " +
                "-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; " );


        //setting choiceBox


        categoryChoiceBox.getItems().addAll("All","Clothing","Food","Book Stationary", "Home", "Tools", "Electronics");
        categoryChoiceBox.setLayoutX(100);
        categoryChoiceBox.setLayoutY(14);
        categoryChoiceBox.setValue("All");




        // adding nodes to parent

        group.getChildren().add(aPane);
        group.getChildren().add(backButton);
        group.getChildren().add(showButton);
        group.getChildren().add(selectButton);
        group.getChildren().add(categoryChoiceBox);
        group.getChildren().add(p1);
        group.getChildren().add(p2);
        group.getChildren().add(p3);
        group.getChildren().add(p4);
        group.getChildren().add(p5);
        group.getChildren().add(p6);
        group.getChildren().add(p7);
        group.getChildren().add(p8);
        group.getChildren().add(p9);
        group.getChildren().add(p10);
    }



    public Group getRoot() throws SQLException {
        return group;
    }



    public void showButton() throws SQLException {
        int page = pageChoiceBox.getValue();
        if (category.equals("All")){
            System.out.println("all");
            productsResultSet = null;
            productsResultSet = ProductsService.getInstance().getProductsID();
        }
        else{
            System.out.println("others");
            productsResultSet = null;
            productsResultSet = ProductsService.getInstance().getProductsNumber(category);
        }
        for (int i=0;i < (10*(page - 1));i++)
            productsResultSet.next();
        try{
            productsResultSet.next();
            group.getChildren().remove(p1);
            p1 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p1.setLayoutY(51);
            p1.setLayoutX(680);
            group.getChildren().add(p1);
        }
        catch (Exception e){
            System.out.println("p1 is empty");

        }
        try{
            group.getChildren().remove(p2);
            productsResultSet.next();
            p2 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p2.setLayoutY(51);
            p2.setLayoutX(100);
            group.getChildren().add(p2);
        }
        catch (Exception e){
            System.out.println("p2 is empty");
        }
        try{
            group.getChildren().remove(p3);
            productsResultSet.next();
            p3 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p3.setLayoutY(182);
            p3.setLayoutX(680);
            group.getChildren().add(p3);
        }
        catch (Exception e){
            System.out.println("p3 is empty");
        }
        try{
            group.getChildren().remove(p4);
            productsResultSet.next();
            p4 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p4.setLayoutY(182);
            p4.setLayoutX(100);
            group.getChildren().add(p4);
        }
        catch (Exception e){
            System.out.println("p4 is empty");
        }
        try{
            group.getChildren().remove(p5);
            productsResultSet.next();
            p5 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p5.setLayoutY(313);
            p5.setLayoutX(680);
            group.getChildren().add(p5);
        }
        catch (Exception e){
            System.out.println("p5 is empty");
        }
        try{
            group.getChildren().remove(p6);
            productsResultSet.next();
            p6 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p6.setLayoutY(313);
            p6.setLayoutX(100);
            group.getChildren().add(p6);
        }
        catch (Exception e){
            System.out.println("p6 is empty");
        }
        try{
            group.getChildren().remove(p7);
            productsResultSet.next();
            p7 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p7.setLayoutY(444);
            p7.setLayoutX(680);
            group.getChildren().add(p7);
        }
        catch (Exception e){
            System.out.println("p7 is empty");
        }try{
            group.getChildren().remove(p8);
            productsResultSet.next();
            p8 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p8.setLayoutY(444);
            p8.setLayoutX(100);
            group.getChildren().add(p8);
        }
        catch (Exception e){
            System.out.println("p8 is empty");
        }try{
            group.getChildren().remove(p9);
            productsResultSet.next();
            p9 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p9.setLayoutY(575);
            p9.setLayoutX(680);
            group.getChildren().add(p9);
        }
        catch (Exception e){
            System.out.println("p9 is empty");
        }try{
            group.getChildren().remove(p10);
            productsResultSet.next();
            p10 = new ProductPane().getProductPane(productsResultSet.getInt(1));
            p10.setLayoutY(575);
            p10.setLayoutX(100);
            group.getChildren().add(p10);
        }
        catch (Exception e){
            System.out.println("p10 is empty");
        }

    }



    public void selectButton () throws SQLException {
        category = categoryChoiceBox.getValue();
        if (category.equals("All")){
            System.out.println("all");
            productsResultSet = null;
            productsResultSet = ProductsService.getInstance().getProductsID();
        }
        else{
            System.out.println("others");
            productsResultSet = null;
            productsResultSet = ProductsService.getInstance().getProductsNumber(category);
        }
        while (productsResultSet.next()){
            productsNum++;
        }
        pageNum = productsNum/10;
        if (productsNum - (pageNum*10) != 0|| pageNum == 0 ){
            pageNum++;
        }
        pageChoiceBox.setLayoutX(1000);
        pageChoiceBox.setLayoutY(14);

        for (int i=1 ; i<=pageNum ; i++){
        pageChoiceBox.getItems().add(i);
        }
        pageChoiceBox.setValue(1);

        group.getChildren().add(pageChoiceBox);
        categoryChoiceBox.setDisable(true);
        showButton.setDisable(false);
        selectButton.setDisable(true);
        group.getChildren().remove(p1);
        group.getChildren().remove(p2);
        group.getChildren().remove(p3);
        group.getChildren().remove(p4);
        group.getChildren().remove(p5);
        group.getChildren().remove(p6);
        group.getChildren().remove(p7);
        group.getChildren().remove(p8);
        group.getChildren().remove(p9);
        group.getChildren().remove(p10);
        showButton();
    }
}
