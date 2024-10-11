package ss18.bai_tap.primer_number;

public class OptimizedPrimeFactorization implements Runnable {
    public boolean checkPrime(int number) {
        if (number < 2) {
            return false;
        } else if (number == 2) {
            return true;
        }
        for (int i = 2; i < Math.sqrt(number) + 0.1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        int number = 2;
        while (number < 100) {
            if (checkPrime(number)) {
                System.out.println("OptimizedPrimeFactorization found prime: " + number);
            }
            number++;
        }
    }
}
