package ss6.bai_tap.point2d_and_point3d;

public class Main {
    public static void main(String[] args) {
        Point2D p2d = new Point2D();
        Point3D p3d = new Point3D();
        p2d.setX(2);
        p2d.setY(3);
        System.out.println(p2d.toString());
        p3d.setX(4);
        p3d.setY(5);
        p3d.setZ(6);
        System.out.println(p3d.toString());
    }
}
