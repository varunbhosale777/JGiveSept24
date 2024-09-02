package pom.smoke_test_FE;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.util.Properties;
public class DM_AD_FADD extends BrowserManager {
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
    By SelectRegion = By.xpath(DM_AD_FADDLocators.getProperty("SelectRegion"));
    By SelectCityOption = By.xpath(DM_AD_FADDLocators.getProperty("SelectCityOption"));
    By TypeCityOption = By.xpath(DM_AD_FADDLocators.getProperty("TypeCityOption"));
    By SelectCity = By.xpath(DM_AD_FADDLocators.getProperty("SelectCity"));
    By ZipCode = By.xpath(DM_AD_FADDLocators.getProperty("ZipCode"));
    By Email = By.xpath(DM_AD_FADDLocators.getProperty("Email"));
    By Phone = By.xpath(DM_AD_FADDLocators.getProperty("Phone"));
    By TaxID = By.xpath(DM_AD_FADDLocators.getProperty("TaxID"));
    By DonationAmount = By.xpath(DM_AD_FADDLocators.getProperty("DonationAmount"));
    By Continue1 = By.xpath(DM_AD_FADDLocators.getProperty("Continue1"));
    By ByChequeRadio = By.xpath(DM_AD_FADDLocators.getProperty("ByChequeRadio"));
    By PlaceDonationBtn = By.xpath(DM_AD_FADDLocators.getProperty("PlaceDonationBtn"));
    By ConfirmOrder = By.xpath(DM_AD_FADDLocators.getProperty("ConfirmOrder"));
    By SuccessMsg = By.xpath(DM_AD_FADDLocators.getProperty("SuccessMsg"));
    By AllDonationsLink = By.xpath(DM_AD_FADDLocators.getProperty("AllDonationsLink"));
    By PaymentStatus = By.xpath(DM_AD_FADDLocators.getProperty("PaymentStatus"));
    By DonorsLink = By.xpath(DM_AD_FADDLocators.getProperty("DonorsLink"));
    By DonationReceived = By.xpath(DM_AD_FADDLocators.getProperty("DonationReceived"));
    By MyDonations = By.xpath(DM_AD_FADDLocators.getProperty("MyDonations"));
    By MyDonations_DonationReceived = By.xpath(DM_AD_FADDLocators.getProperty("MyDonations_DonationReceived"));
    By FilterBtn = By.xpath(DM_AD_FADDLocators.getProperty("FilterBtn"));
    By FilterDropdown = By.xpath(DM_AD_FADDLocators.getProperty("FilterDropdown"));
    By SearchIcon = By.xpath(DM_AD_FADDLocators.getProperty("SearchIcon"));
    By SearchBox = By.xpath(DM_AD_FADDLocators.getProperty("SearchBox"));
    public DM_AD_FADD(WebDriver driver) {
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
		 Thread.sleep(2000);
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
        sendText(driver.findElement(DonationAmount), "100");
    }
    public void clickContinue()throws InterruptedException
    {
        scrollDown(1000);
        clickOnElement(driver.findElement(Continue1));

    }
    public void clickPayByRadio() throws InterruptedException {
       

        WebElement element = driver.findElement(ByChequeRadio);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        clickOnElement(element);


    }
    public void clickPlaceDonationBtn() throws InterruptedException
    {
        scrollDown(1000);
        clickOnElement(driver.findElement(PlaceDonationBtn));

    }
    public void clickConfirmOrder() throws InterruptedException {

        Thread.sleep(3000);
        WebElement element2 = BrowserManager.waitForElementToBeVisible(ConfirmOrder, 30);
        if (element2 != null) {
            scrollToBottom();
            Thread.sleep(3000);
            clickOnElement(element2);
            Thread.sleep(3000);


        }
        else
        {
            logStep("Failed to Locate : ConfirmOrder Element");
        }
    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }


    public void locateAllDonations()
    {
        clickOnElement(driver.findElement(AllDonationsLink));

    }
    public void selectConfirmed() {
        WebElement element=driver.findElement(PaymentStatus);
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText("Confirmed");

    }
    public void locateDonors()
    {
        clickOnElement(driver.findElement(DonorsLink));

    }
    public void verifyDonorsDonationAmount()
    {
        String donation=driver.findElement(DonationReceived).getText();
        Assert.assertTrue(donation.contains("100"),"Donation Not Matched");
    }
    public void locateMyDonations()
    {
        clickOnElement(driver.findElement(MyDonations));

    }
    public void verifyMyDonationAmount()
    {
        String donation=driver.findElement(MyDonations_DonationReceived).getText();
        Assert.assertTrue(donation.contains("100"),"Donation Not Matched");
    }
    public void searchCampaign()  {
        clickOnElement(driver.findElement(SearchIcon));
        sendText(driver.findElement(SearchBox), BrowserManager.CampaignTitle);
        clickOnElement(driver.findElement(SearchIcon));

    }
}
