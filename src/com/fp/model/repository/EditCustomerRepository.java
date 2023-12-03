package com.fp.model.repository;


import com.fp.model.entity.CustomerEntity;

import java.sql.*;


public class EditCustomerRepository implements AutoCloseable{
    private final Connection connection ;
    private PreparedStatement preparedStatement;

    public EditCustomerRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","admin","admin123");
        connection.setAutoCommit(false);
    }


    public ResultSet getCustomerNumberRepo() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT account_id FROM nineKala.customers;");
        return preparedStatement.executeQuery();
    }

    public String getCustomerFirstNameRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT first_name FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;
    }

    public String getCustomerLastNameRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT last_name FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public String getCustomerPhoneRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT phone FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;
    }

    public String getCustomerBirthDayRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT birth_date FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public String getCustomerUserNameRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT user_name FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public String getCustomerPasswordRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT password FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }
    public String getCustomerAddressRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT address FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public void deleteCustomerRepo(int customerID) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM nineKala.customers WHERE account_id = ?;");
        preparedStatement.setInt(1, customerID);
        preparedStatement.executeUpdate();
        connection.commit();
    }

    public void addCustomerRepo(CustomerEntity c) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO nineKala.customers (first_name, last_name, birth_date, phone, user_name, password, address) values(?,?,?,?,?,?,?);");
            preparedStatement.setString(1, c.getFirstName());
            preparedStatement.setString(2, c.getLastName());
            preparedStatement.setString(3, c.getBirthDate());
            preparedStatement.setString(4, c.getPhone());
            preparedStatement.setString(5, c.getUserName());
            preparedStatement.setString(6, c.getPassword());
            preparedStatement.setString(7, c.getAddress());
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw e;
        }

    }

    public void editAdminRepo(CustomerEntity editC) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE nineKala.customers SET first_name = ? , last_name = ? , birth_date = ? , phone = ? \n" +
                    " , password = ? , address = ? WHERE account_id = ?;");
            preparedStatement.setString(1, editC.getFirstName());
            preparedStatement.setString(2, editC.getLastName());
            preparedStatement.setString(3, editC.getBirthDate());
            preparedStatement.setString(4, editC.getPhone());
            preparedStatement.setString(5, editC.getPassword());
            preparedStatement.setString(6, editC.getAddress());
            preparedStatement.setInt(7, editC.getId());

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }


    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
