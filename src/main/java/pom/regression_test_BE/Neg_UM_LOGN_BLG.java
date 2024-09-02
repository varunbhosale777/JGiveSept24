package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
import java.util.logging.Logger;
public class Neg_UM_LOGN_BLG extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BE_LoginLocators = loader.getProperties("BE_LoginLocators.properties");
    
    By ErrorMsg = By.xpath(BE_LoginLocators.getProperty("ErrorMsg"));
    By loginBtn = By.id(BE_LoginLocators.getProperty("loginBtn"));
    public Neg_UM_LOGN_BLG(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    
    public void loginBtn() {
        clickOnElement(driver.findElement(loginBtn));

    }
    

    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(ErrorMsg).getText();
        }

        return null;
    }

}
