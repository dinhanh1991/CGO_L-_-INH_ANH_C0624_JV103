package add_excercise.management_traffic_vihicle.service;

import add_excercise.management_traffic_vihicle.Model.*;
import ss5.thuc_tap.static_property.Car;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VehicleManagementService {
    private ArrayList<Vehicles> vehicles = new ArrayList<>();
    private  ArrayList<Manufacture> motorbikeManufactures = new ArrayList<>();
    private  ArrayList<Manufacture> truckManufactures = new ArrayList<>();
    private  ArrayList<Manufacture> carManufactures = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private  Random random =new Random();

    public VehicleManagementService() {
        motorbikeManufactures.add(new Manufacture("01","Honda","Japan"));
        motorbikeManufactures.add(new Manufacture("02","Yamaha","Japan"));
        motorbikeManufactures.add(new Manufacture("03","Suzuki","Japan"));
        motorbikeManufactures.add(new Manufacture("04","Piaggio","Italy"));
        motorbikeManufactures.add(new Manufacture("05","Harley-Davidson","USA"));
        motorbikeManufactures.add(new Manufacture("06","Ducati","Italia"));
        carManufactures.add(new Manufacture("01","Honda","Japan"));
        carManufactures.add(new Manufacture("02","Toyota","Japan"));
        carManufactures.add(new Manufacture("03","Volkswagen","Germany"));
        carManufactures.add(new Manufacture("04","BMW","Germany"));
        carManufactures.add(new Manufacture("05","Hyundai","Korea"));
        carManufactures.add(new Manufacture("06","Mazda","Japan"));
        carManufactures.add(new Manufacture("07","Audi","Germany"));
        carManufactures.add(new Manufacture("08","Porsche","Germany"));
        truckManufactures.add(new Manufacture("01","Fuso","Japan"));
        truckManufactures.add(new Manufacture("02","Dongfeng","China"));
        truckManufactures.add(new Manufacture("03","DaeWoo","India"));
        truckManufactures.add(new Manufacture("04","Hyundai","Korea"));
        truckManufactures.add(new Manufacture("05","Trường Hải Auto","Viet Nam"));
        truckManufactures.add(new Manufacture("06","Isuzu","Japan"));
        truckManufactures.add(new Manufacture("07","Jac","China"));

    }

    public void addVehicle() {
        int choice;

            System.out.println("Enter number plate");
            String numberPlate = scanner.nextLine();
            System.out.println("Enter owner's vehicle");
            String ownerName = scanner.nextLine();
            System.out.println("Enter year of manufacture's vehicle");
            int yearOfManufacture = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter vehicle :\n" +
                    "1. Add truck." + "\n" +
                    "2. Add Car.\n" +
                    "3. Add Motorbike.\n"+
                    "0.Exit");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Add truck");
                    System.out.println("Enter load capacity (unit: Ton)");
                    int loadCapacity = Integer.parseInt(scanner.nextLine());
                    String truckManufacturer =truckManufactures.get(random.nextInt(truckManufactures.size())).getName();
                    vehicles.add(new Trucks(numberPlate, truckManufacturer,
                            yearOfManufacture, ownerName, loadCapacity));
                    System.out.println("Add success");
                    System.out.println("The new Vehicle just added: ");
                    for (Vehicles vehicle : vehicles) {
                        if (vehicle instanceof Trucks) {
                            System.out.println(vehicle.toString());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Add Car");
                    System.out.println("Enter seat's car (unit: seat)");
                    int seat = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter type of car");
                    String typeOfCar = scanner.nextLine();
                    String carManufacturer =carManufactures.get(random.nextInt(truckManufactures.size())).getName();
                    vehicles.add(new Cars(numberPlate, carManufacturer,
                            yearOfManufacture, ownerName, seat, typeOfCar));
                    System.out.println("Add success");
                    for (Vehicles vehicle : vehicles) {
                        if (vehicle instanceof Cars) {
                            System.out.println(vehicle.toString());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Add Motorbike");
                    System.out.println("Enter engine power (unit: HP)");
                    int enginePower = Integer.parseInt(scanner.nextLine());
                    String motorbikeManufacturer =motorbikeManufactures.get(random.nextInt(truckManufactures.size())).getName();
                    vehicles.add(new Motorbikes(numberPlate, motorbikeManufacturer
                            , yearOfManufacture, ownerName, enginePower));
                    System.out.println("Add success");
                    for (Vehicles vehicle : vehicles) {
                        if (vehicle instanceof Motorbikes) {
                            System.out.println(vehicle.toString());
                        }
                    }
                    break;
                    case 0:
                        System.out.println("Exit");
                    default:
                        System.out.println("Invalid choice");
            }
    }
    public void displayVehicles() {
        System.out.println("Enter vehicle :\n" +
                "1. Add truck." + "\n" +
                "2. Add Car.\n" +
                "3. Add Motorbike.");
        System.out.println("Enter your choice");
        int choice = Integer.parseInt(scanner.nextLine());
        for (Vehicles vehicle : vehicles) {
            if (choice == 1&&vehicle instanceof Trucks) {
                System.out.println(vehicle.toString());
            }else if (choice == 2&&vehicle instanceof Cars) {
                System.out.println(vehicle.toString());
            } else if (choice == 3&&vehicle instanceof Motorbikes) {
                System.out.println(vehicle.toString());
            }
        }
    }public void deleteVehicle() {
        System.out.println("Enter number plate");
        String numberPlate = scanner.nextLine();
        int count =0;
        for (Vehicles vehicle : vehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Vehicle does not exist");
        } else if (count == 1) {
            vehicles.removeIf(vehicle -> vehicle.getNumberPlate().equals(numberPlate));
            System.out.println("Delete success");
        }else {
            System.out.println("There are many vehicles which are greater than one,do you wana delete :\n" +
                    "input true to agree\n" +
                    "input false to disagree");
            boolean chosen = scanner.nextBoolean();
            if (chosen) {
                System.out.println("you agreed to delete...");
                vehicles.removeIf(vehicle -> vehicle.getNumberPlate().equals(numberPlate));
                System.out.println("successfully deleted");
                return;
            }
            System.out.println("You canceled");
        }
    }
    public void lookForVehicle() {
        System.out.println("Enter number plate");
        String numberPlate = scanner.nextLine();
        for (Vehicles vehicle : vehicles) {
            if (vehicle.getNumberPlate().equals(numberPlate)) {
                System.out.println(vehicle.toString());
                return;
            }
        }
        System.out.println("Vehicle does not exist");
    }
}
