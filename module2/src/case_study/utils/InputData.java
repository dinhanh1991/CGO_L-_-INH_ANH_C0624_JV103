package case_study.utils;

import java.util.Scanner;

public class InputData {
    Scanner scanner = new Scanner(System.in);
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    public static void confirm(String confirm,Runnable action,Runnable cancel) {
        if(confirm.toLowerCase().equals("yes")) {
            action.run();
        }else if(confirm.toLowerCase().equals("no")) {
            cancel.run();
        }
    }
}
