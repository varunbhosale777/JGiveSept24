package pom.smoke_test_BE;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
public class DM_AD_BAD extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public DM_AD_BAD(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties DM_AD_BAD = loader.getProperties("DM_AD_BADLocators.properties");
    
    String pageTitle = DM_AD_BAD.getProperty("pageTitle");
    By Components = By.xpath(DM_AD_BAD.getProperty("Components"));
    By JGive = By.xpath(DM_AD_BAD.getProperty("JGive"));
    By Donations = By.xpath(DM_AD_BAD.getProperty("Donations"));
    By NewBtn = By.xpath(DM_AD_BAD.getProperty("NewBtn"));
    By DonorTxtField = By.xpath(DM_AD_BAD.getProperty("DonorTxtField"));
    By SelectDonor = By.xpath(DM_AD_BAD.getProperty("SelectDonor"));
    By SelectCampaignBtn = By.xpath(DM_AD_BAD.getProperty("SelectCampaignBtn"));
    By Campaign1 = By.xpath(DM_AD_BAD.getProperty("Campaign1")); 
    By DonationAmount = By.xpath(DM_AD_BAD.getProperty("DonationAmount"));
    By SelectPayment1 = By.xpath(DM_AD_BAD.getProperty("SelectPayment1"));
    By SelectPayment2 = By.xpath(DM_AD_BAD.getProperty("SelectPayment2"));
    By SelectPayment3 = By.xpath(DM_AD_BAD.getProperty("SelectPayment3"));
    By SelectPayment4 = By.xpath(DM_AD_BAD.getProperty("SelectPayment4"));
    By DonationStatus = By.xpath(DM_AD_BAD.getProperty("DonationStatus"));
    By SaveDonation = By.xpath(DM_AD_BAD.getProperty("SaveDonation"));
    By SuccessMsg = By.xpath(DM_AD_BAD.getProperty("SuccessMsg"));
    By iFrame = By.xpath(DM_AD_BAD.getProperty("iFrame"));
    By CloseBtn = By.xpath(DM_AD_BAD.getProperty("CloseBtn"));
    
     
        
    public void locateDonatino() throws InterruptedException {

        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        WebElement element = driver.findElement(Donations);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void validateCorrectPage() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Donations"),"Error Locating");
    }
    public void clickNew()  {
        clickOnElement(driver.findElement(NewBtn));

    }
    public void enterDonorText(String text) throws InterruptedException{
    sendText(driver.findElement(DonorTxtField), text);
    Thread.sleep(3000);
    }
    public void selectDonor() {
        clickOnElement(driver.findElement(SelectDonor));

    }
    public void clickSelectCampaignBtn() {
    clickOnElement(driver.findElement(SelectCampaignBtn));

    }
    public void selectCampaign() throws InterruptedException {
        WebElement frame=driver.findElement(iFrame);
        driver.switchTo().frame(frame);
        
        List<WebElement> rows = driver.findElements(By.cssSelector("table.table-striped tbody tr"));
        
        for (WebElement row : rows) {
            
            WebElement campaignLink = row.findElement(By.cssSelector("td a.pointer"));
            String campaignName = campaignLink.getText().trim();
            
            if (campaignName.equals(CampaignTitle)) {
                clickOnElement(campaignLink);
                Thread.sleep(2000);
                driver.switchTo().defaultContent();
                break; 
            }
        }
    }


    public void selectDonationStatus() {
        WebElement status=driver.findElement(DonationStatus);
        Select dropdown=new Select(status);
        dropdown.selectByVisibleText("Confirmed");
    }
    public void clickSaveDonation() throws InterruptedException {
        clickOnElement(driver.findElement(SaveDonation));

    }


    public String validateMessage(String msg) throws InterruptedException {
        switch (msg) {
            case "Locate":
                Thread.sleep(2000);
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }
}
