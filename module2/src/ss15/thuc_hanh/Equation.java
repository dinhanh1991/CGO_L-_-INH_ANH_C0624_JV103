package ss15.thuc_hanh;

import java.util.Scanner;

public class Equation {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolve");
        System.out.println("Given a Equation as: ax+b=c please");
        Scanner sc = new Scanner(System.in);
        System.out.println("a");
        double a = sc.nextDouble();
        System.out.println("b");
        double b = sc.nextDouble();
        System.out.println("c");
        double c = sc.nextDouble();
        if (a == 0){
            if (b==c){
                System.out.println("infinitely many solutions");
            }else {
                System.out.println("Unslove");
            }
        }else {
            System.out.println("Root of Equation= "+(c-b)/a);
        }

    }
}
