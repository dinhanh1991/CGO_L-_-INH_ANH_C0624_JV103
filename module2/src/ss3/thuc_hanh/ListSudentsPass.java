package ss3.thuc_hanh;

import java.util.Scanner;

public class ListSudentsPass {
    public static void main(String[] args) {
        int count,size;
        int [] listStudent;
        System.out.println("Enter the number of students you want to search: ");
        size=new Scanner(System.in).nextInt();
        while (size>30){
            System.out.println("Enter the number of students you want to search: ");
            size=new Scanner(System.in).nextInt();
        }
        listStudent=new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter a mark for student "+(i+1)+": ");
            listStudent[i]=new Scanner(System.in).nextInt();
        }
        System.out.printf("%-20s%s", "Students in list: ", "");
        for (int i = 0; i < listStudent.length; i++) {
            System.out.print(listStudent[i]+"\t ");
        }
        System.out.println();
        count=0;
        for (int i = 0; i < size; i++) {
            if (listStudent[i]>10||listStudent[i]<0){
                System.out.println("Enter student"+(i+1)+" result again result must be less than 10 or greater than 0 ");
                listStudent[i]=new Scanner(System.in).nextInt();
            }
        }
        for (int i = 0; i < listStudent.length; i++) {
            if (listStudent[i]>=5){
                count++;
            }
        }
        System.out.println("The number of students in list passing the exam : "+count +" students");
    }
}
