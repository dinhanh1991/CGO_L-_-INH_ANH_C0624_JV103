package ss19.bai_tap.phone_number;

public class Test {
    public static PhoneNumber phoneNumber;
    public static final String[] phoneNumbers =new String[]{
            "(84)-(0978489648)",
            "(a8)-(22222222)",
            "(84)-(22b22222)",
            "(84)-(9978489648)"};

    public static void main(String[] args) {
        phoneNumber = new PhoneNumber();
        for (String number :phoneNumbers) {
            boolean isValid=phoneNumber.isValid(number);
            System.out.println("Phone number is: " + number+"isValid: " + isValid);
        }
    }
}
