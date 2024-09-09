package ss4.bai_tap.stop_watch;
public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("about");
        for (int i = 0; i < 1000; i++) {
            System.out.print("*");
        }
        stopWatch.stop();
        System.out.println(stopWatch.displayStopWatch());
    }
}