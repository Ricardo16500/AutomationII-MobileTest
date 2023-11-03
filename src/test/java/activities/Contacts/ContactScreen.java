package activities.Contacts;

import control.Label;
import org.openqa.selenium.By;

public class ContactScreen {

    public Label getContactName(String firstName, String lastName){
        Label fullName = new Label(By.xpath("//android.widget.TextView[@text='"+firstName+" "+lastName+"']"));
        return fullName;
    }
    public Label getContactEmail(String email){
        Label emailContact = new Label(By.xpath("//android.widget.TextView[@text='"+email+"']"));
        return emailContact;
    }

}
