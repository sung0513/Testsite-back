package test.testactive.domain;


import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Coupon {

        private Integer c_price;



        protected Coupon() {

        }

    public Coupon(int c_price, int c_percent) {
        this.c_price = c_price;

    }
}
