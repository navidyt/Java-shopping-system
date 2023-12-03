package com.fp.model.entity;

import java.sql.Date;
import java.sql.Time;

public class OrderEntity {
    private int order_id;
    private int customer_id;
    private int payment_id;
    private Date order_date;
    private Time order_time;

    public OrderEntity() {
    }

    public OrderEntity(int customer_id, int payment_id, Date order_date, Time order_time) {
        this.customer_id = customer_id;
        this.payment_id = payment_id;
        this.order_date = order_date;
        this.order_time = order_time;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }
}
