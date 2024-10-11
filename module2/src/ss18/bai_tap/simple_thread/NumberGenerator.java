package ss18.bai_tap.simple_thread;

public class NumberGenerator implements Runnable {
    @Override
    public void run() {
        int i=0;
        while(i<11){
            System.out.println("Thread: " + Thread.currentThread().getName() +
                    " - Number: " + i +
                    " - HashCode: " + this.hashCode());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
