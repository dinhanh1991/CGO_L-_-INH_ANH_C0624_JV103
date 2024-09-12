package ss6.bai_tap.circle_and_cylinder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Cylinder cylinder = new Cylinder();
        System.out.println("Enter the radius of the circle: ");
        double radius = new Scanner(System.in).nextDouble();
        circle.setRadius(radius);
        System.out.println("Enter the color of the circle: ");
        String color = new Scanner(System.in).nextLine();
        circle.setColor(color);
        circle.setRadius(radius);
        System.out.println("Enter the height of the cylinder: ");
        double height = new Scanner(System.in).nextDouble();
        cylinder.setHeight(height);
        System.out.println("Enter the radius of the cylinder: ");
        double radius2 = new Scanner(System.in).nextDouble();
        cylinder.setRadius(radius2);
        System.out.println("Enter the color of the cylinder: ");
        String color2 = new Scanner(System.in).nextLine();
        cylinder.setColor(color2);
        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
    }
}
