import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContactList {
    String name;
    ArrayList<ContactItem> contactItems = new ArrayList<>();

    public ContactList(String name){
        this.name = name;
    }

    public void AddItem(ContactItem contactItem){
        this.contactItems.add(contactItem);
    }

    public void RemoveItem(int i) throws IndexOutOfBoundsException {
        this.contactItems.remove(i);
    }

    public void Edit(int i, String first, String last, String phone, String email) throws IndexOutOfBoundsException {
        this.contactItems.get(i).Edit(first, last, phone, email);
    }

    public void Save(String name){
        try (Formatter output = new Formatter(name + "contacts.txt")) {
            for(int i = 0; i < this.contactItems.size(); i++){
                output.format("%s~%s~%s~%s\n", this.contactItems.get(i).first, this.contactItems.get(i).last, this.contactItems.get(i).phone, this.contactItems.get(i).email);
            }
            System.out.println("contact list has been saved");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    public static ContactList Load(String name) {
        File file = new File(name + "contacts.txt");
        ContactList contactList = new ContactList(name);
        try{
            if(file.exists()){
                Scanner input = new Scanner(Paths.get(name + "contacts.txt"));
                input.useDelimiter("~|\n");
                while (input.hasNext()) {
                    ContactItem contactItem = new ContactItem("0", "", "", "");
                    contactItem.setFirst(input.next());
                    contactItem.setLast(input.next());
                    contactItem.setPhone(input.next());
                    contactItem.setEmail(input.next());
                    contactList.AddItem(contactItem);
                }
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
            System.out.println();
        }
        return contactList;
    }
}
