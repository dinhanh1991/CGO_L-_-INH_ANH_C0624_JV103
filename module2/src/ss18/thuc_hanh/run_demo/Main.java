package ss18.thuc_hanh.run_demo;

public class Main {
    public static void main(String[] args) {
        RunAbleDemo runAbleDemo1=new RunAbleDemo("Thread-1-HR-Database");
        runAbleDemo1.start();
        RunAbleDemo runAbleDemo2=new RunAbleDemo("Thread-2-HR-Database");
        runAbleDemo2.start();
        System.out.println("Main thread stopped!!! ");
    }
}
