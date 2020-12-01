import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public void main(String[] args){}

    public void ShowMenu(){
        System.out.println();
        System.out.println("Select Your Application");
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("1) task list");
        System.out.println("2) contact list");
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
}
