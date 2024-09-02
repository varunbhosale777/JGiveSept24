package pom.regression_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.util.Properties;
public class Neg_CM_CC_FCC extends BrowserManager {
    
    static String locatorsPath=System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    static
    {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties CM_CC_FCCLocators = loader.getProperties("CM_CC_FCCLocators.properties");
    
    By CreateCampaign = By.xpath(CM_CC_FCCLocators.getProperty("CreateCampaign"));
    By CampaignTitle = By.xpath(CM_CC_FCCLocators.getProperty("CampaignTitle"));
    By FormError = By.xpath(CM_CC_FCCLocators.getProperty("FormError"));
    By EndDate = By.xpath(CM_CC_FCCLocators.getProperty("EndDate"));
    By SubmitButton = By.xpath(CM_CC_FCCLocators.getProperty("SubmitButton"));
    By SuccessMsgForCampaign = By.xpath(CM_CC_FCCLocators.getProperty("SuccessMsgForCampaign"));
    public Neg_CM_CC_FCC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateCreateCampaign()
    {
        clickOnElement(driver.findElement(CreateCampaign));

    }
    public void clickSubmit() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(2000);
        clickOnElement(driver.findElement(SubmitButton));

        Thread.sleep(3000);
    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(SuccessMsgForCampaign).getText();
        }

        return null;
    }



}
