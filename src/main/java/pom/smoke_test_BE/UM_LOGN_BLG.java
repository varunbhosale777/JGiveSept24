package pom.smoke_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
public class UM_LOGN_BLG extends BrowserManager {
    
    public static final Logger LOGGER = LoggerUtil.getLogger();
    public static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BE_LoginLocators = loader.getProperties("BE_LoginLocators.properties");
    
    By username = By.id(BE_LoginLocators.getProperty("username"));
    By password = By.id(BE_LoginLocators.getProperty("password"));
    By loginBtn = By.id(BE_LoginLocators.getProperty("loginBtn"));
    String pageTitle = BE_LoginLocators.getProperty("pageTitle");
    public UM_LOGN_BLG(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
  
    
    public void username(String un) {
        sendText(driver.findElement(username), un);
    }
    
    public void password(String pw) {
        sendText(driver.findElement(password), pw);
    }
    
    public void loginBtn() {
        clickOnElement(driver.findElement(loginBtn));

    }
    
    public void validateLogin() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Home Dashboard"),"Error Locating");
        logStep("Validating Login");
    }
    
    public void BEcommonLogin(String un, String pw) {
        try {
            LOGGER.info("Executing common login ...");
            openBEUrl();
            username(un);
            password(pw);
            loginBtn();
            logStep("Common Log in successful.");
        } catch (Exception e) {
            LoggerUtil.logException(e, "Exception occurred during login.");
        }
    }
}
