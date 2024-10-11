package ss18.bai_tap.simple_thread;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator1 = new NumberGenerator();
        NumberGenerator generator2 = new NumberGenerator();
        Thread thread1 = new Thread(generator1, "Thread-1");
        Thread thread2 = new Thread(generator2, "Thread-2");
        thread1.setPriority(Thread.MIN_PRIORITY);  // Priority thấp nhất
        thread2.setPriority(Thread.MAX_PRIORITY);  // Priority cao nhất

        thread1.start();
        thread2.start();
    }
}
