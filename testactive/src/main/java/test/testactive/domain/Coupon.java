package test.testactive.domain;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Coupon {

        private int c_price;
        private int c_percent;


        protected Coupon() {

        }

    public Coupon(int c_price, int c_percent) {
        this.c_price = c_price;
        this.c_percent= c_percent;
    }
}
