package ss18.bai_tap.odd_and_even_number;

public class Main {
    public static void main(String[] args) {
        EvenNumber evenNumber = new EvenNumber();
        OddNumber oddNumber = new OddNumber();
        Thread evenThread = new Thread(evenNumber);
        Thread oddThread = new Thread(oddNumber);
       evenThread.start();
       oddThread.start();

    }
}
