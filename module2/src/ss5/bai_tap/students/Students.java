package ss5.bai_tap.students;

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
    public String displayInformation(){
        return "Name :"+this.name+"\nClasses :"+this.classes;
    }
}

