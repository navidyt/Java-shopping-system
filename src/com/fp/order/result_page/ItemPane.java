package com.fp.order.result_page;

import com.fp.model.entity.ProductEntity;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ItemPane {

    public Pane pane = new Pane();

    public ImageView imageView = new ImageView("resource/Invoice/item.png");

    public Label name_label = new Label("");
    public Label no_label = new Label("");
    public Label unit_cost_label = new Label("");
    public Label quantity_label = new Label("");
    public Label total_label = new Label("");
    public Pane getPane(int i, ProductEntity p) {
        pane.getChildren().add(imageView);

        name_label.setText(p.getName());
        name_label.setLayoutX(153);
        name_label.setLayoutY(30);
        name_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");


        no_label.setText(String.valueOf(i));
        no_label.setLayoutX(76);
        no_label.setLayoutY(30);
        no_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");


        unit_cost_label.setText(String.valueOf(p.getPrice()));
        unit_cost_label.setLayoutX(566);
        unit_cost_label.setLayoutY(30);
        unit_cost_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");


        quantity_label.setText(String.valueOf(p.getQuantityInCart()));
        quantity_label.setLayoutX(741);
        quantity_label.setLayoutY(30);
        quantity_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");

        total_label.setText(String.valueOf(p.getQuantityInCart() * p.getPrice()));
        total_label.setLayoutX(831);
        total_label.setLayoutY(30);
        total_label.setStyle("-fx-font-size: 20px ;" +
                "-fx-font-weight : bold ;");

        pane.getChildren().add(name_label);
        pane.getChildren().add(no_label);
        pane.getChildren().add(unit_cost_label);
        pane.getChildren().add(quantity_label);
        pane.getChildren().add(total_label);


        return pane;
    }
}
