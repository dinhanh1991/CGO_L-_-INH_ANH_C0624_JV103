package add_excercise.management_powder_customer.model;

public class InternationalCustomer extends Customer {
    private String nationality;

    public InternationalCustomer(String id, String name, String nationality) {
        super(id, name);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String writeInformation() {
        return getId() + "," + getName() + "," + getNationality();
    }

    @Override
    public String toString() {
        return "InternationalCustomer{" +
                "Customer id='" + getId() + '\'' +
                ", Customer name='" + getName() + '\'' +
                "nationality='" + nationality + '\'' +
                '}';
    }
}
