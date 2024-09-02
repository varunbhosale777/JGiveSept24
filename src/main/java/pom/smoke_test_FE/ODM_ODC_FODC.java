package pom.smoke_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class ODM_ODC_FODC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties ODM_ODC_FODC = loader.getProperties("ODM_ODC_FODCLocators.properties");
    
    By OrganizationContact = By.xpath(ODM_ODC_FODC.getProperty("OrganizationContact"));
    By OrganizationContactFirstName = By.xpath(ODM_ODC_FODC.getProperty("OrganizationContactFirstName"));
    By OrganizationContactEmail = By.xpath(ODM_ODC_FODC.getProperty("OrganizationContactEmail"));
    By OrganizationContactPhone = By.xpath(ODM_ODC_FODC.getProperty("OrganizationContactPhone"));
    By OrganizationAddressTab = By.xpath(ODM_ODC_FODC.getProperty("OrganizationAddressTab"));
    By OrganizationAddress1 = By.xpath(ODM_ODC_FODC.getProperty("OrganizationAddress1"));
    By OrganizationAddress2 = By.xpath(ODM_ODC_FODC.getProperty("OrganizationAddress2"));
    By SelectCountryOption = By.xpath(ODM_ODC_FODC.getProperty("SelectCountryOption"));
    By SelectRegionOption = By.xpath(ODM_ODC_FODC.getProperty("SelectRegionOption"));
    By SelectCityOption = By.xpath(ODM_ODC_FODC.getProperty("SelectCityOption"));
    By OrganizationWebsite = By.xpath(ODM_ODC_FODC.getProperty("OrganizationWebsite"));
    By TaxID = By.xpath(ODM_ODC_FODC.getProperty("TaxID"));
    By ZipCode = By.xpath(ODM_ODC_FODC.getProperty("ZipCode"));
    By SubmitBtn = By.xpath(ODM_ODC_FODC.getProperty("SubmitBtn"));
    By VerifySave = By.xpath(ODM_ODC_FODC.getProperty("VerifySave"));
    public ODM_ODC_FODC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateCreateOrganizationContact() throws InterruptedException {
        WebElement clickableElement = BrowserManager.waitForElementToBeClickable(driver,  OrganizationContact, 10);
        if (clickableElement != null) {
            clickOnElement(clickableElement);


            logStep("Clicking Create Organization Contact");
        }
        else
        {
            logStep("Failed to Locate or Click : Create Organization Contact Element");
        }
    }
    public void enterName()
    {
        WebElement name = driver.findElement(OrganizationContactFirstName);
        name.clear();
        sendText(name, BrowserManager.ORG_Donor);


    }
    public void enterWebsite()
    {
        WebElement website=driver.findElement(OrganizationWebsite);
        website.clear();
        sendText(website, BrowserManager.WebSite);


    }
    public void enterEmail()
    {
        sendText(driver.findElement(OrganizationContactEmail), BrowserManager.Email);
    }
    public void enterPhoneNumber()
    {
        sendText(driver.findElement(OrganizationContactPhone), String.valueOf(BrowserManager.Phone));
    }
    public void clickAddressTab()
    {
        clickOnElement(driver.findElement(OrganizationAddressTab));

    }
    public void enterAddress()
    {
        sendText(driver.findElement(OrganizationAddress1), BrowserManager.Address1);
        sendText(driver.findElement(OrganizationAddress2), BrowserManager.Address2);
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
        waitFor(10);
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
    public void enterTax()
    {
        scrollDown(400);
        sendText(driver.findElement(TaxID), String.valueOf(Tax));
    }
    public void clickSubmit()throws InterruptedException
    {
        scrollDown(700);
        WebElement element1 = BrowserManager.waitForElementToBeClickable(driver,  SubmitBtn, 10);
        if (element1 != null) {
            clickOnElement(element1);
            Thread.sleep(3000);

        }
        else
        {
            String msg="Failed to Locate or Click : SubmitBtn Element";
            logStep(msg);
            Assert.fail(msg);
        }
    }



    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(VerifySave).getText();
        }

        return null;
    }




}
