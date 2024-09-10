package ss5.bai_tap.access_modifier;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        System.out.println("Enter the radius of the circle");
        double radius = new Scanner(System.in).nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("The circle's radius is " + circle.getRadius()+"The circle's Area is " + circle.getArea());
    }
}
