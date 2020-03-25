package com.example.demo.domain;


public enum Coupon{
    천원(1000),
    이천원(2000),
    삼천원(3000);

    private int coupon;
    Coupon(int coupon){
        this.coupon = coupon;
    }
}
