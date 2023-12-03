package com.fp.order.result_page;

import com.fp.model.entity.CustomerEntity;
import com.fp.model.entity.OrderEntity;
import com.fp.model.entity.ProductEntity;
import com.fp.model.service.EditCustomerService;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashSet;

public class ResultPageView {
    public Stage resultWindow = new Stage();
    public Group group = new Group();
    public ScrollPane scrollPane = new ScrollPane();
    public AnchorPane mainPane = new AnchorPane();

    public ImageView head = new ImageView("resource/Invoice/head.png");
    public ImageView total = new ImageView("resource/Invoice/Total.png");

    public Label inv_num_label = new Label("");
    public Label date_label = new Label("");
    public Label client_name_label = new Label("");
    public Label client_address_label = new Label("");
    public Label client_phone_label = new Label("");
    public Label total_label = new Label("");

    public Button button = new Button();

    public void ResultPage(LinkedHashSet<ProductEntity> set, OrderEntity order, int total_price) throws SQLException {

        CustomerEntity customer = EditCustomerService.getInstance().getCustomer(order.getCustomer_id());

        int product_num = set.size();
        mainPane.setPrefWidth(1024);
        mainPane.getChildren().add(head);


        inv_num_label.setText(String.valueOf(order.getOrder_id()));
        inv_num_label.setLayoutX(82);
        inv_num_label.setLayoutY(250);
        inv_num_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");
        mainPane.getChildren().add(inv_num_label);


        date_label.setText(String.valueOf(order.getOrder_date()));
        date_label.setLayoutX(310);
        date_label.setLayoutY(250);
        date_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");
        mainPane.getChildren().add(date_label);


        client_name_label.setText(customer.getFirstName() + " " + customer.getLastName());
        client_name_label.setLayoutX(82);
        client_name_label.setLayoutY(370);
        client_name_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");
        mainPane.getChildren().add(client_name_label);


        client_address_label.setText(customer.getAddress());
        client_address_label.setLayoutX(82);
        client_address_label.setLayoutY(400);
        client_address_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");
        mainPane.getChildren().add(client_address_label);


        client_phone_label.setText(customer.getPhone());
        client_phone_label.setLayoutX(82);
        client_phone_label.setLayoutY(430);
        client_phone_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");
        mainPane.getChildren().add(client_phone_label);

        int i = 1;
        for (ProductEntity p : set){
            ItemPane itemPane = new ItemPane();
            Pane pane = itemPane.getPane(i, p);
            pane.setLayoutX(0);
            pane.setLayoutY(648+((i-1)*80));
            mainPane.getChildren().add(pane);
            i++;
        }

        total.setLayoutX(0);
        total.setLayoutY(648+(product_num*80));
        mainPane.getChildren().add(total);


        total_label.setText(String.valueOf(total_price));
        total_label.setLayoutX(83);
        total_label.setLayoutY(761+(product_num*80));
        total_label.setTextFill(Color.BLUE);
        total_label.setStyle("-fx-font-size: 30px ;" +
                "-fx-font-weight : bold ;");
        mainPane.getChildren().add(total_label);

        button.setLayoutX(512);
        button.setLayoutY(850+(product_num*80));
        button.setText("save");

        mainPane.getChildren().add(button);

        scrollPane.setContent(mainPane);
        scrollPane.setPrefSize(1024,800);
        group.getChildren().add(scrollPane);




        resultWindow.setScene(new Scene(group,1024,800));
        resultWindow.setResizable(false);

        button.setOnAction(e ->{
            button.setVisible(false);
            FileChooser saveFile = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("PNG file (*.png)", "*.png");
            saveFile.getExtensionFilters().add(extensionFilter);
            saveFile.setTitle("Save");

            File file = saveFile.showSaveDialog(resultWindow);
            if (file != null){
                try{
                    WritableImage writableImage = new WritableImage(1024, 926+(product_num*80));
                    mainPane.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, "png", file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
            button.setVisible(true);
        });

        resultWindow.show();
    }
}
