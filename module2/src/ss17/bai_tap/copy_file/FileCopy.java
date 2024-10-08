package ss17.bai_tap.copy_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the source file path: ");
        String sourceFilePath = scanner.nextLine();
        System.out.print("Enter the target file path: ");
        String targetFilePath = scanner.nextLine();
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        if (!sourceFile.exists()) {
            System.out.println("Error: source file does not exist.");
            return;
        }
        if (targetFile.exists()) {
            System.out.println("Warning: target file already exists.\n " +
                    "Do you want to copy :?\n" +
                    "Yes: Continues\n" +
                    "No: Cancel");
            String answer = scanner.nextLine();
            if (answer.equals("No")) {
                System.out.println("You cancelled the copy.");
                return;
            }
        }
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(targetFile)) {
            ArrayList<Byte> byteList = new ArrayList<>();
            int byteData;
            while ((byteData = inputStream.read()) != -1) {
                byteList.add((byte) byteData);
            }
            for (byte b : byteList) {
                outputStream.write(b);
            }
            System.out.println("Copy completed. Total bytes copied: " + byteList.size());
        } catch (IOException e) {
            System.out.println("Error occurred while copying file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
