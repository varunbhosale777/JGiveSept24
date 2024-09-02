package pom.smoke_test_FE;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.util.Properties;
public class VM_VC_FVC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties VM_VC_FVCLocators = loader.getProperties("VM_VC_FVCLocators.properties");
    
    By VendorProfile = By.xpath(VM_VC_FVCLocators.getProperty("VendorProfile"));
    By VendorName = By.xpath(VM_VC_FVCLocators.getProperty("VendorName"));
    By VendorPhone = By.xpath(VM_VC_FVCLocators.getProperty("VendorPhone"));
    By VendorAlias = By.xpath(VM_VC_FVCLocators.getProperty("VendorAlias"));
    By VendorAddress = By.xpath(VM_VC_FVCLocators.getProperty("VendorAddress"));
    By VendorDescription = By.xpath(VM_VC_FVCLocators.getProperty("VendorDescription"));
    By SelectCountryOption = By.xpath(VM_VC_FVCLocators.getProperty("SelectCountryOption"));
    By SelectRegionOption = By.xpath(VM_VC_FVCLocators.getProperty("SelectRegionOption"));
    By SelectCityOption = By.xpath(VM_VC_FVCLocators.getProperty("SelectCityOption"));
    By UploadImage = By.xpath(VM_VC_FVCLocators.getProperty("UploadImage"));
    By VendorWebsite = By.xpath(VM_VC_FVCLocators.getProperty("VendorWebsite"));
    By VendorVAT = By.xpath(VM_VC_FVCLocators.getProperty("VendorVAT"));
    By SubmitBtn = By.xpath(VM_VC_FVCLocators.getProperty("SubmitBtn"));
    By VendorSaveSuccessMsg = By.xpath(VM_VC_FVCLocators.getProperty("VendorSaveSuccessMsg"));
    public VM_VC_FVC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateVendorProfile() throws InterruptedException {
        clickOnElement(driver.findElement(VendorProfile));

        Thread.sleep(3000);
    }
    public void enterVendorName()
    {
        sendText(driver.findElement(VendorName), BrowserManager.VendorName);
    }
    public void enterPhoneNumber()
    {
        sendText(driver.findElement(VendorPhone), String.valueOf(BrowserManager.Phone));
    }
    public void enterAddress()
    {
        sendText(driver.findElement(VendorAddress), Address1);
    }
    public void enterDescription()
    {
        scrollDown(200);
        sendText(driver.findElement(VendorDescription), Address2);
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
    public void uploadImage()
    {
        scrollDown(500);
        String imagePath = "src/test/java/test/resources/media/image1.jpg";
        File file = new File(imagePath);
        String absPath = file.getAbsolutePath();
        sendText(driver.findElement(UploadImage), absPath);
    }
    public void enterTax()
    {
        scrollDown(500);
        sendText(driver.findElement(VendorVAT), String.valueOf(Tax));
    }
    public void enterWebsite() throws InterruptedException
    {
        scrollDown(500);
        sendText(driver.findElement(VendorWebsite), WebSite);
    }
    public void clickSubmit()throws InterruptedException
    {
        WebElement element = driver.findElement(SubmitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void verifySubmit() throws InterruptedException
    {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(VendorSaveSuccessMsg).isDisplayed(),"Error Locating");
    }
}
