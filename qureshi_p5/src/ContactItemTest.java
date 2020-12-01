import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactItemTest {

    @Test
    void creationFailsWithAllBlankValues(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ContactItem("","","",""));
    }

    @Test
    void creationSucceedsWithBlankEmail(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "");
        Assertions.assertEquals("Davy", contactItem.first);
        Assertions.assertEquals("Jones", contactItem.last);
        Assertions.assertEquals("123-456-1234", contactItem.phone);
    }

    @Test
    void creationSucceedsWithBlankFirstName(){
        ContactItem contactItem = new ContactItem("", "Jones", "123-456-1234", "under@sea.org");
        Assertions.assertEquals("under@sea.org", contactItem.email);
        Assertions.assertEquals("Jones", contactItem.last);
        Assertions.assertEquals("123-456-1234", contactItem.phone);
    }

    @Test
    void creationSucceedsWithBlankLastName(){
        ContactItem contactItem = new ContactItem("Davy", "", "123-456-1234", "under@sea.org");
        Assertions.assertEquals("under@sea.org", contactItem.email);
        Assertions.assertEquals("Davy", contactItem.first);
        Assertions.assertEquals("123-456-1234", contactItem.phone);
    }

    @Test
    void creationSucceedsWithBlankPhone(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "", "under@sea.org");
        Assertions.assertEquals("Davy", contactItem.first);
        Assertions.assertEquals("Jones", contactItem.last);
        Assertions.assertEquals("under@sea.org", contactItem.email);
    }

    @Test
    void creationSucceedsWithNonBlankValues(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        Assertions.assertEquals("Davy", contactItem.first);
        Assertions.assertEquals("Jones", contactItem.last);
        Assertions.assertEquals("123-456-1234", contactItem.phone);
        Assertions.assertEquals("under@sea.org", contactItem.email);
    }

    @Test
    void editingFailsWithAllBlankValues(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactItem.Edit("", "", "", ""));
    }

    @Test
    void editingSucceedsWithBlankEmail(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        contactItem.Edit("Javy", "Dones", "123-456-1235", "");
        Assertions.assertEquals("Javy", contactItem.first);
        Assertions.assertEquals("Dones", contactItem.last);
        Assertions.assertEquals("123-456-1235", contactItem.phone);
        Assertions.assertEquals("under@sea.org", contactItem.email);
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        contactItem.Edit("", "Dones", "123-456-1235", "sea@under.org");
        Assertions.assertEquals("Davy", contactItem.first);
        Assertions.assertEquals("Dones", contactItem.last);
        Assertions.assertEquals("123-456-1235", contactItem.phone);
        Assertions.assertEquals("sea@under.org", contactItem.email);
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        contactItem.Edit("Javy", "", "123-456-1235", "sea@under.org");
        Assertions.assertEquals("Javy", contactItem.first);
        Assertions.assertEquals("Jones", contactItem.last);
        Assertions.assertEquals("123-456-1235", contactItem.phone);
        Assertions.assertEquals("sea@under.org", contactItem.email);
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        contactItem.Edit("Javy", "Dones", "", "sea@under.org");
        Assertions.assertEquals("Javy", contactItem.first);
        Assertions.assertEquals("Dones", contactItem.last);
        Assertions.assertEquals("123-456-1234", contactItem.phone);
        Assertions.assertEquals("sea@under.org", contactItem.email);
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactItem contactItem = new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org");
        contactItem.Edit("Javy", "Dones", "123-456-1235", "sea@under.org");
        Assertions.assertEquals("Javy", contactItem.first);
        Assertions.assertEquals("Dones", contactItem.last);
        Assertions.assertEquals("123-456-1235", contactItem.phone);
        Assertions.assertEquals("sea@under.org", contactItem.email);
    }

    @Test
    void testToString(){}
}
