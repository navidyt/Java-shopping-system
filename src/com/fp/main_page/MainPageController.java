package com.fp.main_page;


import com.fp.model.service.CustomerLoginService;
import com.fp.main.Main;
import com.fp.model.service.MainPageService;
import java.io.IOException;
import java.sql.SQLException;

public class MainPageController {


    public void loginAction() throws SQLException {
        //opens the LoginPage
        if (MainPageService.getInstance().getRole().equals("guest")) {
            try {
                Main.showLoginPage();
            } catch (IOException e) {
                System.out.println("loginAction failed");
            }
        }
    }


    public void logoutAction(){
        try {
            CustomerLoginService.getInstance().cleanUser();
            Main.showMainPage();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("logout failed");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public void shopButtonAction() throws SQLException {
        Main.showShopPage();
    }


    public void CartButtonAction() throws SQLException {
        Main.showCartPage("");
    }


    public void editProfileButtonAction() throws SQLException {
        Main.showEditCustomersCustomer();
    }


    public void commentButtonAction() throws IOException, SQLException {
        Main.showCommentPage();

    }

    public void adminProductsAction() throws SQLException {
        Main.showAdminProducts();
    }

    public void editAdminsAction() throws SQLException {
        Main.showEditAdmins();

    }


    public void editCustomersAction() throws SQLException {
        Main.showEditCustomers();

    }


}
