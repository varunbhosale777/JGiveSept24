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
public class Neg_ODM_ODC_BODLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public Neg_ODM_ODC_BODLV(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BODLV = loader.getProperties("ODM_ODC_BODLVLocators.properties");
    
    By Components = By.xpath(BODLV.getProperty("Components"));
    By JGive = By.xpath(BODLV.getProperty("JGive"));
    By OrgDonors=By.xpath(BODLV.getProperty("OrgDonors"));
    By SearchTxtBox=By.xpath(BODLV.getProperty("SearchTxtBox"));
    By SearchBtn=By.xpath(BODLV.getProperty("SearchBtn"));
    By ErrorMsg=By.xpath(BODLV.getProperty("ErrorMsg"));
    By ClearBtn=By.xpath(BODLV.getProperty("ClearBtn"));
    
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
    public void enterSearchQuery()
    {
        sendText(driver.findElement(SearchTxtBox), "abc#1");
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(SearchBtn));

    }
     public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                waitFor(10);
                return driver.findElement(ErrorMsg).getText();
        }

        return null;
    }
    public void clickClearBtn()
    {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
