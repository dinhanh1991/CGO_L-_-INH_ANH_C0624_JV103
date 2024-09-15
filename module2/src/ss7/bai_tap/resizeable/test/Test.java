package ss7.bai_tap.resizeable.test;

import ss7.bai_tap.resizeable.shape.Circle;
import ss7.bai_tap.resizeable.shape.Rectangle;
import ss7.bai_tap.resizeable.shape.Square;

public class Test {
    public static void main(String[] args) {
        System.out.println( " * Class Circle");
        Circle[] circle=new Circle[3];
        circle[0]=new Circle();
        circle[1]=new Circle();
        circle[2]=new Circle();
        for (Circle c : circle) {
            c.setRadius(Math.random()*5);
        }
        for (Circle c : circle) {
            System.out.println(c.toString());
        }
        System.out.println("after changer size");
        for (Circle c : circle) {
            c.resize(Math.random()*100);
        }
        for (Circle c : circle) {
            System.out.println(c.toString());
        }
        System.out.println("******************************************");
        System.out.println("Class Rectangle");
        Rectangle[] rectangle=new Rectangle[2];
        rectangle[0]=new Rectangle();
        rectangle[1]=new Rectangle();
        for (Rectangle r : rectangle) {
            r.setHeight(Math.random()*10+1);
            r.setWidth(Math.random()*10+1);
        }
        for (Rectangle r : rectangle) {
            System.out.println(r.toString());
        }
        System.out.println("After changer size");
        for (Rectangle r : rectangle) {
            r.resize(Math.random()*100);
        }
        for (Rectangle r : rectangle) {
            System.out.println(r.toString());
        }
        System.out.println("******************************************");
        System.out.println("Class Square");
        Square[] square=new Square[2];
        square[0]=new Square();
        square[1]=new Square();
        for (Square sq : square) {
            sq.setSide(Math.random()*10);
        }
        for (Square sq : square) {
            System.out.println(sq.toString());
        }
        System.out.println("After changer size");
        for (Square sq : square) {
            sq.resize(Math.random()*100);
        }
        for (Square sq : square) {
            System.out.println(sq.toString());
        }
    }
}
