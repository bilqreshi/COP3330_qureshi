import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactListTest {

    @Test
    void addingItemsIncreasesSize(){
        ContactList contactList = new ContactList("name");
        int size = contactList.contactItems.size();
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        Assertions.assertEquals(size+1, contactList.contactItems.size());
    }

    @Test
    void editingItemsFailsWithAllBlankValues(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> contactList.Edit(0, "", "", "", ""));
    }

    @Test
    void editingItemsFailsWithInvalidIndex(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> contactList.Edit(2, "Javy", "Dones", "123-456-1235", "sea@under.org"));
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        contactList.Edit(0, "", "Dones", "123-456-1235", "sea@under.org");
        Assertions.assertEquals("Davy", contactList.contactItems.get(0).first);
        Assertions.assertEquals("Dones", contactList.contactItems.get(0).last);
        Assertions.assertEquals("123-456-1235", contactList.contactItems.get(0).phone);
        Assertions.assertEquals("sea@under.org", contactList.contactItems.get(0).email);
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        contactList.Edit(0, "Javy", "", "123-456-1235", "sea@under.org");
        Assertions.assertEquals("Javy", contactList.contactItems.get(0).first);
        Assertions.assertEquals("Jones", contactList.contactItems.get(0).last);
        Assertions.assertEquals("123-456-1235", contactList.contactItems.get(0).phone);
        Assertions.assertEquals("sea@under.org", contactList.contactItems.get(0).email);
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        contactList.Edit(0, "Javy", "Dones", "", "sea@under.org");
        Assertions.assertEquals("Javy", contactList.contactItems.get(0).first);
        Assertions.assertEquals("Dones", contactList.contactItems.get(0).last);
        Assertions.assertEquals("123-456-1234", contactList.contactItems.get(0).phone);
        Assertions.assertEquals("sea@under.org", contactList.contactItems.get(0).email);
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        contactList.Edit(0, "Javy", "Dones", "123-456-1235", "sea@under.org");
        Assertions.assertEquals("Javy", contactList.contactItems.get(0).first);
        Assertions.assertEquals("Dones", contactList.contactItems.get(0).last);
        Assertions.assertEquals("123-456-1235", contactList.contactItems.get(0).phone);
        Assertions.assertEquals("sea@under.org", contactList.contactItems.get(0).email);
    }

    @Test
    void newListIsEmpty(){
        ContactList contactList = new ContactList("name");
        Assertions.assertTrue(contactList.contactItems.isEmpty());
    }

    @Test
    void removingItemsDecreasesSize(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("", "Jones", "123-456-1234", "under@sea.org"));
        int size = contactList.contactItems.size();
        contactList.RemoveItem(0);
        Assertions.assertEquals(size-1, contactList.contactItems.size());
    }

    @Test
    void removingItemsFailsWithInvalidIndex(){
        ContactList contactList = new ContactList("name");
        contactList.AddItem(new ContactItem("", "Jones", "123-456-1234", "under@sea.org"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> contactList.RemoveItem(2));
    }

    @Test
    void savedContactListCanBeLoaded(){
        ContactList contactList = new ContactList("save");
        contactList.AddItem(new ContactItem("Davy", "Jones", "123-456-1234", "under@sea.org"));
        contactList.AddItem(new ContactItem("Javy", "Dones", "123-456-1235", "sea@under.org"));
        contactList.Save("test");
        ContactList loaded = ContactList.Load("test");
        Assertions.assertEquals("Davy", loaded.contactItems.get(0).first);
        Assertions.assertEquals("Jones", loaded.contactItems.get(0).last);
        Assertions.assertEquals("123-456-1234", loaded.contactItems.get(0).phone);
        Assertions.assertEquals("under@sea.org", loaded.contactItems.get(0).email);
        Assertions.assertEquals("Javy", loaded.contactItems.get(1).first);
        Assertions.assertEquals("Dones", loaded.contactItems.get(1).last);
        Assertions.assertEquals("123-456-1235", loaded.contactItems.get(1).phone);
        Assertions.assertEquals("sea@under.org", loaded.contactItems.get(1).email);
    }
}
