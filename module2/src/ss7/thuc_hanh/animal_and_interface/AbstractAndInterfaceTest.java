package ss7.thuc_hanh.animal_and_interface;

public class AbstractAndInterfaceTest {
    public static void main(String[] args) {
        Animal[] animal =new Animal[2] ;
        animal[0]= new Tiger();
        animal[1]= new Chicken();
        for (Animal a:animal) {
            System.out.println(a.makeSound());
        }
    }
}
