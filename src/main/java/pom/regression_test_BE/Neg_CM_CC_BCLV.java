package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_CM_CC_BCLV extends BrowserManager {
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/BE/";
    public Neg_CM_CC_BCLV(WebDriver driver)
    {
        BrowserManager.driver=driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCLVLocators = loader.getProperties("CM_CC_BCLVLocators.properties");
    
    String pageTitle = BCLVLocators.getProperty("JgivepageTitle");
    By Components=By.xpath(BCLVLocators.getProperty("Components"));
    By JGive=By.xpath(BCLVLocators.getProperty("JGive"));
    By Campaigns=By.xpath(BCLVLocators.getProperty("Campaigns"));
    By searchCampaign=By.id(BCLVLocators.getProperty("searchCampaign"));
    By searchBtn=By.xpath(BCLVLocators.getProperty("searchBtn"));
    By ErrorMsg=By.xpath(BCLVLocators.getProperty("ErrorMsg"));
    By ClearBtn=By.xpath(BCLVLocators.getProperty("clearSearchBtn"));
    
    public void locateCampaigns() throws InterruptedException {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        clickOnElement(driver.findElement(Campaigns));
        logStep("Clicking Campaigns");
    }
    public void validateCorrectPage()  {
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,pageTitle,"Not Matched");
    }
    public void enterSearchTitle()
    {
        sendText(driver.findElement(searchCampaign), "ABC#1");
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(searchBtn));

    }
    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(ErrorMsg).getText();
        }

        return null;
    }
    public void clickClearBtn() {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
