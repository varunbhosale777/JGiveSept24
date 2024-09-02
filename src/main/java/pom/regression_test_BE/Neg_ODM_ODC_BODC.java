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
import java.util.Properties;
import java.util.logging.Logger;
public class Neg_ODM_ODC_BODC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public Neg_ODM_ODC_BODC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    private static final Logger LOGGER = LoggerUtil.getLogger();
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties ODM_ODC_BOD = loader.getProperties("ODM_ODC_BODCLocators.properties");

    By Components = By.xpath(ODM_ODC_BOD.getProperty("Components"));
    By JGive = By.xpath(ODM_ODC_BOD.getProperty("JGive"));
    By OrgDonors=By.xpath(ODM_ODC_BOD.getProperty("OrgDonors"));
    By NewBtn=By.xpath(ODM_ODC_BOD.getProperty("NewBtn"));
    By SaveAndCloseBtn = By.xpath(ODM_ODC_BOD.getProperty("SaveAndCloseBtn"));
    By SuccessMsg=By.xpath(ODM_ODC_BOD.getProperty("SuccessMsg"));
    
    public void locateOrgDonors() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        clickOnElement(driver.findElement(OrgDonors));
        logStep("Clicking ORG Donors");
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
