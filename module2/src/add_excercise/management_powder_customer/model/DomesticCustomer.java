package add_excercise.management_powder_customer.model;

public class DomesticCustomer extends Customer {
    private String typeOfCustomer;
    private int consumption;
    public DomesticCustomer(String id,String name,String typeOfCustomer, int consumption) {
        super(id,name);
        this.typeOfCustomer = typeOfCustomer;
        this.consumption = consumption;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "DomesticCustomer{" +
                "Customer id= '" + getId() +'\'' +
                ", Customer name= '" + getName() +'\'' +
                "typeOfCustomer='" + typeOfCustomer + '\'' +
                ", consumption='" + consumption + '\'' +
                '}';
    }
}
