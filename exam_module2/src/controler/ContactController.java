package controler;

import service.ContactService;

import java.util.Scanner;

public class ContactController {
    private static ContactService contactService=new ContactService();
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        displayProgram();
    }
    public static void displayProgram() {
        int choice;
        System.out.println("Enter your choice:\n" +
                "1.Show list\n" +
                "2.Add contact\n" +
                "3.Update contact\n" +
                "4.Delete contact\n" +
                "5.Search contact\n" +
                "6.load file\n" +
                "7.Save file\n" +
                "8.Exit");
        do {
            choice=Integer.parseInt(scanner.nextLine());
            switch(choice) {
                case 1:
                    contactService.displayContactList();
                    break;
                    case 2:
                        contactService.addContact();
                        break;
                        case 3:
                            contactService.UpdateContactList();
                            break;
                            case 4:
                                contactService.deleteContact();
                                break;
                                case 5:
                                    contactService.searchContact();
                                    break;
                                    case 6:
                                        contactService.loadFile();
                                        break;
                                        case 7:
                                            contactService.saveFileToDataFile();
                                            break;
                                            case 8:
                                                System.out.println("Exiting program...");
                                                break;
                                                default:
                                                    System.out.println("Invalid choice");

            }
        }while(choice!=8);
    }
}
