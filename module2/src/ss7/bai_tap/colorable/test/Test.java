package ss7.bai_tap.colorable.test;

import ss7.bai_tap.colorable.square.Square;

public class Test {
    public static void main(String[] args) {
        Square[] square = new Square[3];
        square[0]=new Square();
        square[1]=new Square();
        square[2]=new Square();
        square[0].setColor("red");
        square[1].setColor("blue");
        square[2].setColor("green");
        for (int i = 0; i < square.length; i++) {
            square[i].setSide(Math.random()*20+1);
        }
        for (Square s : square) {
            System.out.println(s.toString());
            s.howToColor();
        }
    }
}
