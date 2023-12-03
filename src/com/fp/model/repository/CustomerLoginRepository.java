package com.fp.model.repository;

import com.fp.model.entity.LoginEntity;

import java.sql.*;
import java.util.Objects;

public class CustomerLoginRepository implements AutoCloseable {
private final Connection connection ;
private PreparedStatement preparedStatement;
    public CustomerLoginRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","admin","admin123");
        connection.setAutoCommit(false);
    }

    public boolean passwordCheck(LoginEntity loginEntity) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT password FROM nineKala.customers where user_name = ?;");
        preparedStatement.setString(1, loginEntity.getUserName());
        ResultSet rs = preparedStatement.executeQuery();
        boolean result;
        String  p=null;
        while (rs.next()){
          p = rs.getString(1);
        }
        result = Objects.equals(p, loginEntity.getPassword());
        return result;
    }


    public boolean UsernameExistence(LoginEntity loginEntity) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT user_name FROM nineKala.customers where EXISTS \n" +
    "(SELECT user_name FROM nineKala.customers WHERE user_name = ?) and user_name = ?;");
        preparedStatement.setString(1, loginEntity.getUserName());
        preparedStatement.setString(2, loginEntity.getUserName());
        ResultSet rs = preparedStatement.executeQuery();
        boolean result;
        result = rs.next();
        return result;
    }


    public void setUser(LoginEntity loginEntity) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM nineKala.user;");
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement("SELECT account_id FROM nineKala.customers where user_name= ?;");
        preparedStatement.setString(1, loginEntity.getUserName());
        ResultSet rs = preparedStatement.executeQuery();
        int account_id = 0;
        while (rs.next()){
            account_id = rs.getInt(1);
        }


        preparedStatement = connection.prepareStatement("INSERT INTO nineKala.user(account_id,user_name,role) VALUES (?,?,'customer');");
        preparedStatement.setInt(1, account_id);
        preparedStatement.setString(2, loginEntity.getUserName());
        preparedStatement.executeUpdate();
        connection.commit();
    }


    public int getUserIdRepo() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT account_id FROM nineKala.user where role= 'customer' or role= 'admin';");
        ResultSet rs = preparedStatement.executeQuery();
        int account_id = 0;
        while (rs.next()){
            account_id = rs.getInt(1);
        }
        return account_id;
    }

        public void cleanUser() throws SQLException {
            preparedStatement = connection.prepareStatement("DELETE FROM nineKala.user;");
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("INSERT INTO nineKala.user(account_id,user_name,role) VALUES (0,'guest','guest');");
            preparedStatement.executeUpdate();
            connection.commit();
        }


    @Override
    public void close() throws Exception {
        connection.close();
    }


}
