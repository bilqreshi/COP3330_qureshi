import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    static Scanner scanner = new Scanner(System.in);

    public static void ShowMenu(){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) create a new contact list");
        System.out.println("2) load an existing contact list");
        System.out.println("3) quit\n");
    }

    public static void Menu() {
        int opt = 0;
        while (opt != 3){
            try{
                ShowMenu();
                opt = scanner.nextInt();
                if(opt > 3 || opt < 1){
                    throw new IllegalArgumentException();
                }
            } catch(InputMismatchException e){
                System.err.println("input must be a digit");
            } catch(IllegalArgumentException illegalArgumentException){
                System.err.println("not a menu option");
            }
            switch (opt) {
                case 1 -> {
                    ContactList contactList = new ContactList();
                    System.out.println("new contact list has been created");
                    Operations(contactList);
                }
                case 2 -> {
                    System.out.println("Enter the filename to load: ");
                    String name = scanner.next();
                    Operations(ContactList.Load(name));
                }
            }
        }
    }

    public static void ShowOperations(){
        System.out.println();
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) save the current list");
        System.out.println("6) quit to the main menu\n");
    }

    public static void Operations(ContactList contactList) {
        int opt = 0;
        while (opt != 6){
            try{
                ShowOperations();
                opt = scanner.nextInt();
                if(opt > 6 || opt < 1){
                    throw new IllegalArgumentException();
                }
            } catch(InputMismatchException e){
                System.err.println("input must be a digit");
            } catch(IllegalArgumentException illegalArgumentException){
                System.err.println("not a menu option");
            }
            switch (opt) {
                case 1 -> contactList.View();
                case 2 -> Add(contactList);
                case 3 -> Edit(contactList);
                case 4 -> Remove(contactList);
                case 5 -> {
                    System.out.print("Enter the filename to save as: ");
                    contactList.Save(scanner.next());
                }
            }
        }
    }

    public static void Add(ContactList contactList){
        ContactItem contactItem = new ContactItem("0", "0");
        System.out.print("\nFirst name: ");
        contactItem.setFirst(scanner.next());
        System.out.print("\nLast name: ");
        contactItem.setLast(scanner.next());
        do{
            System.out.print("\nPhone number (xxx-xxx-xxxx): ");
            contactItem.setPhone1(scanner.next());
        } while(contactItem.phone == "0");
        do{
            System.out.print("\nEmail address (x@y.z): ");
            contactItem.setEmail1(scanner.next());
        } while(contactItem.email == "0");
        contactList.AddItem(contactItem);
    }

    public static void Edit(ContactList contactList){
        if(contactList.contactItems.isEmpty()){
            System.out.println("no contacts");
        }else{
            contactList.View();
            int opt = 0;
            try {
                System.out.print("\n\nWhich contact will you edit? ");
                opt = scanner.nextInt();
            }catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("not a contact");
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("input must be number");
            }
            try{
                System.out.print("\nEnter a new first name for contact " + opt + ": ");
                contactList.contactItems.get(opt).setFirst(scanner.next());
                System.out.print("\nEnter a new last name for contact " + opt + ": ");
                contactList.contactItems.get(opt).setLast(scanner.next());
                System.out.print("\nEnter a new phone number (xxx-xxx-xxxx) for contact " + opt + ": ");
                contactList.contactItems.get(opt).setPhone(scanner.next());
                System.out.print("\nEnter a new email address (x@y.z) for contact " + opt + ": ");
                contactList.contactItems.get(opt).setEmail(scanner.next());
            }catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("incorrect format");
            }
        }
    }

    public static void Remove(ContactList contactList){
        if(contactList.contactItems.isEmpty()){
            System.out.println("no contacts");
        }else{
            contactList.View();
            try{
                System.out.print("\n\nWhich contact will you remove? ");
                int opt = scanner.nextInt();
                contactList.RemoveItem(opt);
            }catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("not a contact");
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("input must be number");
            }
        }
    }
}
