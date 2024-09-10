package ss5.bai_tap.Students;

public class Students {
    private String name="john";
    private String classes= "C02";
    public Students(){}
    public  void setName(String name){
        this.name=name;
    }
    public void setClasses(String classes){
        this.classes=classes;
    }

    public static void main(String[] args) {
        Students students1=new Students();
        Students students2=new Students();
        Students students3=new Students();
        students1.setName("Anna");
        students1.setClasses("BC5");
        students2.setName("Jack");
        students2.setClasses("BC6");
        System.out.println("Student 1 name: "+students1.name+"Class: "+students1.classes);
        System.out.println("Student 2 name: "+students2.name+"Class: "+students2.classes);
        System.out.println("Student 3 name: "+students3.name+"Class: "+students3.classes);
    }
}

