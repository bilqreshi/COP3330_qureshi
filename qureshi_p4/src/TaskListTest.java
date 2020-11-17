import org.junit.jupiter.api.Test;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList test = new TaskList("test");
        TaskItem taskItem = new TaskItem("0");
    }

    @Test
    public void completingTaskItemChangesStatus(){}

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){}

    @Test
    public void editingTaskItemChangesValues(){}

    @Test
    public void editingTaskItemDescriptionChangesValue(){}

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){}

    @Test
    public void editingTaskItemDueDateChangesValue(){}

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){}

    @Test
    public void editingTaskItemTitleChangesValue(){}

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){}

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){}

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){}

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){}

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){}

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){}

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){}

    @Test
    public void newTaskListIsEmpty(){
        TaskList test = new TaskList("test");
        assert(NullPointerException, test.taskItems.size());
    }

    @Test
    public void removingTaskItemsDecreasesSize(){}

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){}

    @Test
    public void savedTaskListCanBeLoaded(){}

    @Test
    public void uncompletingTaskItemChangesStatus(){}

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){}
}
