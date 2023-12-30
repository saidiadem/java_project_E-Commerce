package model;

import java.util.ArrayList;

public class Coupon {
    private String code;
    private float discount;
    private static ArrayList<Coupon> coupons = new ArrayList<>();

    public Coupon(String code, float discount) {
        this.code = code;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public static ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    public static void setCoupons(ArrayList<Coupon> coupons) {
        Coupon.coupons = coupons;
    }
    //add a coupon to the arraylist
    public static void addCoupon(Coupon coupon) {
        coupons.add(coupon);
    }
}
