package test.testactive.domain;


public enum Coupon {

    천원("1000"),
    이천원("2000"),
    삼천원("3000");

    private String coupon;

    Coupon(String coupon){
        this.coupon = coupon;
    }

    public String getCoupon() {
        return coupon;
    }

}
