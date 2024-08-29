package ss1.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number of equations ax+b=c, a= ");
        a = sc.nextDouble();
        System.out.print("Enter the second number of equations ax+b=c, b= ");
        b = sc.nextDouble();
        System.out.print("Enter the third number of equations ax+b=c, c= ");
        c = sc.nextDouble();
        double d = c - b;
        if (a != 0) {
            double x = d / a;
            System.out.println("The equation pass width x = " + x);
        } else {
         if (d != 0) {
                System.out.println("No Solution");
            } else {
                System.out.println("The solution is all x!");
            }
        }
    }
}
