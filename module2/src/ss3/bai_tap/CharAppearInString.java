package ss3.bai_tap;

import java.util.Scanner;

public class CharAppearInString {
    public static void main(String[] args) {
        char symbol;
        String myString;
        System.out.println("Enter a string: ");
        myString=new Scanner(System.in).nextLine();
        System.out.println("Enter a character: ");
        symbol=new Scanner(System.in).next().charAt(0);
        int count=0;
        for (int i=0;i<myString.length();i++){
            if (myString.charAt(i)==symbol){
                count++;
            }
        }
        System.out.println("Character ' "+symbol+"' appears "+count+" times in string '"+myString+"'");
    }
}
