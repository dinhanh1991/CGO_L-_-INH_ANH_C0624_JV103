package untils;

import model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CvsInputData {
    public List<Contact> readFileContact(String path) {
        List<Contact> contacts = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Contact tempContact
                    = null;
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split(",");
                tempContact=new Contact(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
                contacts.add(tempContact);

            }
            System.out.println("Contact loaded");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());;
        }
        return contacts;
    }
    public void writeFileContact(String path, List<Contact> data, boolean append) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            for (Contact contact : data) {
                writer.write(contact.displayIform());
                writer.newLine();
                System.out.println("Contact saved");
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
