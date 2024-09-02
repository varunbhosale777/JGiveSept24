package pom.smoke_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class BE_Publish_Campaign extends BrowserManager {
    
    static String locatorsPath=System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    static
    {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BE_Publish_Campaign = loader.getProperties("BE_Publish_CampaignLocators.properties");
    
    By Components = By.xpath(BE_Publish_Campaign.getProperty("Components"));
    By JGive = By.xpath(BE_Publish_Campaign.getProperty("JGive"));
    By Campaigns = By.xpath(BE_Publish_Campaign.getProperty("Campaigns"));
    By Chckbox1 = By.xpath(BE_Publish_Campaign.getProperty("Chckbox1"));
    By Actions=By.xpath(BE_Publish_Campaign.getProperty("Actions"));
    By Publish = By.xpath(BE_Publish_Campaign.getProperty("Publish"));
    By SuccessMsg = By.xpath(BE_Publish_Campaign.getProperty("SuccessMsg"));
    public BE_Publish_Campaign(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateCampaigns() throws InterruptedException {
        Thread.sleep(3000);
        clickOnElement(driver.findElement(Components));

        Thread.sleep(3000);
        clickOnElement(driver.findElement(JGive));

        Thread.sleep(3000);
        clickOnElement(driver.findElement(Campaigns));

        Thread.sleep(3000);
    }
    public void clickCheckbox1()
    {
        clickOnElement(driver.findElement(Chckbox1));

    }
    public void clickActions() throws InterruptedException {
        clickOnElement(driver.findElement(Actions));

        Thread.sleep(2000);
    }
    public void clickPublish() throws InterruptedException {
        clickOnElement(driver.findElement(Publish));

        Thread.sleep(2000);
    }

    public String validateMessage(String msg) {
        switch(msg) {
            case "Save":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }
}
