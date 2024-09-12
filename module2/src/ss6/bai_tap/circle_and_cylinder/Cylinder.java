package ss6.bai_tap.circle_and_cylinder;

public class Cylinder extends Circle {
    private double radius;
    private double height;
    private String color;
    public Cylinder() {
        super();
    }
    public Cylinder(double radius, double height, String color) {
        super();
        this.height = height;
    }
    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getSurroundingArea() {
        return this.getPerimeter() * this.height;
    }
    public double getTotalArea() {
        return this.getSurroundingArea()+2*this.getArea();
    }
    public double getVolume() {
        return this.getArea()*this.height;
    }
    public String toString() {
        return super.toString()+"\n Surround Area :"+this.getSurroundingArea()+"\n Total Area :"+this.getTotalArea()+"\n Volume :"+this.getVolume();
    }
}
