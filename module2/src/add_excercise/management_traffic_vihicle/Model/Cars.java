package add_excercise.management_traffic_vihicle.Model;

public class Cars extends Vehicles{
    private int numberOfSeats;
    private String typeOfCar;
    public Cars(){
        super();
    }
    public Cars(int numberOfSeats, String typeOfCar) {
        this.numberOfSeats = numberOfSeats;
        this.typeOfCar = typeOfCar;
    }
    public Cars(String numberPlate, String manufacturer, int yearOfManufacture, String ownerName, int numberOfSeats, String typeOfCar) {
        super(numberPlate, manufacturer, yearOfManufacture, ownerName);
        this.numberOfSeats = numberOfSeats;
        this.typeOfCar = typeOfCar;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Number Plate"+getNumberPlate()+"\n"+
                ", Manufacturer"+getManufacturer()+"\n"+
                ", Year of Manufacture"+getYearOfManufacture()+"\n"+
                ", Owner Name"+getOwnerName()+"\n"+
                "numberOfSeats=" + numberOfSeats +"\n"+
                ", typeOfCar='" + typeOfCar + '\'' +
                "} ";
    }
}
