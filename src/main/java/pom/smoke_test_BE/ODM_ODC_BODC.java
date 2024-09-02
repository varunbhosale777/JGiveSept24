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
public class ODM_ODC_BODC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public ODM_ODC_BODC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties ODM_ODC_BOD = loader.getProperties("ODM_ODC_BODCLocators.properties");

    By Components = By.xpath(ODM_ODC_BOD.getProperty("Components"));
    By JGive = By.xpath(ODM_ODC_BOD.getProperty("JGive"));
    By OrgDonors=By.xpath(ODM_ODC_BOD.getProperty("OrgDonors"));
    By NewBtn=By.xpath(ODM_ODC_BOD.getProperty("NewBtn"));
    By SelectVendor=By.xpath(ODM_ODC_BOD.getProperty("SelectVendor"));
    By OrgName=By.xpath(ODM_ODC_BOD.getProperty("OrgName"));
    By OrgWebsite=By.xpath(ODM_ODC_BOD.getProperty("OrgWebsite"));
    By OrgEmail=By.xpath(ODM_ODC_BOD.getProperty("OrgEmail"));
    By OrgContactNumber=By.xpath(ODM_ODC_BOD.getProperty("OrgContactNumber"));
    By OrgContactPerson=By.xpath(ODM_ODC_BOD.getProperty("OrgContactPerson"));
    By AddressTab=By.xpath(ODM_ODC_BOD.getProperty("AddressTab"));
    By Address1=By.xpath(ODM_ODC_BOD.getProperty("Address1"));
    By Address2=By.xpath(ODM_ODC_BOD.getProperty("Address2"));
    By Country=By.xpath(ODM_ODC_BOD.getProperty("Country"));
    By State=By.xpath(ODM_ODC_BOD.getProperty("State"));
    By City=By.xpath(ODM_ODC_BOD.getProperty("City"));
    By Zip=By.xpath(ODM_ODC_BOD.getProperty("Zip"));
    By Tax=By.xpath(ODM_ODC_BOD.getProperty("Tax"));
    By SaveAndCloseBtn = By.xpath(ODM_ODC_BOD.getProperty("SaveAndCloseBtn"));
    By SuccessMsg=By.xpath(ODM_ODC_BOD.getProperty("SuccessMsg"));
    
    
    public void locateOrgDonors() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        clickOnElement(driver.findElement(OrgDonors));
    }
    public void validateCorrectPage()
    {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Organization Donors"),"Error Locating");
    }
    public void clickNew() throws InterruptedException
    {
        clickOnElement(driver.findElement(NewBtn));

    }
    public void selectVendor(String text)
    {
        WebElement vendor=driver.findElement(SelectVendor);
        Select dropdown=new Select(vendor);
        dropdown.selectByVisibleText(text);
    }
    public void enterOrgName(String text)
    {
        sendText(driver.findElement(OrgName), text);
    }
    public void enterOrgWebsite(String text)
    {
        sendText(driver.findElement(OrgWebsite), text);
    }
    public void enterOrgEmail(String text)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
        sendText(driver.findElement(OrgEmail), text);
    }
    public void clickAddressTab() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-800)");
        clickOnElement(driver.findElement(AddressTab));

    }
    public void enterAddress1(String text)
    {
        sendText(driver.findElement(Address1), text);
    }
    public void enterAddress2(String text)
    {
        sendText(driver.findElement(Address2), text);
    }
    public void selectCountry(String text) throws InterruptedException {
        WebElement country=driver.findElement(Country);
        Select dropdown=new Select(country);
        dropdown.selectByVisibleText(text);
        Thread.sleep(1000);
    }
    public void selectState(String text) throws InterruptedException
    {
        WebElement state=driver.findElement(State);
        Select dropdown=new Select(state);
        dropdown.selectByVisibleText(text);
        Thread.sleep(1000);
    }
    public void selectCity(String text) throws InterruptedException
    {
        WebElement city=driver.findElement(City);
        Select dropdown=new Select(city);
        dropdown.selectByVisibleText(text);
        Thread.sleep(1000);
    }
    public void enterZip(long zip)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
        sendText(driver.findElement(Zip), String.valueOf(zip));
    }
    public void enterTax(long tax)
    {
        sendText(driver.findElement(Tax), String.valueOf(tax));
    }
    public void saveAndClose() throws InterruptedException
    {
        clickOnElement(driver.findElement(SaveAndCloseBtn));

        Thread.sleep(1000);
    }
    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }



}
