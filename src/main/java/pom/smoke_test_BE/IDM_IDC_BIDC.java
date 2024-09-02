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
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
public class IDM_IDC_BIDC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public IDM_IDC_BIDC(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }

    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties IDM_IDC_BIDC = loader.getProperties("IDM_IDC_BIDCLocators.properties");

    By Components = By.xpath(IDM_IDC_BIDC.getProperty("Components"));
    By JGive = By.xpath(IDM_IDC_BIDC.getProperty("JGive"));
    By IndividualDonors=By.xpath(IDM_IDC_BIDC.getProperty("IndividualDonors"));
    By NewBtn=By.xpath(IDM_IDC_BIDC.getProperty("NewBtn"));
    By SelectVendor=By.xpath(IDM_IDC_BIDC.getProperty("SelectVendor"));
    By FirstName=By.xpath(IDM_IDC_BIDC.getProperty("FirstName"));
    By Email=By.xpath(IDM_IDC_BIDC.getProperty("Email"));
    By Contact=By.xpath(IDM_IDC_BIDC.getProperty("Contact"));
    By AddressTab=By.xpath(IDM_IDC_BIDC.getProperty("AddressTab"));
    By Address1=By.xpath(IDM_IDC_BIDC.getProperty("Address1"));
    By Address2=By.xpath(IDM_IDC_BIDC.getProperty("Address2"));
    By Country=By.xpath(IDM_IDC_BIDC.getProperty("Country"));
    By State=By.xpath(IDM_IDC_BIDC.getProperty("State"));
    By City=By.xpath(IDM_IDC_BIDC.getProperty("City"));
    By Zip=By.xpath(IDM_IDC_BIDC.getProperty("Zip"));
    By Tax=By.xpath(IDM_IDC_BIDC.getProperty("Tax"));
    By SaveAndCloseBtn = By.xpath(IDM_IDC_BIDC.getProperty("SaveAndCloseBtn"));
    By SuccessMsg=By.xpath(IDM_IDC_BIDC.getProperty("SuccessMsg"));
    
   
    public void locateIndividualDonors() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        clickOnElement(driver.findElement(IndividualDonors));

    }
    public void validateCorrectPage()
    {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Individual Donors"),"Error Locating");
    }
    public void clickNew()
    {
        clickOnElement(driver.findElement(NewBtn));

    }
    public void selectVendor(String text)
    {
        WebElement vendor=driver.findElement(SelectVendor);
        Select dropdown=new Select(vendor);
        dropdown.selectByVisibleText(text);
    }
    public void enterFirstName(String text)
    {
        sendText(driver.findElement(FirstName), text);
    }
    public void enterEmail(String text)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,500)");
        sendText(driver.findElement(Email), text);
    }
    public void enterContact(long number)
    {
        sendText(driver.findElement(Contact), String.valueOf(number));
    }
    public void clickAddressTab() throws InterruptedException
    {

        WebElement element = driver.findElement(AddressTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

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
