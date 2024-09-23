package add_excercise.management_traffic_vihicle.service;

import add_excercise.management_traffic_vihicle.Model.*;
import ss5.thuc_tap.static_property.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManagementService {
    private ArrayList<Vehicles> vehicles = new ArrayList<>();
    private static ArrayList<Manufacture> manufactures = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    static {
        manufactures.add(new Manufacture("A01", "Toyota", "Japan"));
        manufactures.add(new Manufacture("A02", "Vinfast", "Viet Nam"));
        manufactures.add(new Manufacture("A01", "Kia", "Sount Korea"));
    }

    public void addVehicle() {
        int choice;

            System.out.println("Enter number plate");
            String numberPlate = scanner.nextLine();
            System.out.println("Enter vehicle manufacturer");
            String manufacturer = scanner.nextLine();
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
                    vehicles.add(new Trucks(numberPlate, manufacturer,
                            yearOfManufacture, ownerName, loadCapacity));
                    System.out.println("Add success");
                    break;
                case 2:
                    System.out.println("Add Car");
                    System.out.println("Enter seat's car (unit: seat)");
                    int seat = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter type of car");
                    String typeOfCar = scanner.nextLine();
                    vehicles.add(new Cars(numberPlate, manufacturer,
                            yearOfManufacture, ownerName, seat, typeOfCar));
                    System.out.println("Add success");
                    break;
                case 3:
                    System.out.println("Add Motorbike");
                    System.out.println("Enter engine power (unit: HP)");
                    int enginePower = Integer.parseInt(scanner.nextLine());
                    vehicles.add(new Motorbikes(numberPlate, manufacturer
                            , yearOfManufacture, ownerName, enginePower));
                    System.out.println("Add success");
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
            System.out.println("There are many vehicles which are greater than one,do you wana delete :");
            boolean chosen = scanner.nextBoolean();
            if (chosen) {
                System.out.println("you say yes delete...");
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
