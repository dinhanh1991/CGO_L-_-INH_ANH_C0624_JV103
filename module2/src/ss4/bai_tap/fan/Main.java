package ss4.bai_tap.fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setColor("yellow");
        fan1.setStatus(true);
        fan1.setRadius(10);
        fan1.setSpeed(fan1.high);
        fan2.setColor("blue");
        fan2.setStatus(false);
        fan2.setRadius(5);
        fan2.setSpeed(fan2.medium);
        System.out.println(" Fan 1:");
        System.out.println(fan1.display());
        System.out.println(" Fan 2:");
        System.out.println(fan2.display());
    }
}
