package com.sakebakery.opus.obj;

import java.io.Serializable;

public class Cartobj implements Serializable {

    private int active= 1;

    private String cart_id="" ;

    private String cart_user_id= "" ;

    private String cart_cake_name="" ;

    private String cart_cake_price="" ;

    private String cart_thumbnail="" ;

    private String cart_quantity="" ;

    private String cart_sub_total="" ;

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getCart_user_id() {
        return cart_user_id;
    }

    public void setCart_user_id(String cart_user_id) {
        this.cart_user_id = cart_user_id;
    }

    public String getCart_cake_name() {
        return cart_cake_name;
    }

    public void setCart_cake_name(String cart_cake_name) {
        this.cart_cake_name = cart_cake_name;
    }

    public String getCart_cake_price() {
        return cart_cake_price;
    }

    public void setCart_cake_price(String cart_cake_price) {
        this.cart_cake_price = cart_cake_price;
    }

    public String getCart_thumbnail() {
        return cart_thumbnail;
    }

    public void setCart_thumbnail(String cart_thumbnail) {
        this.cart_thumbnail = cart_thumbnail;
    }

    public String getCart_quantity() {
        return cart_quantity;
    }

    public void setCart_quantity(String cart_quantity) {
        this.cart_quantity = cart_quantity;
    }

    public String getCart_sub_total() {
        return cart_sub_total;
    }

    public void setCart_sub_total(String cart_sub_total) {
        this.cart_sub_total = cart_sub_total;
    }

    @Override
    public String toString() {
        return "Cartobj{" +
                "active=" + active +
                ", cart_id='" + cart_id + '\'' +
                ", cart_user_id='" + cart_user_id + '\'' +
                ", cart_cake_name='" + cart_cake_name + '\'' +
                ", cart_cake_price='" + cart_cake_price + '\'' +
                ", cart_thumbnail='" + cart_thumbnail + '\'' +
                ", cart_quantity='" + cart_quantity + '\'' +
                ", cart_sub_total='" + cart_sub_total + '\'' +
                '}';
    }
}
