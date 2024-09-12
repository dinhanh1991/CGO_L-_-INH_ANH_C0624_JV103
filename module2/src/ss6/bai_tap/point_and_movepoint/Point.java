package ss6.bai_tap.point_and_movepoint;

public class Point {
        private float x=0.00f;
        private float y=0.00f;
        public Point() {}
        public Point(float x, float y) {
            this.x=x;
            this.y=y;
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
            return "Point (x,y) = ("+this.x+","+this.y+")";
        }

}
