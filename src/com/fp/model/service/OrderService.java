package com.fp.model.service;

import com.fp.model.entity.OrderEntity;
import com.fp.model.entity.OrderItemEntity;
import com.fp.model.entity.PaymentEntity;
import com.fp.model.entity.ProductEntity;
import com.fp.model.repository.OrderRepository;
import com.fp.order.result_page.ResultPageView;

import java.sql.SQLException;
import java.util.LinkedHashSet;

public class OrderService {
    //singleton class
    private static final OrderService orderService = new OrderService();
    public static OrderService getInstance(){return orderService;}
    private OrderService(){}


    public void PlaceOrder(int user_id, LinkedHashSet<ProductEntity> set, PaymentEntity payment) throws SQLException {
        OrderRepository repository = new OrderRepository();
        repository.addPaymentRepo(payment);
        int payment_id = repository.getPaymentIdRepo(payment);
        OrderEntity order = new OrderEntity(user_id, payment_id, payment.getDate(), payment.getTime());
        repository.addOrderRepo(order);
        int order_id = repository.getOrderIdRepo(order);
        order.setOrder_id(order_id);
        for (ProductEntity p : set){
            OrderItemEntity orderItem = new OrderItemEntity(order_id, p.getId(), p.getQuantityInCart());
            repository.addOrderItemRepo(orderItem);
            int newQuantity = p.getQuantity() - p.getQuantityInCart();
            p.setQuantity(newQuantity);
            ProductsService.getInstance().editProduct(p);
        }
        CartService.getInstance().emptyCart(user_id);
        ResultPageView resultPageView = new ResultPageView();
        resultPageView.ResultPage(set, order, payment.getTotal_price());
    }
}
