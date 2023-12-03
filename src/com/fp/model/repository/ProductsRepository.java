package com.fp.model.repository;


import com.fp.model.entity.ProductEntity;
import java.sql.*;


public class ProductsRepository implements AutoCloseable {
    private final Connection connection ;
    private PreparedStatement preparedStatement;
    public ProductsRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","admin","admin123");
        connection.setAutoCommit(false);
    }


    public ResultSet getProductsIDRepo() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT product_id FROM nineKala.products ORDER BY product_id;");
        return preparedStatement.executeQuery();
    }


    public String getProductNameRepo(int productID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT name FROM nineKala.products WHERE product_id = ?;");
        preparedStatement.setInt(1, productID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;
    }


    public int getProductPriceRepo(int productID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT price FROM nineKala.products WHERE product_id = ?;");
        preparedStatement.setInt(1, productID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        int result = 0;
        while (resultSet.next()){
            result = resultSet.getInt(1);
        }
        return result;
    }


    public int getProductQuantityRepo(int productID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT quantity FROM nineKala.products WHERE product_id = ?;");
        preparedStatement.setInt(1, productID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        int result = 0;
        while (resultSet.next()){
            result = resultSet.getInt(1);
        }
        return result;
    }


    public String getProductCategoryRepo(int productID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT category FROM nineKala.products WHERE product_id = ?;");
        preparedStatement.setInt(1, productID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;
    }


    public void addProductRepo(ProductEntity p) throws SQLException {

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO nineKala.products(name, quantity, price ,category) values(?,?,?,?);");
            preparedStatement.setString(1, p.getName());
            preparedStatement.setInt(2,p.getQuantity());
            preparedStatement.setInt(3,p.getPrice());
            preparedStatement.setString(4,p.getCategory());
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
           throw e;
        }


    }


    public void deleteProductRepo(int productID) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM nineKala.products WHERE product_id = ?;");
        preparedStatement.setInt(1, productID);
        preparedStatement.executeUpdate();
        connection.commit();
    }


    public void editProductRepo(ProductEntity editP) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE nineKala.products SET name = ? , quantity = ? , price = ? , category = ? \n" +
                    "WHERE product_id = ?;");
            preparedStatement.setString(1, editP.getName());
            preparedStatement.setInt(2,editP.getQuantity());
            preparedStatement.setInt(3,editP.getPrice());
            preparedStatement.setString(4,editP.getCategory());
            preparedStatement.setInt(5, editP.getId());
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw e;
        }
    }


    public ResultSet getProductsNumberRepo(String category) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT product_id FROM nineKala.products WHERE category = ?  ORDER BY product_id;");
        preparedStatement.setString(1,category);
        return preparedStatement.executeQuery();
    }



    @Override
    public void close() throws Exception {
        connection.close();
    }
}

