package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_BE_RegisterUser extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public Neg_BE_RegisterUser(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties RegisterUserLocators = loader.getProperties("RegisterUserLocators.properties");
    
    By Users= By.xpath(RegisterUserLocators.getProperty("Users"));
    By AddUser=By.xpath(RegisterUserLocators.getProperty("AddUser"));
    By SaveBtn=By.xpath(RegisterUserLocators.getProperty("SaveBtn"));
    By ErrorMsg=By.xpath(RegisterUserLocators.getProperty("ErrorMsg"));
    
    public void locateUsers() throws InterruptedException {
        clickOnElement(driver.findElement(Users));
        clickOnElement(driver.findElement(AddUser));
    }
    public void clickSaveBtn()
    {
        clickOnElement(driver.findElement(SaveBtn));

    }


    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(ErrorMsg).getText();
        }

        return null;
    }



}
