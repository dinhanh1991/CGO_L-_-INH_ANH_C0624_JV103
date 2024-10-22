package case_study.model;

import java.util.List;

public class Classroom {
    private String nameClass;
    private Teacher teacher;
    private String informSize;
    private String classificationInform;
    private List<Student> students;
    public Classroom(){}
    public Classroom(String nameClass, Teacher teacher, List<Student> students) {
        this.nameClass = nameClass;
        this.teacher = teacher;
        this.informSize ="Size "+students.size();
        this.classificationInform ="Classification: "+createClassification(students);
        this.students = students;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getNameClass() {
        return nameClass;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getInformSize() {
        return informSize;
    }

    public String getClassificationInform() {
        return classificationInform;
    }

    public List<Student> getStudents() {
        return students;
    }
    public String createClassification(List<Student> students) {
        int[] ranking = new int[5];
        for (Student student : students) {
            double agvScore = student.getAgvScore();
            if (agvScore < 0 || agvScore > 10) {
                System.out.println("Invalid score : " + student.getName());
                continue;
            }
            if (agvScore>=8.5){
                ranking[0]++;
            } else if (agvScore>=8.0) {
                ranking[1]++;
            } else if (agvScore>=6.5) {
                ranking[2]++;
            }else if (agvScore>=5.0) {
                ranking[3]++;
            }else {
                ranking[4]++;
            }
        }
        return "Excellent: "+ranking[0]+" Good: "+ranking[1]+" Fair: "+ranking[2]+ " Average: "+ranking[3]+" Bad : "+ranking[4];
    }
    public String displayListStudents(){
        String inform="";
        for (Student student : students) {
            inform+=student.toString()+"\n";
        }
        return inform;
    }

    @Override
    public String toString() {
        return "Name class"+getNameClass()+"\n" +
                "Homeroom teacher: "+getTeacher().toString()+"\n" +
                getInformSize()+"\n" +
                getClassificationInform()+"\n" +
                "Student \n"+displayListStudents();
    }
}
