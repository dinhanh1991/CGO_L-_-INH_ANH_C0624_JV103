package add_excercise.management_traffic_vihicle.Model;

public abstract class Vehicles {
    private String numberPlate;
    private String manufacturer;
    private int yearOfManufacture;
    private String ownerName;
    public Vehicles() {}
    public Vehicles(String numberPlate, String manufacturer, int yearOfManufacture, String ownerName) {
        this.numberPlate = numberPlate;
        this.manufacturer = manufacturer;
        this.yearOfManufacture = yearOfManufacture;
        this.ownerName = ownerName;
    }
    public String getNumberPlate() {
        return numberPlate;
    }
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public abstract String toString();
}
