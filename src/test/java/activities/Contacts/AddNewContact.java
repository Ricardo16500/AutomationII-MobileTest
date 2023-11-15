package activities.Contacts;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class AddNewContact {
    public Label googleAccount = new Label(By.xpath(
            "//android.widget.TextView[@text=\"Take a minute to add an account that will back up your contacts to Google.\"]"));

    public Button cancelBtn(String value){
        Button cancel = new Button(By.xpath("//android.widget.Button[@text='"+value+"']"));
        return cancel;
    }
    public TextBox dataNewContact(String value){
        TextBox data = new TextBox(By.xpath("//android.widget.EditText[@text='"+value+"']"));
        return data;
    }

    public Button saveBtn = new Button(By.id("com.android.contacts:id/editor_menu_save_button"));


}
