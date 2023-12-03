package com.fp.main;

import com.fp.comment.CommentPage;
import com.fp.order.cart_page.Cart;
import com.fp.edit_account_info.admin_account.EditAdmins;
import com.fp.edit_account_info.customers_account.by_admin.AdminEditCustomers;
import com.fp.edit_account_info.customers_account.by_customer.CustomerEditCustomer;
import com.fp.login_page.admin_login.LoginPageAdmin;
import com.fp.login_page.customer_login.LoginPageCustomer;
import com.fp.main_page.MainPage;
import com.fp.products.edit_products_info_admin.AdminProducts;
import com.fp.products.shop_page.ShowProducts;
import com.fp.signup_page.SignUp;
import javafx.application.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application{
    protected static Stage window;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        //we call our Main stage window.
        window = stage;
        window.setTitle("9Kala");
        window.getIcons().add(new Image("resource/logo1.png"));
        window.setResizable(false);
        try {
            showMainPage();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        window.show();
        }


    public static void showLoginPage() throws IOException {
        window.setScene(LoginPageCustomer.getInstance().getLoginPage());
    }
    public static void showMainPage() throws IOException, SQLException {
        window.setScene(MainPage.getInstance().getMainPage());
    }
    public static void showLoginPageAdmin() throws IOException {
        window.setScene(LoginPageAdmin.getInstance().getLoginPage());
    }
    public static void showAdminProducts() throws SQLException {
        window.setScene(AdminProducts.getInstance().getAdminProducts());
    }
    public static void showEditAdmins() throws SQLException {
        window.setScene(EditAdmins.getInstance().getEditAdmins());
    }
    public static void showEditCustomers() throws SQLException {
        window.setScene(AdminEditCustomers.getInstance().getEditCustomers());
    }
    public static void showEditCustomersCustomer() throws SQLException {
        window.setScene(CustomerEditCustomer.getInstance().getCustomerCustomer());
    }
    public static void showSignUpPage() throws SQLException {
        window.setScene(SignUp.getInstance().getSignUpPage());
    }
    public static void showShopPage() throws SQLException {
        window.setScene(ShowProducts.getInstance().getShowProducts());
    }
    public static void showCartPage(String status) throws SQLException {
        window.setScene(Cart.getInstance().getCartPage(status));
    }
    public static void showCommentPage() throws SQLException {
        window.setScene(CommentPage.getInstance().getCommentPage());
    }
}
