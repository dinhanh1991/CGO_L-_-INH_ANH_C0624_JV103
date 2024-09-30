package ss13.bai_tap.find_longest_string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestString {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        input = sc.nextLine();
        String result = findLongestString(input);
        System.out.println("The sublongest is :"+result);
    }

    public static String findLongestString(String input) {
      if (input == null || input.length() == 0) {
          return "";
      }
      String longestString = input.substring(0,1);
      String currentString = input.substring(0,1);
      for (int i = 1; i < input.length(); i++) {
          if (input.charAt(i) >= input.charAt(i-1)) {
              currentString+=input.charAt(i);
          }else {
              if (currentString.length() > longestString.length()) {
                  longestString = currentString;
              }
              currentString=input.substring(i,i+1);
          }
      }
      if (currentString.length() > longestString.length()) {
          longestString = currentString;
      }
      return longestString;
    }
}
/*Độ phức tạp của thuật toán là O(n) n là chều dài của chuôi */