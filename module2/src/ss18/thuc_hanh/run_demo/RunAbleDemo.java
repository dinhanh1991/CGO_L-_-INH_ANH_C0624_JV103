package ss18.thuc_hanh.run_demo;

public class RunAbleDemo implements Runnable {
    private Thread thread;
    private final String threadName;
    public RunAbleDemo(String name) {
        threadName=name;
        System.out.println("Creating " + threadName);
    }
    public void run(){
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i >0 ; i--) {
                System.out.println("Thread: " + threadName + ","+i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
