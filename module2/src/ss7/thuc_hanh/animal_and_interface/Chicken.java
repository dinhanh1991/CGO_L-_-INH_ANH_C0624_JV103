package ss7.thuc_hanh.animal_and_interface;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken : cluck_cluck";
    }

    @Override
    public String howToEat() {
        return "\"could be fried\"";
    }
}
