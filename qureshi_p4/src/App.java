import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Menu();
    }

    public static void ShowOptions(){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) create a new list");
        System.out.println("2) load an existing list");
        System.out.println("3) quit\n");
    }

    public static void Menu(){
        int opt = 0;

        while (opt != 3){
            try{
                ShowOptions();
                opt = scanner.nextInt();
                if(opt > 3 || opt < 1){
                    throw new IllegalArgumentException();
                }
            }
            catch(IllegalArgumentException illegalArgumentException){
                System.err.println("not a menu option");
            }
            catch(InputMismatchException inputMismatchException){
                System.err.println("input must be a digit");
                scanner.next();
            }
            switch (opt) {
                case 1 -> {
                    System.out.print("\nname new list: ");
                    String name = scanner.next();
                    CreateList(name);
                }
                case 2 -> {
                    System.out.print("\nname list to load: ");
                    String name = scanner.next();
                    LoadList(name);
                }
            }
        }
    }

    public static void CreateList(String name){
        try{
            TaskList taskList = new TaskList(name);
            File t = new File(name + ".txt");
            if(t.createNewFile()){
                taskList.taskItems = new ArrayList<>();
                System.out.println("created list: " + t.getName());
                TaskList.Menu(taskList);
            }else{
                System.out.println("list already exists");
                LoadList(name);
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println();
        }
    }

    public static void LoadList(String name) {
        try{
            File t = new File(name + ".txt");
            if(t.exists()){
                TaskList taskList = new TaskList(name);
                taskList.taskItems = new ArrayList<>();
                Scanner input = new Scanner(Paths.get(name + ".txt"));
                input.useDelimiter("/|\n");
                while (input.hasNext()) {
                    TaskItem taskItem = new TaskItem();
                    taskItem.setComplete(input.nextBoolean());
                    taskItem.setDate(input.next());
                    taskItem.setTitle(input.next());
                    taskItem.setDescription(input.next());
                    taskList.taskItems.add(taskItem);
                }
                TaskList.Menu(taskList);
            }else{
                System.err.println("file not found");
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}
