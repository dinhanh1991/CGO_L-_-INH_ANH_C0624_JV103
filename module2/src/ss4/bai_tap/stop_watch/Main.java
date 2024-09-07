package ss4.bai_tap.stop_watch;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.getStartTime();
        stopWatch.getStopTime();
        System.out.println(stopWatch.start());
        System.out.println(stopWatch.stop());
        System.out.println(stopWatch.getElapsedTime());
    }
}
