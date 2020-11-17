import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskList{
    String name;
    ArrayList<TaskItem> taskItems;

    public TaskList(String name){
        this.name = name;
    }

    static Scanner scanner = new Scanner(System.in);

    public static void ShowOptions(){
        System.out.println();
        System.out.println("List Operation Menu");
        System.out.println("-------------------");
        System.out.println();
        System.out.println("1) view the list");
        System.out.println("2) add an item");
        System.out.println("3) edit an item");
        System.out.println("4) remove an item");
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu\n");
    }

    public static void Menu(TaskList taskList){
        int opt = 0;

        while (opt != 8) {
            try {
                ShowOptions();
                opt = scanner.nextInt();
                if (opt > 8 || opt < 1) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("not a menu option");
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("input must be number");
                scanner.next();
            }
            switch (opt) {
                case 1 -> View(taskList);
                case 2 -> AddItem(taskList);
                case 3 -> EditItem(taskList);
                case 4 -> RemoveItem(taskList);
                case 5 -> CompleteItem(taskList);
                case 6 -> UncompleteItem(taskList);
                case 7 -> Save(taskList);
            }
        }
    }

    public static void View(TaskList taskList){
        if(!(taskList.taskItems.isEmpty())){
            System.out.println();
            System.out.println("Current Tasks");
            System.out.println("-------------");
            for(int i = 0; i < taskList.taskItems.size(); i++){
                System.out.print("\n" + i + ") ");
                if(taskList.taskItems.get(i).complete){
                    System.out.print("*** ");
                }
                System.out.print("[" + taskList.taskItems.get(i).date + "] " + taskList.taskItems.get(i).title + ": " + taskList.taskItems.get(i).description);
            }
            System.out.println();
        }
        else{
            System.out.println("no tasks");
        }
    }

    public static void AddItem(TaskList taskList){
        TaskItem taskItem = new TaskItem("0");
        taskItem.setComplete(false);
        do{
            System.out.print("\ntask title: ");
            taskItem.setTitle(scanner.next());
        }while(taskItem.title.isEmpty());
        System.out.print("\ntask description: ");
        taskItem.setDescription(scanner.next());
        do{
            System.out.print("\ntask due date (YYYY-MM-DD): ");
            taskItem.setDate(scanner.next());
        }while(taskItem.date == "0");
        taskList.taskItems.add(taskItem);
    }

    public static void EditItem(TaskList taskList){
        if(taskList.taskItems.isEmpty()){
            System.out.println("no tasks");
        }else{
            View(taskList);
            System.out.print("\n\nWhich task will you edit? ");
            int opt = scanner.nextInt();
            System.out.print("\nEnter a new title for task " + opt + ": ");
            taskList.taskItems.get(opt).setTitle(scanner.next());
            System.out.print("\nEnter a new description for task " + opt + ": ");
            taskList.taskItems.get(opt).setDescription(scanner.next());
            System.out.print("\nEnter a new due date for task " + opt + ": ");
            taskList.taskItems.get(opt).setDate(scanner.next());
        }
    }

    public static void RemoveItem(TaskList taskList){
        if(taskList.taskItems.isEmpty()){
            System.out.println("no tasks");
        }else{
            View(taskList);
            System.out.print("\n\nWhich task will you remove? ");
            int opt = scanner.nextInt();
            taskList.taskItems.remove(opt);
        }
    }

    public static void CompleteItem(TaskList taskList){
        int c = 0;
        for(int i = 0; i < taskList.taskItems.size(); i++) {
            if (!(taskList.taskItems.get(i).complete)) {
                c++;
            }
            if(c > 0){
                System.out.println();
                System.out.println("Uncompleted Tasks");
                System.out.println("-----------------");
                for(i = 0; i < taskList.taskItems.size(); i++){
                    if(!(taskList.taskItems.get(i).complete)){
                        System.out.print("\n" + i + ") ");
                        System.out.print(" [" + taskList.taskItems.get(i).date + "] " + taskList.taskItems.get(i).title + ": " + taskList.taskItems.get(i).description);
                    }
                }
                System.out.print("\n\nWhich task will you mark as completed? ");
                int opt = scanner.nextInt();
                taskList.taskItems.get(opt).setComplete(true);
            }else{
                System.out.println("no tasks to complete");
            }
        }
    }

    public static void UncompleteItem(TaskList taskList){
        int c = 0;
        for(int i = 0; i < taskList.taskItems.size(); i++) {
            if (taskList.taskItems.get(i).complete) {
                c++;
            }
            if(c > 0){
                System.out.println();
                System.out.println("Completed Tasks");
                System.out.println("---------------");
                for(i = 0; i < taskList.taskItems.size(); i++){
                    if(taskList.taskItems.get(i).complete){
                        System.out.print("\n" + i + ") ");
                        System.out.print(" [" + taskList.taskItems.get(i).date + "] " + taskList.taskItems.get(i).title + ": " + taskList.taskItems.get(i).description);
                    }
                }
                System.out.print("\n\nWhich task will you unmark as completed? ");
                int opt = scanner.nextInt();
                taskList.taskItems.get(opt).setComplete(false);
            }else{
                System.out.println("no tasks complete");
            }
        }
    }

    public static void Save(TaskList taskList){
        String filename;
        System.out.print("\nEnter the filename to save as: ");
        filename = scanner.next();
        try (Formatter output = new Formatter(filename + ".txt")) {
            for(int i = 0; i < taskList.taskItems.size(); i++){
                output.format("%b_%s_%s_%s\n",taskList.taskItems.get(i).complete, taskList.taskItems.get(i).date, taskList.taskItems.get(i).title, taskList.taskItems.get(i).description);
            }
            System.out.println("task list has been saved");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }
}

