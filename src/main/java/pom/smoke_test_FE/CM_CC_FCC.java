package pom.smoke_test_FE;
import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.util.Date;
import java.util.Properties;
public class CM_CC_FCC extends BrowserManager {
   
    static String locatorsPath=System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    static
    {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties CM_CC_FCCLocators = loader.getProperties("CM_CC_FCCLocators.properties");
    
    By CreateCampaign = By.xpath(CM_CC_FCCLocators.getProperty("CreateCampaign"));
    By CampaignTitle = By.xpath(CM_CC_FCCLocators.getProperty("CampaignTitle"));
    By StartDate = By.xpath(CM_CC_FCCLocators.getProperty("StartDate"));
    By EndDate = By.xpath(CM_CC_FCCLocators.getProperty("EndDate"));
    By UploadImage=By.xpath(CM_CC_FCCLocators.getProperty("UploadImage"));
    By OrgIndType = By.xpath(CM_CC_FCCLocators.getProperty("OrgIndType"));
    By GoalAmount = By.xpath(CM_CC_FCCLocators.getProperty("GoalAmount"));
    By MinAmount = By.xpath(CM_CC_FCCLocators.getProperty("MinAmount"));
    By MaxDonation = By.xpath(CM_CC_FCCLocators.getProperty("MaxDonation"));
    By AddGiveBack = By.xpath(CM_CC_FCCLocators.getProperty("AddGiveBack"));
    By GiveBackTitle = By.xpath(CM_CC_FCCLocators.getProperty("GiveBackTitle"));
    By MinGivebackAmount = By.xpath(CM_CC_FCCLocators.getProperty("MinGivebackAmount"));
    By TotalGivebackAmount = By.xpath(CM_CC_FCCLocators.getProperty("TotalGivebackAmount"));
    By SubmitButton = By.xpath(CM_CC_FCCLocators.getProperty("SubmitButton"));
    By SuccessMsgForCampaign = By.xpath(CM_CC_FCCLocators.getProperty("SuccessMsgForCampaign"));
    public CM_CC_FCC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateCreateCampaign()
    {
        clickOnElement(driver.findElement(CreateCampaign));

    }
    public void enterCampaignTitle()
    {
        sendText(driver.findElement(CampaignTitle), BrowserManager.CampaignTitle);
    }
    public void enterStartDate()
    {
        WebElement element=driver.findElement(StartDate);
        element.clear();
        sendText(element, "2024-06-26 11:43");
    }
    public void enterEndDate()
    {
        WebElement element=driver.findElement(EndDate);
        element.clear();
        sendText(element, "2034-06-26 11:43");
    }
    public void uploadImage()
    {
        String imagePath = "src/test/java/test/resources/media/image1.jpg";
        File file = new File(imagePath);
        String absPath = file.getAbsolutePath();
        sendText(driver.findElement(UploadImage), absPath);
    }
    public void selectOrgIndType()
    {
        scrollDown(500);
        WebElement element=driver.findElement(OrgIndType);
        Select dropdown=new Select(element);
        dropdown.selectByValue("individuals");
    }
    public void enterGoalAmount()
    {
        WebElement element = driver.findElement(GoalAmount);
        element.clear();
        sendText(element, "1200000");
    }
    public void enterMinDonationAmount()
    {
        WebElement element = driver.findElement(MinAmount);
        element.clear();
        sendText(element, "100");
    }
    public void enterMaxDonationAmount()
    {
        WebElement element = driver.findElement(MaxDonation);
        element.clear();
        sendText(element, "1000");
    }
    public void clickAddGiveback() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(2000);
        WebElement element = driver.findElement(AddGiveBack);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void enterGivebackTitle() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(2000);
        sendText(driver.findElement(GiveBackTitle), BrowserManager.generateGivebackTitle());

    }
    public void enterMinGivebackAmount() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(3000);
        WebElement element = driver.findElement(MinGivebackAmount);
        element.clear();
        sendText(element, "100");
    }
    public void enterTotalGivebackAmount() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(3000);
        WebElement element = driver.findElement(TotalGivebackAmount);
        element.clear();
        sendText(element, "10");
    }
    public void clickSubmit() throws InterruptedException {
        scrollToBottom();
        clickOnElement(driver.findElement(SubmitButton));
        Thread.sleep(3000);
    }

    public Boolean validateWebElement(String element) {
        switch (element) {
            case "Save":
                return driver.findElement(SuccessMsgForCampaign).isDisplayed();
        }

        return null;

    }



}
