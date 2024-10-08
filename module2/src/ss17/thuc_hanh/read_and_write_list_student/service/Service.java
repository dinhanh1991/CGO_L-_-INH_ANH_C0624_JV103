package ss17.thuc_hanh.read_and_write_list_student.service;

import ss17.thuc_hanh.read_and_write_list_student.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Service {
    public static  void writeDataToFile(String Path,List<Student> students){
        try {
            FileOutputStream fos = new FileOutputStream(Path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("A1", "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student("A2", "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student("A3", "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student("A4", "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student("A5", "Nguyễn Khắc Nhật", "Hà Nội"));
        writeDataToFile("module2/src/ss17/thuc_hanh/read_and_write_list_student/file/list_student", students);
        List<Student> studentDataFromFile = readDataFromFile("module2/src/ss17/thuc_hanh/read_and_write_list_student/file/list_student");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
