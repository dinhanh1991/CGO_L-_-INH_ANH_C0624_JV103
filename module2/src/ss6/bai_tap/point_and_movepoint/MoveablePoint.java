package ss6.bai_tap.point_and_movepoint;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;
    public MoveablePoint() {
        super();
    }
    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float getXSpeed() {
        return this.xSpeed;
    }
    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }
    public float getYSpeed() {
        return this.ySpeed;
    }
    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float getSpeed() {
        float [] speedArr = new float[2];
        speedArr[0] = xSpeed;
        speedArr[1] = ySpeed;
        return speedArr[0];
    }
    public String toString() {
        return super.toString()+"(xSpeed,ySpeed) = (" + xSpeed + ", " + ySpeed+")";
    }
    public MoveablePoint move(){
        float x=getX()+this.xSpeed;
        float y=getY()+this.ySpeed;
        setX(x);
        setY(y);
        return  this;
    }
}
