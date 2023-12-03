package com.fp.main_page;


import javafx.scene.Group;
import javafx.scene.Scene;
import java.io.IOException;
import java.sql.SQLException;



public class MainPage {
    //singleton class
    private static final MainPage mainPage = new MainPage();
    public static MainPage getInstance() {return mainPage;}
    private MainPage(){}

    public Scene getMainPage() throws SQLException {
        MainPageView mainPageView = new MainPageView();
        Group root = mainPageView.getRoot();
        return new Scene(root);
    }
}
