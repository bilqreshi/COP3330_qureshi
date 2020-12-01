import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {
    static Scanner scanner = new Scanner(System.in);

    public void ShowMenu(){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) create a new contact list");
        System.out.println("2) load an existing contact list");
        System.out.println("3) quit\n");
    }

    public void Menu() throws IllegalArgumentException {
        int opt = 0;
        while (opt != 3){
            try{
                ShowMenu();
                opt = scanner.nextInt();
                if(opt > 3 || opt < 1){
                    throw new IllegalArgumentException("not a menu option");
                }
            } catch(InputMismatchException e){
                System.err.println("input must be a digit");
                e.printStackTrace();
            }
            switch (opt) {
                case 1 -> {
                }
                case 2 -> {
                }
            }
        }
    }

    public void ShowOperations(){
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

    public void Operations() throws IllegalArgumentException {
        int opt = 0;
        while (opt != 6){
            try{
                ShowOperations();
                opt = scanner.nextInt();
                if(opt > 6 || opt < 1){
                    throw new IllegalArgumentException("not a menu option");
                }
            } catch(InputMismatchException e){
                System.err.println("input must be a digit");
                e.printStackTrace();
            }
            switch (opt) {
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                }
            }
        }
    }
}