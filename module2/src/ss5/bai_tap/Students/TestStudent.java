package ss5.bai_tap.Students;

public class TestStudent {
    public static void main(String[] args) {
        Students s1=new Students();
           Students s2=new Students();
           s1.setName("Anh");
           s2.setName("Hạnh");
           s2.setClasses("51C1");
        System.out.println(s1.displayInformation());
        System.out.println(s2.displayInformation());
    }
}
