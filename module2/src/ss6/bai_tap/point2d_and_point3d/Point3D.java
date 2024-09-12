package ss6.bai_tap.point2d_and_point3d;

public class Point3D extends Point2D {
    private float x;
    private float y;
    private float z=0.00f;
    public Point3D() {
        super();
    }
    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }
    public float getZ() {
        return this.z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }
    public float[] getXYZ() {
        float [] point3D = new float[3];
        point3D[0] = this.x;
        point3D[1] = this.y;
        point3D[2] = this.z;
        return point3D;
    }
    public String toString() {
        return "Point3D (x,y,z) = " + getX() + ", " +getY() + ", " + getZ();
    }
}
