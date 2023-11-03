package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class Control {
    protected By Locator;
    protected WebElement control;
    public Control(By Locator){
        this.Locator = Locator;
    }
    public void findControl(){
        this.control = Session.getSession().getDevice().findElement(this.Locator);
    }
    public void click(){
        findControl();
        control.click();
    }
    public String getText(){
        findControl();
        return control.getText();
    }
    public Boolean isControlDisplayed(){
        try{
            findControl();
            return control.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
