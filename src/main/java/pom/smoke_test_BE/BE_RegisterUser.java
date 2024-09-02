package pom.smoke_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
import java.util.logging.Logger;
public class BE_RegisterUser extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public BE_RegisterUser(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties RegisterUserLocators = loader.getProperties("RegisterUserLocators.properties");
    
    By Users= By.xpath(RegisterUserLocators.getProperty("Users"));
    By AddUser=By.xpath(RegisterUserLocators.getProperty("AddUser"));
    By Name=By.xpath(RegisterUserLocators.getProperty("Name"));
    By LoginUsername= By.xpath(RegisterUserLocators.getProperty("LoginUsername"));
    By LoginPassword=By.xpath(RegisterUserLocators.getProperty("LoginPassword"));
    By ConfirmPassword=By.xpath(RegisterUserLocators.getProperty("ConfirmPassword"));
    By Email= By.xpath(RegisterUserLocators.getProperty("Email"));
    By SaveAndClose=By.xpath(RegisterUserLocators.getProperty("SaveAndClose"));
    By SuccessMessage=By.xpath(RegisterUserLocators.getProperty("SuccessMessage"));
    
     
      
    public void locateUsers() throws InterruptedException {

        clickOnElement(driver.findElement(Users));
        clickOnElement(driver.findElement(AddUser));

    }
    public void enterName(String text)
    {
        sendText(driver.findElement(Name), text);
    }
    public void enterUsername(String text)
    {
        sendText(driver.findElement(LoginUsername), text);
    }
    public void enterPassword(String text)
    {
        sendText(driver.findElement(LoginPassword), text);
    }
    public void enterConfirmPassword(String text)
    {
        sendText(driver.findElement(ConfirmPassword), text);
    }
    public void enterEmail(String text)
    {
        sendText(driver.findElement(Email), text);
    }
    public void clickSaveAndClose()
    {
        clickOnElement(driver.findElement(SaveAndClose));

    }

    public Boolean validateWebElement(String element) {
        switch (element) {
            case "Save":
                return driver.findElement(SuccessMessage).isDisplayed();
        }

        return null;

    }
}
