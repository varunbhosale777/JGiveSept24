package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_CM_CTC_BCTC extends BrowserManager {
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/BE/";
    public Neg_CM_CTC_BCTC(WebDriver driver)
    {
        BrowserManager.driver=driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCTCLocators = loader.getProperties("CM_CTC_BCTCLocators.properties");
    
    By Components=By.xpath(BCTCLocators.getProperty("Components"));
    By JGive=By.xpath(BCTCLocators.getProperty("JGive"));
    By Categories=By.xpath(BCTCLocators.getProperty("Categories"));
    By NewBtn=By.xpath(BCTCLocators.getProperty("NewBtn"));
    By saveAndClose=By.xpath(BCTCLocators.getProperty("saveAndClose"));
    By saveSuccessMessage=By.xpath(BCTCLocators.getProperty("saveSuccessMessage"));
    
    public void locateCategories() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        clickOnElement(driver.findElement(Categories));
        logStep("Clicking Categories");
    }
    public void clickNew()
    {
        clickOnElement(driver.findElement(NewBtn));

    }
    public void clickSave(){
        clickOnElement(driver.findElement(saveAndClose));

    }
    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(saveSuccessMessage).getText();
        }

        return null;
    }

}
