import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskListTest {

    @Test
    void addingTaskItemsIncreasesSize(){
        TaskList taskList = new TaskList("name");
        int size = taskList.taskItems.size();
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertEquals(size+1, taskList.taskItems.size());
    }

    @Test
    void completingTaskItemChangesStatus(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        boolean status = taskList.taskItems.get(0).complete;
        taskList.CompleteItem(0);
        Assertions.assertEquals(!status, taskList.taskItems.get(0).complete);
    }

    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.CompleteItem(2));
    }

    @Test
    void editingTaskItemChangesValues(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        taskList.Edit(0, "", "", "1");
        Assertions.assertEquals("1", taskList.taskItems.get(0).description);
    }

    @Test
    void editingTaskItemDescriptionChangesValue(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", "0"));
        taskList.Edit(0, "", "", "1");
        Assertions.assertEquals("1", taskList.taskItems.get(0).description);
    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", "0"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.Edit(2, "", "", "1"));
    }

    @Test
    void editingTaskItemDueDateChangesValue(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        taskList.Edit(0, "2021-01-02", "", "");
        Assertions.assertEquals("2021-01-02", taskList.taskItems.get(0).date);
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.Edit(2, "2021-01-02", "", ""));
    }

    @Test
    void editingTaskItemTitleChangesValue(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        taskList.Edit(0, "", "1", "");
        Assertions.assertEquals("1", taskList.taskItems.get(0).title);
    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.Edit(2, "", "1", ""));
    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", "0"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.GetTaskDescription(2));
    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", "0"));
        Assertions.assertEquals("0", taskList.GetTaskDescription(0));
    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.GetTaskDate(2));
    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertEquals("2021-01-01", taskList.GetTaskDate(0));
    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.GetTaskTitle(2));
    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertEquals("0", taskList.GetTaskTitle(0));
    }

    @Test
    void newTaskListIsEmpty(){
        TaskList taskList = new TaskList("name");
        Assertions.assertTrue(taskList.taskItems.isEmpty());
    }

    @Test
    void removingTaskItemsDecreasesSize(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        int size = taskList.taskItems.size();
        taskList.RemoveItem(0);
        Assertions.assertEquals(size-1, taskList.taskItems.size());
    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.RemoveItem(2));
    }

    @Test
    void savedTaskListCanBeLoaded() {
        TaskList taskList = new TaskList("save");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        taskList.AddItem(new TaskItem("2021-01-01", "1", ""));
        taskList.Save("test");
        TaskList loaded = TaskList.Load("test");
        Assertions.assertEquals("0", loaded.GetTaskTitle(0));
        Assertions.assertEquals("2021-01-01", loaded.GetTaskDate(0));
        Assertions.assertEquals("1", loaded.GetTaskTitle(1));
        Assertions.assertEquals("2021-01-01", loaded.GetTaskDate(1));
    }

    @Test
    void uncompletingTaskItemChangesStatus(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        taskList.CompleteItem(0);
        boolean status = taskList.taskItems.get(0).complete;
        taskList.UncompleteItem(0);
        Assertions.assertEquals(!status, taskList.taskItems.get(0).complete);
    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList("name");
        taskList.AddItem(new TaskItem("2021-01-01", "0", ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> taskList.UncompleteItem(2));
    }
}
