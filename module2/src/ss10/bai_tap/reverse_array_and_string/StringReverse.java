package ss10.bai_tap.reverse_array_and_string;

import java.util.Scanner;
import java.util.Stack;

public class StringReverse {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String stringFist;
        System.out.println("Enter the stringFist: ");
        stringFist = new Scanner(System.in).nextLine();
        int length = stringFist.length();
        for (int i = 0; i < length; i++) {
            stack.push(Character.toString(stringFist.charAt(i)));
        }
        String reversedString = "";
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
    }
        System.out.println("The reversestring is:"+"\""+reversedString+"\"");
}
}
