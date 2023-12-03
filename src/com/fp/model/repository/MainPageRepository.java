package com.fp.model.repository;

import java.sql.*;

public class MainPageRepository implements AutoCloseable{
    private final Connection connection ;
    private PreparedStatement preparedStatement;
    public MainPageRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","admin","admin123");
        connection.setAutoCommit(false);
    }
    public String getRole() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT role FROM nineKala.user;");
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String role = null;
        if(resultSet.next()){
        role = resultSet.getString(1);
        }
        return role;
    }

    public String getUserName() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT user_name FROM nineKala.user;");
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String role = "";
        if(resultSet.next()){
            role = resultSet.getString(1);
        }
        return role;
    }
    @Override
    public void close() throws Exception {
        connection.close();
    }

    public void sendCommentRepo(int user_id, String string) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO nineKala.comment (customer_id, comment) VALUES (?,?);");
        preparedStatement.setInt(1,user_id);
        preparedStatement.setString(2,string);
        preparedStatement.executeUpdate();
        connection.commit();
    }
}
