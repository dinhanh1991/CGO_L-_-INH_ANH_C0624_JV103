package ss6.bai_tap.circle_and_cylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle() {}
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
    public double getPerimeter() {
        return this.radius * 2 * Math.PI;
    }
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + "]"+"Area :"+getArea()+"Perimeter:"+getPerimeter();
    }
}
