import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskList {
    String name;
    ArrayList<TaskItem> taskItems = new ArrayList<>();

    public TaskList(String name){
        this.name = name;
    }

    public void AddItem(TaskItem taskItem){
        this.taskItems.add(taskItem);
    }

    public void RemoveItem(int i) throws IndexOutOfBoundsException {
        this.taskItems.remove(i);
    }

    public void CompleteItem(int i) throws IndexOutOfBoundsException {
        this.taskItems.get(i).setComplete(true);
    }

    public void UncompleteItem(int i) throws IndexOutOfBoundsException {
        this.taskItems.get(i).setComplete(false);
    }

    public void Edit(int i, String date, String title, String description) throws IndexOutOfBoundsException {
        if(!(date.isEmpty()))this.taskItems.get(i).setDate(date);
        if(!(title.isEmpty()))this.taskItems.get(i).setTitle(title);
        if(!(description.isEmpty()))this.taskItems.get(i).setDescription(description);
    }

    public String GetTaskDescription(int i) throws IndexOutOfBoundsException {
        return this.taskItems.get(i).description;
    }

    public String GetTaskDate(int i) throws IndexOutOfBoundsException {
        return this.taskItems.get(i).date;
    }

    public String GetTaskTitle(int i) throws IndexOutOfBoundsException {
        return this.taskItems.get(i).title;
    }

    public Boolean GetTaskComplete(int i) throws IndexOutOfBoundsException {
        return this.taskItems.get(i).complete;
    }

    public void Save(String name){
        try (Formatter output = new Formatter(name + "tasks.txt")) {
            for(int i = 0; i < this.taskItems.size(); i++){
                output.format("%b~%s~%s~%s\n", this.GetTaskComplete(i), this.GetTaskDate(i), this.GetTaskTitle(i), this.GetTaskDescription(i));
            }
            System.out.println("task list has been saved");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    public static TaskList Load(String name) {
        File file = new File(name + "tasks.txt");
        TaskList taskList = new TaskList(name);
        try{
            if(file.exists()){
                Scanner input = new Scanner(Paths.get(name + "tasks.txt"));
                input.useDelimiter("~|\n");
                while (input.hasNext()) {
                    TaskItem taskItem = new TaskItem("0000-00-00", "0", "");
                    taskItem.setComplete(input.nextBoolean());
                    taskItem.setDate(input.next());
                    taskItem.setTitle(input.next());
                    taskItem.setDescription(input.next());
                    taskList.AddItem(taskItem);
                }
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
            System.out.println();
        }
        return taskList;
    }
}
