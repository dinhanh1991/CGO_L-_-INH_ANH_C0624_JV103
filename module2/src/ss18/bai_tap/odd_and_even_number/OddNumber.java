package ss18.bai_tap.odd_and_even_number;

public class OddNumber implements Runnable {
    public void run() {
        for(int i =0;i<11;i++){
            if(i%2!=0){
                System.out.println("Thread: " + Thread.currentThread().getName() +
                        " - Odd Number: " + i +
                        " - HashCode: " + this.hashCode());
            }
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
