package com.fp.model.repository;

import com.fp.model.entity.AdminEntity;

import java.sql.*;

public class EditAdminRepository implements AutoCloseable{
    private final Connection connection ;
    private PreparedStatement preparedStatement;

    public EditAdminRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","admin","admin123");
        connection.setAutoCommit(false);
    }


    public ResultSet getAdminNumberRepo() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT admin_id FROM nineKala.admin;");
        return preparedStatement.executeQuery();
    }

    public String getAdminFirstNameRepo(int adminID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT first_name FROM nineKala.admin WHERE admin_id = ?;");
        preparedStatement.setInt(1, adminID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;
    }

    public String getAdminLastNameRepo(int adminID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT last_name FROM nineKala.admin WHERE admin_id = ?;");
        preparedStatement.setInt(1, adminID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public String getAdminPhoneRepo(int adminID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT phone FROM nineKala.admin WHERE admin_id = ?;");
        preparedStatement.setInt(1, adminID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public String getAdminBirthDayRepo(int adminID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT birth_date FROM nineKala.admin WHERE admin_id = ?;");
        preparedStatement.setInt(1, adminID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public String getAdminUserNameRepo(int adminID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT user_name FROM nineKala.admin WHERE admin_id = ?;");
        preparedStatement.setInt(1, adminID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public String getAdminPasswordRepo(int adminID) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT password FROM nineKala.admin WHERE admin_id = ?;");
        preparedStatement.setInt(1, adminID);
        ResultSet resultSet ;
        resultSet = preparedStatement.executeQuery();
        String result = "";
        while (resultSet.next()){
            result = resultSet.getString(1);
        }
        return result;

    }

    public void deleteAdminRepo(int adminID) throws SQLException {
        preparedStatement = connection.prepareStatement("DELETE FROM nineKala.admin WHERE admin_id = ?;");
        preparedStatement.setInt(1, adminID);
        preparedStatement.executeUpdate();
        connection.commit();
    }

    public void addAdminRepo(AdminEntity a) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO nineKala.admin (first_name, last_name, birth_date, phone, user_name, password) values(?,?,?,?,?,?);");
            preparedStatement.setString(1, a.getFirstName());
            preparedStatement.setString(2, a.getLastName());
            preparedStatement.setString(3, a.getBirthDate());
            preparedStatement.setString(4, a.getPhone());
            preparedStatement.setString(5, a.getUserName());
            preparedStatement.setString(6, a.getPassword());
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            throw e;
        }

    }

    public void editAdminRepo(AdminEntity editA) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE nineKala.admin SET first_name = ? , last_name = ? , birth_date = ? , phone = ? \n" +
                    " , password = ? WHERE admin_id = ?;");
            preparedStatement.setString(1, editA.getFirstName());
            preparedStatement.setString(2, editA.getLastName());
            preparedStatement.setString(3, editA.getBirthDate());
            preparedStatement.setString(4, editA.getPhone());
            preparedStatement.setString(5, editA.getPassword());
            preparedStatement.setInt(6, editA.getId());
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
