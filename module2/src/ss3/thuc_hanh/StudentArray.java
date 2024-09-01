package ss3.thuc_hanh;

import java.util.Scanner;

public class StudentArray {
    public static void main(String[] args) {
        String[] namesArray = {"Anh", "Tuấn Anh", "Bách", "Chi", "Hùng", "Khang", "Thành"};
        String nameInput;
        System.out.println("Enter the name of the student who you wanna look for");
        nameInput = new Scanner(System.in).nextLine();
        boolean isExist = false;
        for (int i = 0; i < namesArray.length; i++) {
            if (namesArray[i].equals(nameInput)) {
                System.out.println("Position of the students in the list " + nameInput + " is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("The student " + nameInput + " doesn't exist");
        }
    }
}
