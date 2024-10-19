package case_study.model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private  String className;
    private  String homeroomTeacher;
    private int classSize;
    private String classification;
    private List<String[]> students;

    public Classroom(String className,String homeroomTeacher,String classification, List<String[]> students) {
        this.className = className;
        this.homeroomTeacher = homeroomTeacher;
        this.classSize = students.size();
        this.classification = classification;
        this.students = students;
    }
    public int getClassSize() {
        return students.size();
    }
    public Object [] getClassList() {
        Object [] list = new Object [5];
        list[0] = className;
        list[1] = homeroomTeacher;
        list[2] = classSize;
        list[3] = classification;
        list[4] = students;
        return list;
    }
}
