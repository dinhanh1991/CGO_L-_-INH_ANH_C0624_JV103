package ss4.bai_tap.fan;

public class Fan {
    final short low =1;
    final short medium =2;
    final short high =3;
    private int speed =this.low;
    private boolean status = false;
    private double radius=5.0;
    private String color="blue";
    public Fan() {}
    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public boolean getStatus() {
        return this.status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void displayDefault() {
        System.out.println("Fan status : "+this.status+"\n" +
                "Speed: "+this.status+"\n Radius: "+this.radius+"\n Color: "+this.color);
    }
    public String display(){
        if(this.status){
            return "Speed: "+this.speed+"\n Radius: "+this.radius+"\n Color: "+this.color+"\n"+"Fan is on" ;
        }else
        return "Fan is off"+"Radius: "+this.radius+"\n Color: "+this.color;
    }
}
