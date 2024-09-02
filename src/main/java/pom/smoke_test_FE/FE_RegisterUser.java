package pom.smoke_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
import java.util.logging.Logger;
public class FE_RegisterUser extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    public FE_RegisterUser(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }

    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties RegisterUserLocators = loader.getProperties("FE_RegisterUserLocators.properties");
    
    By RegisterMenu= By.xpath(RegisterUserLocators.getProperty("RegisterMenu"));
    By UsernameTxtField=By.xpath(RegisterUserLocators.getProperty("UsernameTxtField"));
    By UserEmailTxtField=By.xpath(RegisterUserLocators.getProperty("UserEmailTxtField"));
    By ConfirmUserEmailTxtField= By.xpath(RegisterUserLocators.getProperty("ConfirmUserEmailTxtField"));
    By SignupBtn=By.xpath(RegisterUserLocators.getProperty("SignupBtn"));
    By SuccessMsg=By.xpath(RegisterUserLocators.getProperty("SuccessMsg"));
    
    public void locateRegisterMenu() throws InterruptedException {
        clickOnElement(driver.findElement(RegisterMenu));

    }
    public void enterUsername(String text)
    {
        sendText(driver.findElement(UsernameTxtField), text);
    }
    public void enterEmail(String text)
    {
        sendText(driver.findElement(UserEmailTxtField), text);
    }
    public void enterConfirmEmail(String text)
    {
        sendText(driver.findElement(ConfirmUserEmailTxtField), text);
    }
    public void clickSignup()
    {
        WebElement element = driver.findElement(SignupBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }



    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }




}
