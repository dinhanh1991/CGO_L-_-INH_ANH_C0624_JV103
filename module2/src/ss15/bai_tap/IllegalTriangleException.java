package ss15.bai_tap;

import java.util.Scanner;

public class IllegalTriangleException {
    public static void main(String[] args) {
        double a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Point: ");
        a = sc.nextDouble();
        System.out.print("Enter Second Point: ");
        b = sc.nextDouble();
        System.out.print("Enter Third Point: ");
        c = sc.nextDouble();
        try {
            if (a<=0||b<=0||c<=0) {
                System.out.println("Invalid Triangle");
            }else if (a+b<=c||a+c<=b||b+c<=a) {
                    System.out.println("Invalid Triangle");
            }else {
                System.out.println("Invalid Triangle");
            }
        }catch (Exception e) {
            System.out.println("Invalid Triangle");
        }
    }
}
