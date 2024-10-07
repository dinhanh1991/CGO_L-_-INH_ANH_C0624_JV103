package ss16.bai_tap.copy_file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source file path: ");
        String sourceFilePath = scanner.nextLine();
        System.out.print("Enter target file path: ");
        String targetFilePath = scanner.nextLine();
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        if (!sourceFile.exists()) {
            System.out.println("The source is not exist: " + sourceFilePath);
            return;
        }
        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(targetFile)) {
            int characterCount = 0;
            int charData;
            while ((charData = reader.read()) != -1) {
                writer.write(charData);
                characterCount++;
            }
            System.out.println("Copy Success. number of character copied: " + characterCount);
        } catch (IOException e) {
            System.out.println("An error occurred while copying : " + e.getMessage());
        }
    }
}
