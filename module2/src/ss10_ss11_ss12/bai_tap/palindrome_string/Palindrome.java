package ss10_ss11_ss12.bai_tap.palindrome_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String originalString;
        Stack<String> stackString = new Stack<>();
        Queue<String> queueString = new LinkedList<>();
        System.out.println("Enter original string");
        Scanner scanner = new Scanner(System.in);
        originalString = scanner.nextLine();
        for (int i = 0; i < originalString.length(); i++) {
            stackString.push(Character.toString(originalString.charAt(i)));
            queueString.offer(Character.toString(originalString.charAt(i)));
        }
        System.out.println(stackString.pop());
        System.out.println(queueString.poll());
        boolean isPalindrome = true;
        while (!stackString.isEmpty()) {
            if (!stackString.pop().equals(queueString.poll())){
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome){
            System.out.println("The String "+"\""+originalString+"\" is Palindrome");
        }else {
            System.out.println("The String "+"\""+originalString+"\" is not Palindrome");
        }
    }
}
