package ss6.bai_tap.point_and_movepoint;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        MoveablePoint moveablePoint = new MoveablePoint();
        point.setX(10);
        point.setY(20);
        System.out.println(point.toString());
        moveablePoint.setX(10);
        moveablePoint.setY(20);
        moveablePoint.setXSpeed(12);
        moveablePoint.setYSpeed(12);
        moveablePoint.move();
        System.out.println(moveablePoint.toString());
    }
}
