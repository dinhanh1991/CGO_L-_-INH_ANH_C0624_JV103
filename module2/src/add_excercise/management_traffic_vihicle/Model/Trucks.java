package add_excercise.management_traffic_vihicle.Model;

public class Trucks extends Vehicles{
    private int loadCapacity;
    public Trucks() {
        super();
    }
    public Trucks(String numberPlate, String manufacturer, int yearOfManufacture, String ownerName, int loadCapacity) {
        super(numberPlate, manufacturer, yearOfManufacture, ownerName);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    @Override
    public String toString() {
        return "Truck{" +
                "number plate: "+getNumberPlate()+"\n"+
                "manufacturer: "+getManufacturer()+"\n"+
                "yearOfManufacture: "+getYearOfManufacture()+"\n"+
                "ownerName: "+getOwnerName()+"\n"+
                "loadCapacity: "+getLoadCapacity()+
                "} ";
    }
}
