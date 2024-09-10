package ss5.thuc_tap.static_method;

public class Main {
    public static void main(String[] args) {
        Student.change();
        Student s1=new Student(111,"Hoàng");
        Student s2=new Student(222,"Khanh");
        Student s3=new Student(333,"Nam");
        s1.display();
        s2.display();
        s3.display();
    }
}
