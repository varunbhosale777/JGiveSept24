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
public class Neg_VM_VC_BVC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public Neg_VM_VC_BVC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BVCLocators = loader.getProperties("VM_VC_BVCLocators.properties");
    
    String pageTitle = BVCLocators.getProperty("pageTitle");
    By Components = By.xpath(BVCLocators.getProperty("Components"));
    By JGive = By.xpath(BVCLocators.getProperty("JGive"));
    By Vendors=By.xpath(BVCLocators.getProperty("Vendors"));
    By NewBtn=By.xpath(BVCLocators.getProperty("NewBtn"));
    By SaveAndCloseBtn = By.xpath(BVCLocators.getProperty("SaveAndCloseBtn"));
    By SuccessMsg=By.xpath(BVCLocators.getProperty("SuccessMsg"));
    
    public void locateVendors() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        WebElement element = driver.findElement(Vendors);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void validateCorrectPage()
    {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, pageTitle, "Not Matched");
    }
    public void clickNew() throws InterruptedException
    {
        clickOnElement(driver.findElement(NewBtn));

    }
    public void saveAndClose() throws InterruptedException
    {
        clickOnElement(driver.findElement(SaveAndCloseBtn));
        Thread.sleep(1000);
    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }

}
