package pom.regression_test_BE;
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
public class Neg_VM_VC_VDV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public Neg_VM_VC_VDV(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties VDVLocators = loader.getProperties("VM_VC_VDVLocators.properties");
    
    By Components = By.xpath(VDVLocators.getProperty("Components"));
    By JGive = By.xpath(VDVLocators.getProperty("JGive"));
    By Vendors=By.xpath(VDVLocators.getProperty("Vendors"));
    By SearchBox=By.xpath(VDVLocators.getProperty("SearchBox"));
    By SearchBtn=By.xpath(VDVLocators.getProperty("SearchBtn"));
    By ErrorMsg=By.xpath(VDVLocators.getProperty("ErrorMsg"));
    By ClearSearchBtn=By.xpath(VDVLocators.getProperty("ClearSearchBtn"));
    
    public void locateVendors() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        WebElement element = driver.findElement(Vendors);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void enterSearchTitle()
    {
        sendText(driver.findElement(SearchBox), "abc#123");
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(SearchBtn));

    }
    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(ErrorMsg).getText();
        }

        return null;
    }


    public void clickClearBtn()
    {
        clickOnElement(driver.findElement(ClearSearchBtn));

    }
}
