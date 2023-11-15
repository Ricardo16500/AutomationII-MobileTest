import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BassicTest {
    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","Modulo4");
        config.setCapability("platformVersion","9.0");
        config.setCapability("appPackage","com.android.contacts");
        config.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
        // implicit / explicit / fluent
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void verifyCreateContactTest() throws InterruptedException {
        String firstName = "user";
        String lastName = "test";
        String phone= "76543210";
        String email="userTest@test.com";
        //click +
        mobile.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
        //if exist click cancel
        if (mobile.findElement(By.xpath(
                "//android.widget.TextView[@text=\"Take a minute to add an account that will back up your contacts to Google.\"]")).isDisplayed()){
            mobile.findElement(By.xpath("//android.widget.Button[@text=\"CANCEL\"]")).click();
        }
        //set first name
        mobile.findElement(By.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys(firstName);
        //set last name
        mobile.findElement(By.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys(lastName);
        //set phone
        mobile.findElement(By.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys(phone);
        //set email
        mobile.findElement(By.xpath("//android.widget.EditText[@text=\"Email\"]")).sendKeys(email);
        //click save
        mobile.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
        //verification
        Thread.sleep(5000);
        String result = mobile.findElement(By.id("com.android.contacts:id/large_title")).getText();
        Assertions.assertEquals(firstName+" "+lastName,result, "El contacto no se creo");


    }
    @AfterEach
    public void closeApp(){
        mobile.quit();
    }


}
