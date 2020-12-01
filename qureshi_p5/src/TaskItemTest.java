import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskItemTest {

    @Test
    void constructorFailsWithInvalidDueDate(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new TaskItem("0", "0", ""));
    }

    @Test
    void constructorFailsWithInvalidTitle(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new TaskItem("2021-01-01", "", ""));
    }

    @Test
    void constructorSucceedsWithValidDueDate(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        Assertions.assertEquals("2021-01-01", taskItem.date);
    }

    @Test
    void constructorSucceedsWithValidTitle(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        Assertions.assertEquals("0", taskItem.title);
    }

    @Test
    void editingDescriptionSucceedsWithExpectedValue(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        taskItem.setDescription("0");
        Assertions.assertEquals("0", taskItem.description);
    }

    @Test
    void editingDueDateFailsWithInvalidDateFormat(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        Assertions.assertThrows(IllegalArgumentException.class, () -> taskItem.setDate("01-01-2021"));
    }

    @Test
    void editingDueDateFailsWithInvalidYYYYMMDD(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        Assertions.assertThrows(IllegalArgumentException.class, () -> taskItem.setDate("00-00-0000"));
    }

    @Test
    void editingDueDateSucceedsWithExpectedValue(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        taskItem.setDate("2021-01-02");
        Assertions.assertEquals("2021-01-02", taskItem.date);
    }

    @Test
    void editingTitleFailsWithEmptyString(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        Assertions.assertThrows(IllegalArgumentException.class, () -> taskItem.setTitle(""));
    }

    @Test
    void editingTitleSucceedsWithExpectedValue(){
        TaskItem taskItem = new TaskItem("2021-01-01", "0", "");
        taskItem.setTitle("1");
        Assertions.assertEquals("1", taskItem.title);
    }
}
