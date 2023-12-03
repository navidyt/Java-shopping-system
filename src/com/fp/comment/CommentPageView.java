package com.fp.comment;


import com.fp.main.Main;
import com.fp.model.service.CustomerLoginService;
import com.fp.model.service.MainPageService;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.SQLException;

public class CommentPageView {
    public Group group = new Group();
    public Image backgroundImage = new Image("resource/Background.png");
    public ImageView background = new ImageView(backgroundImage);
    public AnchorPane aPane = new AnchorPane();
    public TextArea textArea = new TextArea();
    public Label label = new Label();
    public Button button = new Button();
    public Button backButton = new Button();


    public Group getRoot() {
        aPane.setPrefHeight(720);
        aPane.setPrefWidth(1280);

        label.setLayoutX(245);
        label.setLayoutY(130);
        label.setText("Your Comment");
        label.setStyle("-fx-font-size: 15px ;" +
                "-fx-font-weight : bold ;" +
                "-fx-text-fill: white; ");


        textArea.setLayoutX(245);
        textArea.setLayoutY(170);
        textArea.setPrefHeight(300);
        textArea.setPrefWidth(500);
        textArea.setTextFormatter(new TextFormatter<String>(change ->
                change.getControlNewText().length() <= 2499 ? change : null));


        button.setLayoutX(245);
        button.setLayoutY(500);
        button.setText("Send");
        button.setOnAction(e -> {
            this.sendAction();
        });
        button.setStyle("-fx-background-color:  linear-gradient(#ff5400, #be1d00);\n"+
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
                Main.showMainPage();
            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
            }
        });




        group.getChildren().add(aPane);
        group.getChildren().add(background);
        group.getChildren().add(label);
        group.getChildren().add(textArea);
        group.getChildren().add(button);
        group.getChildren().add(backButton);
        return group;
    }


    private void sendAction() {
        String string = textArea.getText();
        try {
            int user_id = CustomerLoginService.getInstance().getUserId();
            MainPageService.getInstance().sendComment(user_id, string);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
