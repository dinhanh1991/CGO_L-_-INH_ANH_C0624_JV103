package ss18.thuc_hanh.count;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        try {
            while (count.getThread().isAlive()) {
                System.out.println("Main thread will be alive till the child thread is live");
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("Main thread run is over");
    }
}
