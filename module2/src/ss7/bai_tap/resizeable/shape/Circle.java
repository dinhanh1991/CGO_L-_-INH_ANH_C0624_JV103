package ss7.bai_tap.resizeable.shape;

import ss7.bai_tap.resizeable.inter_face.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius;
    public Circle() {}
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * this.radius *this.radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI *this.radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + String.format("%.3f",this.radius) +
                " Area=" + String.format("%.3f",getArea()) +
                " Perimeter=" + String.format("%.3f",getPerimeter()) +
                "} " + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(percent * this.radius/100+this.radius);
    }
}
