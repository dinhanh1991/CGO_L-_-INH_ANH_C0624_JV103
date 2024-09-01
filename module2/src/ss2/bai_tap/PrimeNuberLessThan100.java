package ss2.bai_tap;
public class PrimeNuberLessThan100 {
    public static void main(String[] args) {
        short fistNumber = 2;
        String string = "các  số nguyên tố nhỏ hơn 100 là: " + fistNumber + "; ";
        while (fistNumber < 100) {
            fistNumber++;
            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(fistNumber) + 0.1; i++) {
                if (fistNumber % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                string = string + fistNumber + "; ";
            }
        }
        System.out.println(string);
    }
}
