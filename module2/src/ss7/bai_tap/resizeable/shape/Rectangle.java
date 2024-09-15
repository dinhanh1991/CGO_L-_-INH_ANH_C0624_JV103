package ss7.bai_tap.resizeable.shape;

import ss7.bai_tap.resizeable.inter_face.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double height;
    public Rectangle() {}
    public Rectangle(String color,boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea() {
        return this.width * this.height;
    }
    public double getPerimeter() {
        return 2*(this.width + this.height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" +String.format("%.3f",this.width) +
                ", height=" + String.format("%.3f",this.height) +
                ", area=" + String.format("%.3f",getArea()) +
                ", perimeter=" +String.format("%.3f",getPerimeter()) +
                "} " + super.toString();
    }

    @Override
    public void resize(double percent) {
       setWidth(getWidth()*percent/100+getWidth());
       setHeight(getHeight()*percent/100+getHeight());
    }
}
