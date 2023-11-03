package control;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends Control{
    public TextBox(By Locator) {
        super(Locator);
    }
    public void setText(String text){
        findControl();
        control.sendKeys(text);
    }
    public void cleanSetText(String value){
        findControl();
        control.clear();
        control.sendKeys(value);
    }
    public void setTextEnter(String value){
        findControl();
        control.sendKeys(value+ Keys.ENTER);
    }
}
