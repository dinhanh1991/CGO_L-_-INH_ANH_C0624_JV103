package service;

import model.Contact;
import untils.CvsInputData;
import untils.ValidationUtils;

import java.util.List;
import java.util.Scanner;

public class ContactService {
    private final String CONTACT_PATH = "data/contact";
    private final CvsInputData cvsInputData = new CvsInputData();
    private final ValidationUtils validationUtils = new ValidationUtils();
    private final List<Contact> contactList = cvsInputData.readFileContact(CONTACT_PATH);
    Scanner scanner = new Scanner(System.in);

    public void displayContactList() {
        for (Contact contact : contactList) {
            System.out.println(contact.toString());
        }
    }

    public void UpdateContactList() {
        System.out.println("Invalid Phone Number input again.phone number has 10 number and start :0");
        String phoneNumber = scanner.nextLine();
        while (!validationUtils.isValidPhoneNumber(phoneNumber)) {
            System.out.println("Enter valid phone number");
            phoneNumber = scanner.nextLine();
        }
        for (Contact contact : contactList) {
            if (!contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Phone number does not match");
                return;
            }
        }
        System.out.println("Enter group contact");
        String groupContact = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter gender");
        String gender = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        while (!validationUtils.isValidEmail(email)) {
            System.out.println("Invalid Email Input again");
            email = scanner.nextLine();
        }
        System.out.println("Enter birth date(dd/mm/yyyy)");
        String birthDate = scanner.nextLine();
        while (!validationUtils.isValidDate(birthDate)) {
            System.out.println("Invalid Date Input again");
            birthDate = scanner.nextLine();
        }
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                contact.setGender(gender);
                contact.setName(name);
                contact.setAddress(address);
                contact.setEmailAddress(email);
                contact.setBirthDate(birthDate);
                contact.setGroup(groupContact);
            }
        }
        System.out.println("Contact List Updated");
    }

    public void deleteContact() {
        System.out.println("Invalid Phone Number input again.phone number has 10 number and start :0");
        String phoneNumber = scanner.nextLine();
        while (!validationUtils.isValidPhoneNumber(phoneNumber)) {
            System.out.println("Enter valid phone number");
            phoneNumber = scanner.nextLine();
        }
        for (Contact contact : contactList) {
            if (!contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Phone number does not match");
                return;
            }
        }
        for (Contact contact : contactList) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("The deletion will result in data loss;" +
                        " press 'Y' to continue, or any other key to cancel.");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    contactList.remove(contact);
                } else {
                    System.out.println("The deletion cancelled");
                    return;
                }
                break;
            }
        }
        System.out.println("Contact List deleted");
    }

    public void addContact() {
        System.out.println("Enter Phone Number");
        String phoneNumber = scanner.nextLine();
        while (!validationUtils.isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid Phone Number input again.phone number has 10 number and start :0");
            phoneNumber = scanner.nextLine();
        }
        System.out.println("Enter group contact");
        String groupContact = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter gender");
        String gender = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        while (!validationUtils.isValidEmail(email)) {
            System.out.println("Invalid Email Input again");
            email = scanner.nextLine();
        }
        System.out.println("Enter birth date(dd/mm/yyyy)");
        String birthDate = scanner.nextLine();
        while (!validationUtils.isValidDate(birthDate)) {
            System.out.println("Invalid Date Input again");
            birthDate = scanner.nextLine();
        }
        Contact contact = new Contact(phoneNumber, groupContact, name, gender, address, email, birthDate);
        contactList.add(contact);
        System.out.println("Contact added");
    }

    public void searchContact() {
        System.out.println("chose 1 : Search for Phone Number\n" +
                "Chose 2 search for Name");
        int choice = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        if (choice == 1) {
            System.out.println("Enter Phone Number");
            String phoneNumber = scanner.nextLine();
            while (!validationUtils.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid Phone Number input again.phone number has 10 number and start :0");
                phoneNumber = scanner.nextLine();
            }
            for (Contact contact : contactList) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    System.out.println("The contact is: " + contact.toString());
                }
                found = true;
            }

        }else if(choice == 2) {
            System.out.println("Enter Phone Number");
            String name = scanner.nextLine();
            for (Contact contact : contactList) {
                if (contact.getName().equals(name)) {
                    System.out.println("The contact is: " + contact.toString());
                }
            }
            found = true;
        }else {
            System.out.println("Ivalid choice");
        }
       if (!found) {
           System.out.println("Contact not found");
       }
    }
    public void loadFile(){
        String confirm;
        System.out.println("if you want to load file the data will change input \"yes\" to load and \"no\" to cancel");
        confirm = scanner.nextLine();
        while (!confirm.toLowerCase().equals("yes")&&!confirm.toLowerCase().equals("no")) {
            System.out.println("Enter yes or no");
            confirm = scanner.nextLine();
        }
        if (confirm.toLowerCase().equals("yes")) {
            cvsInputData.readFileContact(CONTACT_PATH);
        } else if (confirm.toLowerCase().equals("no")) {
            System.out.println("Cancel load file");
        }
    }
    public void saveFileToDataFile(){
        String confirm;
        System.out.println("if you want to load file the data will change input \"yes\" to load and \"no\" to cancel");
        confirm = scanner.nextLine();
        while (!confirm.toLowerCase().equals("yes")&&!confirm.toLowerCase().equals("no")) {
            System.out.println("Enter yes or no");
            confirm = scanner.nextLine();
        }
        if (confirm.toLowerCase().equals("yes")) {
            cvsInputData.writeFileContact(CONTACT_PATH,contactList,true);
        } else if (confirm.toLowerCase().equals("no")) {
            System.out.println("Cancel load file");
        }
    }
}
