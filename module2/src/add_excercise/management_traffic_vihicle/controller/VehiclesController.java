package add_excercise.management_traffic_vihicle.controller;

import add_excercise.management_traffic_vihicle.service.VehicleManagementService;

import java.util.Scanner;

public class VehiclesController {
    private static VehicleManagementService vehicleManagementService = new VehicleManagementService();

    public static void main(String[] args) {
        displayAllVehicles();
    }
    public static void displayAllVehicles() {
        int choice;
        do {
        System.out.println("Menu: \n" +
                "1.Create Customer\n" +
                "2.Display Customer\n" +
                "3.Delete Customer\n" +
                "4.Search for name\n" +
                "0.Exit");
        System.out.print("Enter your choice: ");
        choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                vehicleManagementService.addVehicle();
                break;
            case 2:
                vehicleManagementService.displayVehicles();
                break;
            case 3:
                vehicleManagementService.deleteVehicle();
                break;
            case 4:
                vehicleManagementService.lookForVehicle();
                break;
            case 0:
                System.out.println("Goodbye! \n" +
                        "Exiting...");
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while(choice !=0);
}
}

