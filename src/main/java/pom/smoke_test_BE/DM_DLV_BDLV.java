package pom.smoke_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
public class DM_DLV_BDLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public DM_DLV_BDLV(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }

    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties DM_DLV_BDLV = loader.getProperties("DM_DLV_BDLVLocators.properties");

    By Components = By.xpath(DM_DLV_BDLV.getProperty("Components"));
    By JGive = By.xpath(DM_DLV_BDLV.getProperty("JGive"));
    By Donations = By.xpath(DM_DLV_BDLV.getProperty("Donations"));
    By DonationID = By.xpath(DM_DLV_BDLV.getProperty("DonationID"));
    By Search = By.xpath(DM_DLV_BDLV.getProperty("Search"));
    By SearchBtn = By.xpath(DM_DLV_BDLV.getProperty("SearchBtn"));
    By SearchResult = By.xpath(DM_DLV_BDLV.getProperty("SearchResult"));
    By FilterOption = By.xpath(DM_DLV_BDLV.getProperty("FilterOption"));
    By CampaignType = By.xpath(DM_DLV_BDLV.getProperty("CampaignType"));
    By ApprovalStatus = By.xpath(DM_DLV_BDLV.getProperty("ApprovalStatus"));


    By DonorType = By.xpath(DM_DLV_BDLV.getProperty("DonorType"));
    By ClearBtn = By.xpath(DM_DLV_BDLV.getProperty("ClearBtn"));
    public static String DonationIDText=null;
    
     
       
    public void locateDonations() throws InterruptedException {

        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        WebElement element = driver.findElement(Donations);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void validateCorrectPage() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Donations"),"Error Locating");
    }
    public void getDonationIDText()  {
        DonationIDText =  driver.findElement(DonationID).getText();
    }
    public void enterDonationID() {
        sendText(driver.findElement(Search), DonationIDText);
    }
    public void clickSearch() {
        clickOnElement(driver.findElement(SearchBtn));

    }
    public void verifySearch() {
        String result = driver.findElement(SearchResult).getText();
        Assert.assertEquals(DonationIDText,result,"Search Result Not Matched");
    }
    public void clickFilterOptions() throws InterruptedException {
       clickOnElement(driver.findElement(FilterOption));

    }
    public void selectCampaignType(String text)
    {
        WebElement ctype= driver.findElement(CampaignType);
        Select dropdown=new Select(ctype);
        dropdown.selectByVisibleText(text);
    }
    public void selectApprovalStatus(String text)
    {
        WebElement astatus= driver.findElement(ApprovalStatus);
        Select dropdown=new Select(astatus);
        dropdown.selectByVisibleText(text);
    }
    public void selectDonorType(String text)
    {
        WebElement dtype= driver.findElement(DonorType);
        Select dropdown=new Select(dtype);
        dropdown.selectByVisibleText(text);
    }
    public void clickClear()
    {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
