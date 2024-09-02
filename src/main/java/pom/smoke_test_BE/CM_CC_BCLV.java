package pom.smoke_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class CM_CC_BCLV extends BrowserManager{
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/BE/";
    public CM_CC_BCLV(WebDriver driver)
   {
        this.driver=driver;
   }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCLVLocators = loader.getProperties("CM_CC_BCLVLocators.properties");

    By Components=By.xpath(BCLVLocators.getProperty("Components"));
    By JGive=By.xpath(BCLVLocators.getProperty("JGive"));
    By Campaigns=By.xpath(BCLVLocators.getProperty("Campaigns"));
    By searchCampaign=By.id(BCLVLocators.getProperty("searchCampaign"));
    By searchBtn=By.xpath(BCLVLocators.getProperty("searchBtn"));
    By clearSearchBtn=By.xpath(BCLVLocators.getProperty("clearSearchBtn"));
    By campaignTitle=By.xpath(BCLVLocators.getProperty("actualCampaignTitle"));
    By statusFilter=By.id(BCLVLocators.getProperty("statusFilter"));
    By typeFilter=By.id(BCLVLocators.getProperty("typeFilter"));
    By org_ind_type=By.id(BCLVLocators.getProperty("org_ind_type"));
    By categoryFilter=By.name(BCLVLocators.getProperty("categoryFilter"));
    
     
       
    public void locateCampaigns() throws InterruptedException {
            clickOnElement(driver.findElement(Components));
            clickOnElement(driver.findElement(JGive));
            clickOnElement(driver.findElement(Campaigns));
    }
        public void validateCorrectPage()  {
            String actualTitle=driver.getTitle();
            Assert.assertTrue(actualTitle.contains("JGive: Campaigns"),"Error Locating");
    }
    public void enterSearchTitle(String text)
    {
        sendText(driver.findElement(searchCampaign), text);
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(searchBtn));

    }
    public void validateSearch(String expectedTitle)
    {
        String actualTitle= driver.findElement(campaignTitle).getText();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    public void clearSearchBtn()
    {
        clickOnElement(driver.findElement(clearSearchBtn));

    }
    public void select_statusFilter(String text) {
        WebElement element = driver.findElement(statusFilter);
        Select dropdown1 = new Select(element);
        dropdown1.selectByVisibleText(text);
    }
    public void select_typeFilter(String text) {
        WebElement element = driver.findElement(typeFilter);
        Select dropdown1 = new Select(element);
        dropdown1.selectByVisibleText(text);
    }
    public void select_org_ind_type(String text) {
        WebElement element = driver.findElement(org_ind_type);
        Select dropdown1 = new Select(element);
        dropdown1.selectByVisibleText(text);
    }
    public void select_categoryFilter(String text) {
        WebElement element = driver.findElement(categoryFilter);
        Select dropdown1 = new Select(element);
        dropdown1.selectByVisibleText(text);
    }


    public String validateMessage(String msg) {
        switch (msg) {
            case "Locate":
                return driver.findElement(campaignTitle).getText();
        }

        return null;
    }
}
