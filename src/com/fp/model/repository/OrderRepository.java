package com.fp.model.repository;

import com.fp.model.entity.OrderEntity;
import com.fp.model.entity.OrderItemEntity;
import com.fp.model.entity.PaymentEntity;

import java.sql.*;

public class OrderRepository implements AutoCloseable {
    private final Connection connection ;
    private PreparedStatement preparedStatement;

    public OrderRepository() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","admin","admin123");
        connection.setAutoCommit(false);
    }



    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }

    public void addPaymentRepo(PaymentEntity payment) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO nineKala.payment (customer_id, total_price, card_number, date, time) VALUES (?,?,?,?,?);");
        preparedStatement.setInt(1,payment.getCustomer_id());
        preparedStatement.setInt(2,payment.getTotal_price());
        preparedStatement.setString(3, payment.getCard_number());
        preparedStatement.setDate(4, payment.getDate());
        preparedStatement.setTime(5, payment.getTime());
        preparedStatement.executeUpdate();
        connection.commit();
    }

    public int getPaymentIdRepo(PaymentEntity payment) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT payment_id FROM nineKala.payment WHERE customer_id = ? AND date = ? AND time = ?;");
        preparedStatement.setInt(1, payment.getCustomer_id());
        preparedStatement.setDate(2, payment.getDate());
        preparedStatement.setTime(3, payment.getTime());
        ResultSet rs = preparedStatement.executeQuery();
        int result = 0;
        while (rs.next()){
           result = rs.getInt(1);
        }
        return result;
    }

    public void addOrderRepo(OrderEntity order) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO nineKala.order (customer_id, payment_id, order_date, order_time) VALUES (?,?,?,?);");
        preparedStatement.setInt(1, order.getCustomer_id());
        preparedStatement.setInt(2, order.getPayment_id());
        preparedStatement.setDate(3, order.getOrder_date());
        preparedStatement.setTime(4, order.getOrder_time());
        preparedStatement.executeUpdate();
        connection.commit();
    }

    public int getOrderIdRepo(OrderEntity order) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT order_id FROM nineKala.order WHERE customer_id = ? AND payment_id = ?;");
        preparedStatement.setInt(1, order.getCustomer_id());
        preparedStatement.setInt(2, order.getPayment_id());
        ResultSet rs = preparedStatement.executeQuery();
        int result = 0;
        while (rs.next()){
            result = rs.getInt(1);
        }
        return result;
    }

    public void addOrderItemRepo(OrderItemEntity orderItem) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO nineKala.order_items (order_id, product_id, quantity) VALUES (?,?,?);");
        preparedStatement.setInt(1, orderItem.getOrder_id());
        preparedStatement.setInt(2, orderItem.getProduct_id());
        preparedStatement.setInt(3, orderItem.getQuantity());
        preparedStatement.executeUpdate();
        connection.commit();
    }
}
