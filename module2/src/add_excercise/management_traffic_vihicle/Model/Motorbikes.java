package add_excercise.management_traffic_vihicle.Model;

public class Motorbikes extends Vehicles {
    double enginePower;
    public Motorbikes() {
        super();
    }

    public Motorbikes(String numberPlate, String manufacturer, int yearOfManufacture, String ownerName, double enginePower) {
        super(numberPlate, manufacturer, yearOfManufacture, ownerName);
        this.enginePower = enginePower;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public String toString() {
        return "Motorbikes{" +
                "Number Plate"+getNumberPlate()+"\n"+
                ", Manufacturer"+getManufacturer()+"\n"+
                ", Year of Manufacture"+getYearOfManufacture()+"\n"+
                ", Owner Name"+getOwnerName()+"\n"+
                "enginePower=" + enginePower +
                "} ";
    }
}
