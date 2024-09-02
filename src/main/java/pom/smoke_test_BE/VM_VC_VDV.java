package pom.smoke_test_BE;
import org.openqa.selenium.By;
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
public class VM_VC_VDV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public VM_VC_VDV(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties VDVLocators = loader.getProperties("VM_VC_VDVLocators.properties");

    By Components = By.xpath(VDVLocators.getProperty("Components"));
    By JGive = By.xpath(VDVLocators.getProperty("JGive"));
    By Vendors=By.xpath(VDVLocators.getProperty("Vendors"));
    By Sort=By.xpath(VDVLocators.getProperty("Sort"));
    By CheckBox01=By.xpath(VDVLocators.getProperty("CheckBox01"));
    By Actions=By.xpath(VDVLocators.getProperty("Actions"));
    By Unpublish=By.xpath(VDVLocators.getProperty("Unpublish"));
    By Publish=By.xpath(VDVLocators.getProperty("Publish"));
    By SuccessMessage=By.xpath(VDVLocators.getProperty("SuccessMessage"));
    By SearchBox=By.xpath(VDVLocators.getProperty("SearchBox"));
    By SearchBtn=By.xpath(VDVLocators.getProperty("SearchBtn"));
    By ActualVendorTitle=By.xpath(VDVLocators.getProperty("ActualVendorTitle"));
    By ClearSearchBtn=By.xpath(VDVLocators.getProperty("ClearSearchBtn"));
    By Fees1=By.xpath(VDVLocators.getProperty("Fees1"));
    By NewFeesBtn=By.xpath(VDVLocators.getProperty("NewFeesBtn"));
    By Currency=By.xpath(VDVLocators.getProperty("Currency"));
    By CurrencyText=By.xpath(VDVLocators.getProperty("CurrencyText"));
    By YenCurrency=By.xpath(VDVLocators.getProperty("YenCurrency"));
    By Commission=By.xpath(VDVLocators.getProperty("Commission"));
    By FlatCommision=By.xpath(VDVLocators.getProperty("FlatCommision"));
    By SaveAndClose=By.xpath(VDVLocators.getProperty("SaveAndClose"));
    By AlertMsg=By.xpath(VDVLocators.getProperty("AlertMsg"));
    
 
    public void locateVendors() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));

        Thread.sleep(2000);
        clickOnElement(driver.findElement(JGive));

        Thread.sleep(2000);
        clickOnElement(driver.findElement(Vendors));

        Thread.sleep(2000);
    }
    public void validateCorrectPage()
    {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive : Vendors"),"Error Locating");
    }

    public void clickCheckBox01()
    {
        clickOnElement(driver.findElement(CheckBox01));

    }
    public void clickActions()
    {
        clickOnElement(driver.findElement(Actions));

    }
    public void clickUnpublish()
    {
        clickOnElement(driver.findElement(Unpublish));

    }
    public void verifyUnpublish()
    {
        WebElement msg=driver.findElement(SuccessMessage);
        String text=msg.getText();
        Assert.assertTrue(text.contains("successfully unpublished"),"Error Locating");
    }
    public void clickPublish()
    {
        clickOnElement(driver.findElement(Publish));

    }
    public void verifyPublish()
    {
        WebElement msg=driver.findElement(SuccessMessage);
        String text = msg.getText();
        Assert.assertTrue(text.contains("successfully published"),"Error Locating");
    }
    public void enterSearchTitle(String text)
    {
        sendText(driver.findElement(SearchBox), text);
        logStep("Entering Vendor Title to Search");
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(SearchBtn));

        logStep("Clicking Search Button");
    }
    public void validateSearchTitle(String expectedTitle)
    {
        String actualTitle= driver.findElement(ActualVendorTitle).getText();
        Assert.assertEquals(actualTitle,expectedTitle);
        logStep("Validating Search Result for Title");
    }
    public void clickClearSearchBtn() throws InterruptedException
    {
        clickOnElement(driver.findElement(ClearSearchBtn));

        Thread.sleep(2000);
        logStep("Clearing Search");
    }
    public void clickFees1()
    {
        clickOnElement(driver.findElement(Fees1));

    }
    public void clickNew() throws InterruptedException
    {
        clickOnElement(driver.findElement(NewFeesBtn));
    }
    public void selectCurrency() throws InterruptedException
    {
        WebElement element=driver.findElement(Currency);
        Select dropdown=new Select(element);
        dropdown.selectByValue("JPY");
        logStep("Selecting Currency Yen");
    }
    public void enterPercentCommission(int per)
    {
        WebElement percentCommission = driver.findElement(Commission);
        percentCommission.clear();
        sendText(percentCommission, String.valueOf(per));



    }
    public void enterFlatCommission(int c)
    {
        WebElement flatCommission=driver.findElement(FlatCommision);
        flatCommission.clear();
        sendText(flatCommission, String.valueOf(c));



    }
    public void clickSave() throws InterruptedException {
        clickOnElement(driver.findElement(SaveAndClose));
        Thread.sleep(2000);
    }
    public String validateMessage(String msg) {
        switch (msg) {
            case "Locate":
                return driver.findElement(AlertMsg).getText();
        }

        return null;
    }

}

