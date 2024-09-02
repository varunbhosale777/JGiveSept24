package pom.regression_test_FE;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_DM_AD_FADD extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties DM_AD_FADDLocators = loader.getProperties("DM_AD_FADDLocators.properties");
    
    By AllCampaigns = By.xpath(DM_AD_FADDLocators.getProperty("AllCampaigns"));
    By Donate = By.xpath(DM_AD_FADDLocators.getProperty("Donate"));
    By FirstName = By.xpath(DM_AD_FADDLocators.getProperty("FirstName"));
    By LastName = By.xpath(DM_AD_FADDLocators.getProperty("LastName"));
    By Address = By.xpath(DM_AD_FADDLocators.getProperty("Address"));
    By SelectCountryOption = By.xpath(DM_AD_FADDLocators.getProperty("SelectCountryOption"));
    By TypeCountryOption = By.xpath(DM_AD_FADDLocators.getProperty("TypeCountryOption"));
    By SelectIndia = By.xpath(DM_AD_FADDLocators.getProperty("SelectIndia"));
    By SelectRegionOption = By.xpath(DM_AD_FADDLocators.getProperty("SelectRegionOption"));
    By TypeRegionOption = By.xpath(DM_AD_FADDLocators.getProperty("TypeRegionOption"));
    By SelectCityOption = By.xpath(DM_AD_FADDLocators.getProperty("SelectCityOption"));
    By TypeCityOption = By.xpath(DM_AD_FADDLocators.getProperty("TypeCityOption"));
    By ZipCode = By.xpath(DM_AD_FADDLocators.getProperty("ZipCode"));
    By Email = By.xpath(DM_AD_FADDLocators.getProperty("Email"));
    By Phone = By.xpath(DM_AD_FADDLocators.getProperty("Phone"));
    By TaxID = By.xpath(DM_AD_FADDLocators.getProperty("TaxID"));
    By DonationAmount = By.xpath(DM_AD_FADDLocators.getProperty("DonationAmount"));
    By Continue1 = By.xpath(DM_AD_FADDLocators.getProperty("Continue1"));
    By SearchIcon = By.xpath(DM_AD_FADDLocators.getProperty("SearchIcon"));
    By SearchBox = By.xpath(DM_AD_FADDLocators.getProperty("SearchBox"));
    public Neg_DM_AD_FADD(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateAllCampaigns() throws InterruptedException {
        clickOnElement(driver.findElement(AllCampaigns));
    }
    public void clickDonate()
    {
        clickOnElement(driver.findElement(Donate));

    }
    public void enterFirstName()
    {
        sendText(driver.findElement(FirstName), BrowserManager.IND_Donor);
    }
    public void enterLastName()
    {
        sendText(driver.findElement(LastName), BrowserManager.IND_Donor);
    }
    public void enterAddress()
    {
        sendText(driver.findElement(Address), Address1);
    }
    public void selectCountry() throws InterruptedException
    {
        WebElement element=driver.findElement(SelectCountryOption);
		Thread.sleep(3000);
        Select dropdown=new Select(element);
        dropdown.selectByValue("99");
    }
    public void selectRegion() throws InterruptedException
    {
        scrollDown(300);
        Thread.sleep(2000);
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
        scrollDown(500);
        sendText(driver.findElement(ZipCode), String.valueOf(BrowserManager.generateVendorZipCode()));

    }
    public void enterEmail()
    {
        scrollDown(500);
        sendText(driver.findElement(Email), String.valueOf(BrowserManager.Email));
    }
    public void enterPhoneNumber()
    {
        scrollDown(500);
        sendText(driver.findElement(Phone), String.valueOf(BrowserManager.Phone));
    }
    public void enterTaxID()
    {
        scrollDown(500);
        sendText(driver.findElement(TaxID), String.valueOf(BrowserManager.Tax));
    }
    public void enterDonationAmount()
    {
        scrollDown(500);
        WebElement element=driver.findElement(DonationAmount);
        clickOnElement(element);


        element.sendKeys(Keys.ARROW_DOWN);
    }
    public void clickContinue()throws InterruptedException
    {
        scrollDown(1000);
        Thread.sleep(2000);
        clickOnElement(driver.findElement(Continue1));

    }
    public void verifyPopup()
    {
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        Assert.assertTrue(alertMessage.contains("Please enter a amount greater than or equal to 100"),"Error Locating");
        alert.accept();
    }
    public void searchCampaign() throws InterruptedException {
        waitFor(5);
        clickOnElement(driver.findElement(SearchIcon));

        Thread.sleep(2000);
        sendText(driver.findElement(SearchBox), BrowserManager.CampaignTitle);
        clickOnElement(driver.findElement(SearchIcon));

    }
}
