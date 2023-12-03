package com.fp.model.entity;

import java.sql.Date;
import java.sql.Time;

public class PaymentEntity {
    private int payment_id;
    private int customer_id;
    private int total_price;
    private String card_number;
    private Date date;
    private Time time;

    public PaymentEntity() {
    }

    public PaymentEntity( int customer_id, int total_price, String card_number, Date date, Time time) {
        this.customer_id = customer_id;
        this.total_price = total_price;
        this.card_number = card_number;
        this.date = date;
        this.time = time;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
