package service;

import model.Cart;
import model.Coupon;
import model.User;

import java.util.Scanner;

import static model.Coupon.addCoupon;

public class CouponService {

    public static void couponMenu(User currentUser) {
        boolean editing = true;
        while (editing) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mCoupon Menu \u001B[33m*");
            System.out.println("***************************\u001B[0m");
            System.out.println("1. \u001B[32mApply coupon\u001B[0m");
            System.out.println("2. \u001B[33mBack to Payment Menu\u001B[0m");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("Enter coupon code:");
                    String couponCode = scanner.nextLine();
                    if (isValidCouponCode(couponCode)) {
                        System.out.println("Coupon code is valid.");
                        System.out.println("Coupon code applied successfully.");
                        System.out.println("new price "+CouponService.applyCoupon(currentUser,couponCode));
                        editing = false;
                    } else {
                        System.out.println("Coupon code is invalid. Please try again.");
                    }
                }
                case "2" -> {
                    System.out.println("\u001B[33mReturning to the payment menu.\u001B[0m");
                    editing = false;
                }
                default -> System.out.println("\u001B[31mInvalid choice. Please try again.\u001B[0m");
            }
        }
    }

//menu for adding coupon codes
    public static void addCoupons() {
        Scanner scanner = new Scanner(System.in);
        boolean editing = true;
        while (editing) {
            System.out.println("\u001B[33m***************************");
            System.out.println("* \u001B[36mCoupon Management Menu \u001B[33m*");
            System.out.println("***************************\u001B[0m");
            // take user input for coupon
            System.out.println("Enter coupon code:");
            String couponCode = scanner.nextLine();
            if (isValidCouponCode(couponCode)) {
                System.out.println("Coupon code is valid.");
                System.out.println("Enter coupon discount(%):");
                String couponDiscount = scanner.nextLine();
                if (isValidCouponDiscount(couponDiscount)) {
                    System.out.println("Coupon discount is valid.");
                    float couponDiscountFloat=Float.parseFloat(couponDiscount);
                    addCoupon(new Coupon(couponCode,couponDiscountFloat));
                    System.out.println("Coupon added successfully.");
                    editing = false;
                } else {
                    System.out.println("Coupon discount is invalid. Please try again.");
                }
            } else {
                System.out.println("Coupon code is invalid. Please try again.");
            }
        }
    }

    private static boolean isValidCouponDiscount(String couponDiscount) {
        return couponDiscount.matches("[0-9]{1,2}");
    }

    private static boolean isValidCouponCode(String couponCode) {
        return couponCode.matches("[A-Z]{4}[0-9]{4}");
    }
    public static String applyCoupon(User currentUser, String couponCode) {
        double total=0;
        for (model.Product a: currentUser.getUserCart().getCartArrayList())
        {

                total+=a.getPrice()*a.getQuantity();

        }
        for (model.Coupon a:model.Coupon.getCoupons())
        {
            if (a.getCode().equals(couponCode))
            {
                total=total-total*(a.getDiscount()/100);
                currentUser.getUserCart().setTotalAmount(total);
            }
        }
        return String.valueOf(total);
    }
}
