package ss7.bai_tap.resizeable.shape;

import ss7.bai_tap.resizeable.inter_face.Resizeable;

public class Square extends Shape implements Resizeable {
    private double side;
    public Square() {}
    public Square(float side,String color,boolean filled) {
        super(color,filled);
        this.side = side;
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
                "} " + super.toString();
    }

    @Override
    public void resize(double percent) {
        setSide(percent*getSide()/100+getSide());
    }
}
