package ss4.bai_tap.stop_watch;

public class StopWatch {
    private int startTime;
    private int stopTime;
    public  StopWatch() {
        this.startTime = java.time.LocalTime.now().getNano();
        this.stopTime = java.time.LocalTime.now().getNano();
    }
    public int getStartTime() {
        return this.startTime;
    }
    public int getStopTime() {
        return this.stopTime;
    }
    public int start(){
        this.startTime = java.time.LocalTime.now().getNano();
        return this.startTime;
    }
    public int stop(){
        this.stopTime = java.time.LocalTime.now().getNano();
        return this.stopTime;
    }
    public int getElapsedTime(){
        return java.time.LocalTime.now().getNano() - this.stopTime;
    }
}
