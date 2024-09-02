package pom.regression_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_ODM_ODC_FODC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties ODM_ODC_FODC = loader.getProperties("ODM_ODC_FODCLocators.properties");
    
    By OrganizationContact = By.xpath(ODM_ODC_FODC.getProperty("OrganizationContact"));
    By SubmitBtn = By.xpath(ODM_ODC_FODC.getProperty("SubmitBtn"));
    By VerifySave = By.xpath(ODM_ODC_FODC.getProperty("VerifySave"));
    public Neg_ODM_ODC_FODC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateCreateOrganizationContact() throws InterruptedException {
        WebElement clickableElement = BrowserManager.waitForElementToBeClickable(driver,  OrganizationContact, 10);
        if (clickableElement != null) {
            clickOnElement(clickableElement);


        }
        else
        {
            logStep("Failed to Locate or Click : Create Organization Contact Element");
        }
    }
    public void clickSubmit()throws InterruptedException
    {
        scrollDown(700);
        WebElement element1 = BrowserManager.waitForElementToBeClickable(driver,  SubmitBtn, 10);
        if (element1 != null) {
            clickOnElement(element1);


        }
        else
        {
            String msg="Failed to Locate or Click : SubmitBtn Element";
            logStep(msg);
            Assert.fail(msg);
        }
    }

    public String validateMessage(String msg) throws InterruptedException {
        switch (msg) {
            case "Error":
                Thread.sleep(3000);
                return driver.findElement(VerifySave).getText();
        }

        return null;
    }





}
