package testSuite;


import activities.Contacts.AddNewContact;
import activities.Contacts.ContactScreen;
import activities.Contacts.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewContactTest {
    MainScreen mainScreen = new MainScreen();
    AddNewContact addNewContact = new AddNewContact();
    ContactScreen contactScreen = new ContactScreen();

    @Test
    public void createNewContactTest(){
        List <String> labels = new ArrayList<>(Arrays.asList("First name","Last name", "Phone", "Email","CANCEL"));
        List <String> values = new ArrayList<>(Arrays.asList("Fabio", "Vaquera","76543210","exampleEmail@email.com"));
        //click +
        mainScreen.addButton.click();
        //if exist click cancel
        if(addNewContact.googleAccount.isControlDisplayed()){
            addNewContact.cancelBtn(labels.get(4)).click();
        }
        //set firstName
        addNewContact.dataNewContact(labels.get(0)).setText(values.get(0));
        //set lastName
        addNewContact.dataNewContact(labels.get(1)).setText(values.get(1));
        //set phone
        addNewContact.dataNewContact(labels.get(2)).setText(values.get(2));
        //set Email
        addNewContact.dataNewContact(labels.get(3)).setText(values.get(3));
        //click save
        addNewContact.saveBtn.click();
        //verify contact
        String fullNameExpected = values.get(0)+" "+values.get(1);
        String fullNameResult = contactScreen.getContactName(values.get(0),values.get(1)).getText();
        String emailResult = contactScreen.getContactEmail(values.get(3)).getText();
        //Asserts
        Assertions.assertEquals(fullNameExpected,fullNameResult,"EL CONTACTO NO SE CREO" );
        Assertions.assertEquals(values.get(3),emailResult,"EL CONTACTO NO SE CREO");
    }
    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }

}
