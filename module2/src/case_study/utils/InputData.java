package case_study.utils;

import java.util.Scanner;

public class InputData {
    Scanner scanner = new Scanner(System.in);
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
