package ss18.bai_tap.primer_number;

public class LazyPrimeFactorization implements Runnable {
   public boolean checkPrime(int number){
       if (number < 2){
           return false;
       } else if (number == 2) {
           return true;
       }
       for (int i = 2; i <number; i++) {
           if (number % i == 0) {
               return false;
           }
       }
       return true;
   }
   public void run(){
       int number=2;
       while (number < 100){
           if (checkPrime(number)){
               System.out.println("LazyPrimeFactorization found prime: " + number);
           }
           number++;
       }
   }
}
