package ss4.bai_tap.quaratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, c;
        System.out.println("Enter a: ");
        a=new Scanner(System.in).nextDouble();
        System.out.println("Enter b: ");
        b=new Scanner(System.in).nextDouble();
        System.out.println("Enter c: ");
        c=new Scanner(System.in).nextDouble();
        QuadraticEquation equation=new QuadraticEquation();
        equation.setA(a);
        equation.setB(b);
        equation.setC(c);
        System.out.println(equation.display());
    }
}
