package testbook.testsite.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Coupon {

    private int c_price;
    private int c_percent;

    protected Coupon() {

    }

    public Coupon(int c_price, int c_percent) {
        this.c_percent = c_percent;
        this.c_price = c_price;
    }

}
