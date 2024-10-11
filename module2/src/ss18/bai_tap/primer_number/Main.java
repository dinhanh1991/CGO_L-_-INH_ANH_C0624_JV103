package ss18.bai_tap.primer_number;

public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization primeFactorization = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();
        Thread t1 = new Thread(primeFactorization);
        Thread t2 = new Thread(optimizedPrimeFactorization);
        t1.start();
        t2.start();
    }
}
