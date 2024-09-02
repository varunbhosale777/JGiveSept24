package pom.smoke_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.util.Properties;
public class IDM_IDC_FAID extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties IDM_IDC_FAID = loader.getProperties("IDM_IDC_FAIDLocators.properties");
    
    By IndividualContact = By.xpath(IDM_IDC_FAID.getProperty("IndividualContact"));
    By IndividualContactFirstName = By.xpath(IDM_IDC_FAID.getProperty("IndividualContactFirstName"));
    By IndividualContactLasttName = By.xpath(IDM_IDC_FAID.getProperty("IndividualContactLasttName"));
    By IndividualContactEmail = By.xpath(IDM_IDC_FAID.getProperty("IndividualContactEmail"));
    By IndividualContactPhone = By.xpath(IDM_IDC_FAID.getProperty("IndividualContactPhone"));
    By IndividualAddressTab = By.xpath(IDM_IDC_FAID.getProperty("IndividualAddressTab"));
    By IndividualAddress1 = By.xpath(IDM_IDC_FAID.getProperty("IndividualAddress1"));
    By IndividualAddress2 = By.xpath(IDM_IDC_FAID.getProperty("IndividualAddress2"));
    By SelectCountryOption = By.xpath(IDM_IDC_FAID.getProperty("SelectCountryOption"));
    By SelectRegionOption = By.xpath(IDM_IDC_FAID.getProperty("SelectRegionOption"));
    By SelectCityOption = By.xpath(IDM_IDC_FAID.getProperty("SelectCityOption"));
    By ZipCode = By.xpath(IDM_IDC_FAID.getProperty("ZipCode"));
    By SubmitBtn = By.xpath(IDM_IDC_FAID.getProperty("SubmitBtn"));
    By VerifySave = By.xpath(IDM_IDC_FAID.getProperty("VerifySave"));
    public IDM_IDC_FAID(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateCreateIndividualContact() throws InterruptedException {
        clickOnElement(driver.findElement(IndividualContact));
    }
    public void enterName()
    {
        WebElement name = driver.findElement(IndividualContactFirstName);
        name.clear();
        sendText(name, BrowserManager.IND_Donor);


    }
    public void enterEmail()
    {
        sendText(driver.findElement(IndividualContactEmail), BrowserManager.Email);
    }
    public void enterPhoneNumber()
    {
        sendText(driver.findElement(IndividualContactPhone), String.valueOf(BrowserManager.Phone));
    }
    public void clickAddressTab()
    {
        clickOnElement(driver.findElement(IndividualAddressTab));

    }
    public void enterAddress()
    {
        sendText(driver.findElement(IndividualAddress1), BrowserManager.Address1);
        sendText(driver.findElement(IndividualAddress2), BrowserManager.Address2);
    }
    public void selectCountry() throws InterruptedException
    {
        scrollDown(500);
        Thread.sleep(3000);
        WebElement element=driver.findElement(SelectCountryOption);
        Select dropdown=new Select(element);
        dropdown.selectByValue("99");
    }
    public void selectRegion() throws InterruptedException
    {
        scrollDown(500);
        WebElement element=driver.findElement(SelectRegionOption);
        Select dropdown=new Select(element);
        dropdown.selectByValue("1344");
    }
    public void selectCity() throws InterruptedException
    {
        scrollDown(400);
         Thread.sleep(2000);
        WebElement element=driver.findElement(SelectCityOption);
        Select dropdown=new Select(element);
        dropdown.selectByValue("9149");
    }
    public void enterZip()
    {
        scrollDown(400);
        sendText(driver.findElement(ZipCode), String.valueOf(Zip));
    }
    public void clickSubmit()throws InterruptedException
    {
        scrollDown(700);
        clickOnElement(driver.findElement(SubmitBtn));

    }


    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(VerifySave).getText();
        }

        return null;
    }



}
