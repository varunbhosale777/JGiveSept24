package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
public class Neg_CM_CC_BCC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public Neg_CM_CC_BCC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCCLocators = loader.getProperties("CM_CC_BCCLocators.properties");
    
    String pageTitle = BCCLocators.getProperty("pageTitle");
    By Components = By.xpath(BCCLocators.getProperty("Components"));
    By JGive = By.xpath(BCCLocators.getProperty("JGive"));
    By Campaigns = By.xpath(BCCLocators.getProperty("Campaigns"));
    By NewBtn = By.xpath(BCCLocators.getProperty("NewBtn"));
    By saveBtn = By.xpath(BCCLocators.getProperty("saveBtn"));
    By saveSuccessfulMSG = By.xpath(BCCLocators.getProperty("saveSuccessfulMSG"));
    
    public void locateCampaigns() throws InterruptedException {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        clickOnElement(driver.findElement(Campaigns));
        logStep("Clicking Campaigns");
    }
    
    public void validateCorrectPage() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, pageTitle, "Not Matched");
    }
    public void clickNew() throws InterruptedException {
        clickOnElement(driver.findElement(NewBtn));

    }
    public void clickSave() throws InterruptedException {
        clickOnElement(driver.findElement(saveBtn));

        Thread.sleep(2000);
    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(saveSuccessfulMSG).getText();
        }

        return null;
    }
}
