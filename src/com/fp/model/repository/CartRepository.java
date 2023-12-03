package com.fp.model.repository;

import com.fp.model.entity.CartEntity;

import java.sql.*;

public class CartRepository implements AutoCloseable{
    private final Connection connection ;
    private PreparedStatement preparedStatement;
    public CartRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","admin","admin123");
        connection.setAutoCommit(false);
    }
    public ResultSet getProductsIDRepo(int userId) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT product_id, quantity FROM nineKala.cart WHERE customer_id = ? ORDER BY product_id ;");
        preparedStatement.setInt(1, userId);
        return preparedStatement.executeQuery();
    }
    public void addToCartRepo(CartEntity e) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO nineKala.cart(customer_id, product_id, quantity, code, unit_price) values(?,?,?,?,?);");
        preparedStatement.setInt(1,e.getCustomerId());
        preparedStatement.setInt(2,e.getProductId());
        preparedStatement.setInt(3,e.getQuantity());
        preparedStatement.setString(4,e.getCode());
        preparedStatement.setInt(5,e.getPrice());
        preparedStatement.executeUpdate();
        connection.commit();
    }
    public int getTotalPriceRepo(int userId) throws SQLException{
        preparedStatement = connection.prepareStatement("SELECT sum(quantity*unit_price) FROM nineKala.cart WHERE customer_id = ? ORDER BY product_id ;");
        preparedStatement.setInt(1,userId);
        ResultSet rs = preparedStatement.executeQuery();
        int result = 0;
        while (rs.next()){
            result = rs.getInt(1);
        }
        return result;
    }



    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }

    public void deleteFromCartRepo(int user_id, int product_id) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM nineKala.cart WHERE customer_id = ? AND product_id = ?;");
        preparedStatement.setInt(1,user_id);
        preparedStatement.setInt(2,product_id);
        preparedStatement.executeUpdate();
        connection.commit();
    }

    public void emptyCartRepo(int user_id) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM nineKala.cart WHERE customer_id = ? ");
        preparedStatement.setInt(1,user_id);
        preparedStatement.executeUpdate();
        connection.commit();
    }
}
