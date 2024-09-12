package ss6.bai_tap.point2d_and_point3d;

public class Point2D {
    private float x=0.00f;
    private float y=0.00f;
    public Point2D() {}
    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return this.x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return this.y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float [] point=new float[2];
        point[0]=this.x;
        point[1]=this.y;
        return point;
    }
    public String toString() {
        return "Point2D (x,y) = ("+this.x+","+this.y+")";
    }
}
