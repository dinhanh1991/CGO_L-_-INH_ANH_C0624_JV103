package ss4.bai_tap.stop_watch;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime stopTime;
    public  StopWatch() {
        this.startTime = LocalTime.now();
    }
    public LocalTime getStartTime() {
        return this.startTime;
    }
    public LocalTime getStopTime() {
        return this.stopTime;
    }
    public void  start(){
        this.startTime = LocalTime.now();

    }
    public void stop(){
        this.stopTime = LocalTime.now();

    }
    public double getElapsedTime(){
        return ((this.getStopTime().getHour()-this.getStartTime().getHour())*3600+(this.getStopTime().getMinute()-this.getStartTime().getMinute())*60+(this.getStopTime().getSecond()-this.getStartTime().getSecond()))*1000;
    }
    public String displayStopWatch(){
        return "\n Start time: "+this.getStartTime()+"\nStop Time: "+this.getStopTime()+"\n Elapsed Time: "+String.format("%.4f",getElapsedTime());
    }
}
