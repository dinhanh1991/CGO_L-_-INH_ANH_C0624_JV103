package ss4.thuc_hanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double width,height;
        System.out.println("Enter width of Rectangle :");
        width= new Scanner(System.in).nextDouble();
        System.out.println("Enter height of Rectangle :");
        height= new Scanner(System.in).nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
    }
}

