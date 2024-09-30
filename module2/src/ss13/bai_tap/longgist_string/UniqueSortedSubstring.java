package ss13.bai_tap.longgist_string;

import java.util.*;

public class UniqueSortedSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("Enter the string: ");
        input = sc.nextLine();
        String result =getString(input);
        System.out.println("SubString arrange from short to long "+result);
    }
    public static String getString(String st){
        String longestSubstring=st.substring(0,1);
        if (st.isEmpty()){
            return "";
        }else {
            for (int i=1;i<st.length();i++){
                if (st.charAt(i)>longestSubstring.charAt(longestSubstring.length()-1)){
                    longestSubstring+= st.charAt(i);
                }
            }
        }
        return longestSubstring ;
    }
}
