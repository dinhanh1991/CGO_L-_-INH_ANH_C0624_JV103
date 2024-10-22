package case_study.utils;

import case_study.model.Classroom;
import case_study.model.Student;
import case_study.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CvsInputAndOutput {
    public void writeClassData(String path, List<Classroom> classrooms, boolean append) {
        File file = new File(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            if (!file.exists()||file.length()==0) {
                bw.write("Class name, homeroom teacher,size, classification,student list:...");
                bw.newLine();
            }
            for (Classroom classroom : classrooms) {
                bw.write("Class Name: " + classroom.getNameClass());
                bw.newLine();
                bw.write("Homeroom Teacher: " + classroom.getTeacher());
                bw.newLine();
                bw.write(classroom.getStudents().size() > 0 ? "Size: " + classroom.getStudents().size() : "Size: 0");
                bw.newLine();
                bw.write("Classification: " + classroom.createClassification(classroom.getStudents()));
                bw.newLine();
                bw.write("Students:");
                bw.newLine();
                for (Student student : classroom.getStudents()) {
                    bw.write(String.join("\t",student.getId(),student.getName(),student.getBirthDate()
                            ,student.getPosition(),student.getEmail(),student.getPhoneNumber()
                            ,student.getClassName(),String.valueOf(student.getAgvScore())));
                    bw.newLine();
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public List<Classroom> readClassData(String path){
        List<Classroom> classroomList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            Classroom currentClassroom = null;
            String className = null;
            Teacher homeroomTeacher = null;
            List<Student> studentList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("Class Name:")) {
                    if (currentClassroom != null) {
                        currentClassroom.setStudents(studentList);
                        classroomList.add(currentClassroom);
                    }
                    className = line.split(":")[1].trim();
                    studentList = new ArrayList<>();
                    currentClassroom = new Classroom(className,homeroomTeacher,studentList);
                }
                else if (line.startsWith("Homeroom Teacher:")) {
                    String[] teacherData = line.split(":")[1].trim().split("\t");
                    homeroomTeacher = new Teacher(
                            teacherData[0], teacherData[1], teacherData[2], teacherData[3],
                            teacherData[4], teacherData[5], teacherData[6], teacherData[7]
                    );
                    if (currentClassroom != null) {
                        currentClassroom.setTeacher(homeroomTeacher);
                    }
                }
                else if (line.startsWith("Size") || line.startsWith("Classification:") || line.startsWith("Students:")) {
                    continue;
                }
                else if (!line.isEmpty()) {
                    String[] studentData = line.split("\t");
                    Student student = new Student(
                            studentData[0], studentData[1], studentData[2], studentData[3],
                            studentData[4], studentData[5], studentData[6], Double.parseDouble(studentData[7])
                    );
                    studentList.add(student);
                }
            }
            if (currentClassroom != null) {
                currentClassroom.setStudents(studentList);
                classroomList.add(currentClassroom);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return classroomList;
    }
    public List<Student> readFileStudent(String path) {
        List<Student> Students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Student tempStudent = null;
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split(",");
                tempStudent=new Student(data[0],data[1],data[2],data[3],data[4],data[5],data[6],Double.parseDouble(data[7]));
                Students.add(tempStudent);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());;
        }
        return Students;
    }
    public void writeFileStudent(String path, List<Student> data, boolean append) {
        File file = new File(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            if (!file.exists()||file.length()==0) {
                bw.write("Id,Name,Age,Birthday,Position,Email,Phone Number,Class,Score");
                bw.newLine();
            }
            for (Student str : data) {
                bw.write(str.getInformation());
                bw.newLine();
            }
        } catch
        (IOException e) {
            System.out.println("Write file error"+e.getMessage());;
        }
    }
    public List<Teacher> readFilTeacher(String path) {
        List<Teacher> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split(",");
                list.add(new Teacher(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]));
            }
        } catch (IOException e) {
            System.out.println("Read file error."+e.getMessage());
        }
        return list;
    }

    public void writeFileTeacher(String path, List<Teacher> data, boolean append) {
        File file =new File(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            if (!file.exists()||file.length()==0){
                bw.write("Id,Name,Birthday,position,email,phone number,Subject,Homeroom Class");
                bw.newLine();
            }
            for (Teacher str : data) {
                bw.write(str.getInformation());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Write file error."+e.getMessage());
        }
    }
}
