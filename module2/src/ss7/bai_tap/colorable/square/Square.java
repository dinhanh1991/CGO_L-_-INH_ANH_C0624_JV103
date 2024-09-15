package ss7.bai_tap.colorable.square;

import ss7.bai_tap.colorable.inter_face.Color;
import ss7.bai_tap.resizeable.inter_face.Resizeable;
import ss7.bai_tap.resizeable.shape.Shape;

public class Square  implements Color {
    private double side;
    private String color;
    public Square() {}
    public Square(double side,String color) {
        this.side = side;
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double getArea() {
        return this.side*this.side;
    }
    public double getPerimeter() {
        return this.side*4 ;
    }
    @Override
    public String toString() {
        return "Square{" +
                "side=" + String.format("%.3f",this.side) +
                "Area="+String.format("%.3f",getArea()) +
                "Perimeter="+String.format("%.3f",getPerimeter()) +
                "} " +" Color=" + this.color;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
