package ss16.thuc_hanh.sum_interger.main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter link");
        Scanner sc = new Scanner(System.in);
        String link = "sc.nextLine()";
        readFile(link);
    } public static void readFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                try {
                    sum += Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping non-numeric line: " + line);
                }
            }
            br.close();
            System.out.println("Sum: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
