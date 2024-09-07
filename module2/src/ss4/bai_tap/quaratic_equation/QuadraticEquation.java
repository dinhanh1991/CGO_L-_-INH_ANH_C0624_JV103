package ss4.bai_tap.quaratic_equation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;

    }
    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant() {
        return this.b*this.b-4*this.a*this.c;
    }
    public double getRoot1() {
        return (-this.b+Math.sqrt(getDiscriminant()))/2;
    }
    public double getRoot2() {
        return (-this.b-Math.sqrt(getDiscriminant()))/2;
    }
    public String display() {
        if (this.getDiscriminant()>=0){
            return "Equation: "+this.a+"x2 + "+this.b+"x+ "+this.c+"= 0, this Equation have two roots:\n " +
                    "x1= "+this.getRoot1()+",\n x2= "+this.getRoot2() ;
        }
        return "Unsolved equation";
    }
}

