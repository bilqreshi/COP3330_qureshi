import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp {
    static Scanner scanner = new Scanner(System.in);

    public static void ShowMenu(){
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println();
        System.out.println("1) create a new task list");
        System.out.println("2) load an existing task list");
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
                e.printStackTrace();
            } catch(IllegalArgumentException illegalArgumentException){
                System.err.println("not a menu option");
            }
            switch (opt) {
                case 1 -> {
                    TaskList taskList = new TaskList();
                    System.out.println("new task list has been created");
                    Operations(taskList);
                }
                case 2 -> {
                    System.out.println("Enter the filename to load: ");
                    String name = scanner.next();
                    Operations(TaskList.Load(name));
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
        System.out.println("5) mark an item as completed");
        System.out.println("6) unmark an item as completed");
        System.out.println("7) save the current list");
        System.out.println("8) quit to the main menu\n");
    }

    public static void Operations(TaskList taskList) {
        int opt = 0;
        while (opt != 8){
            try{
                ShowOperations();
                opt = scanner.nextInt();
                if(opt > 8 || opt < 1){
                    throw new IllegalArgumentException();
                }
            } catch(InputMismatchException e){
                System.err.println("input must be a digit");
                e.printStackTrace();
            } catch(IllegalArgumentException illegalArgumentException){
                System.err.println("not a menu option");
            }
            switch (opt) {
                case 1 -> taskList.View();
                case 2 -> Add(taskList);
                case 3 -> Edit(taskList);
                case 4 -> Remove(taskList);
                case 5 -> Complete(taskList);
                case 6 -> Uncomplete(taskList);
                case 7 -> {
                    System.out.print("Enter the filename to save as: ");
                    taskList.Save(scanner.next());
                }
            }
        }
    }

    public static void Add(TaskList taskList){
        TaskItem taskItem = new TaskItem("0");
        System.out.print("\ntask title: ");
        taskItem.setTitle(scanner.next());
        System.out.print("\ntask description: ");
        taskItem.setDescription(scanner.next());
        do {
            System.out.print("\ntask due date (YYYY-MM-DD): ");
            taskItem.setDate1(scanner.next());
        } while(taskItem.date == "0");
        taskList.AddItem(taskItem);
    }

    public static void Edit(TaskList taskList){
        if(taskList.taskItems.isEmpty()){
            System.out.println("no tasks");
        }else{
            taskList.View();
            int opt = 0;
            try {
                System.out.print("\n\nWhich task will you edit? ");
                opt = scanner.nextInt();
            }catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("not a task");
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("input must be number");
            }
            try{
                System.out.print("\nEnter a new title for task " + opt + ": ");
                taskList.taskItems.get(opt).setTitle(scanner.next());
                System.out.print("\nEnter a new description for task " + opt + ": ");
                taskList.taskItems.get(opt).setDescription(scanner.next());
                System.out.print("\nEnter a new due date for task " + opt + " (YYYY-MM-DD): ");
                taskList.taskItems.get(opt).setDate(scanner.next());
            }catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("must be format (YYYY-MM-DD)");
            }
        }
    }

    public static void Remove(TaskList taskList){
        if(taskList.taskItems.isEmpty()){
            System.out.println("no tasks");
        }else{
            taskList.View();
            try{
                System.out.print("\n\nWhich task will you remove? ");
                int opt = scanner.nextInt();
                taskList.RemoveItem(opt);
            }catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("not a task");
            } catch (InputMismatchException inputMismatchException) {
                System.err.println("input must be number");
            }
        }
    }

    public static void Complete(TaskList taskList){
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
                try{
                    System.out.print("\n\nWhich task will you mark as completed? ");
                    int opt = scanner.nextInt();
                    taskList.taskItems.get(opt).setComplete(true);
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.err.println("not a task");
                } catch (InputMismatchException inputMismatchException) {
                    System.err.println("input must be number");
                }
            }else{
                System.out.println("no tasks to complete");
            }
        }
    }

    public static void Uncomplete(TaskList taskList){
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
                try{
                    System.out.print("\n\nWhich task will you unmark as completed? ");
                    int opt = scanner.nextInt();
                    taskList.taskItems.get(opt).setComplete(false);
                } catch (IllegalArgumentException illegalArgumentException) {
                    System.err.println("not a task");
                } catch (InputMismatchException inputMismatchException) {
                    System.err.println("input must be number");
                }
            }else{
                System.out.println("no tasks complete");
            }
        }
    }
}
