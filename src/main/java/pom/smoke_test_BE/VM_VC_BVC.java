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
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
public class VM_VC_BVC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public VM_VC_BVC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    private static final Logger LOGGER = LoggerUtil.getLogger();
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BVCLocators = loader.getProperties("VM_VC_BVCLocators.properties");
    
    String pageTitle = BVCLocators.getProperty("pageTitle");
    By Components = By.xpath(BVCLocators.getProperty("Components"));
    By JGive = By.xpath(BVCLocators.getProperty("JGive"));
    By Vendors=By.xpath(BVCLocators.getProperty("Vendors"));
    By NewBtn=By.xpath(BVCLocators.getProperty("NewBtn"));
    By SelectUserBtn=By.xpath(BVCLocators.getProperty("SelectUserBtn"));
    By Name=By.xpath(BVCLocators.getProperty("Name"));
    By Alias=By.xpath(BVCLocators.getProperty("Alias"));
    By Description=By.xpath(BVCLocators.getProperty("Description"));
    By LogoUploadBtn=By.xpath(BVCLocators.getProperty("LogoUploadBtn"));
    By PhoneNumber=By.xpath(BVCLocators.getProperty("PhoneNumber"));
    By Address=By.xpath(BVCLocators.getProperty("Address"));
    By Country=By.xpath(BVCLocators.getProperty("Country"));
    By Region=By.xpath(BVCLocators.getProperty("Region"));
    By City=By.xpath(BVCLocators.getProperty("City"));
   
    By Zip=By.xpath(BVCLocators.getProperty("Zip"));
    By Website=By.xpath(BVCLocators.getProperty("Website"));
    By VAT=By.xpath(BVCLocators.getProperty("VAT"));
    By PaymentGatewayDetails=By.xpath(BVCLocators.getProperty("PaymentGatewayDetails"));
    By ChoosePaymentGateway=By.xpath(BVCLocators.getProperty("ChoosePaymentGateway"));
    By PaypalEmail=By.xpath(BVCLocators.getProperty("PaypalEmail"));
    By SaveAndCloseBtn = By.xpath(BVCLocators.getProperty("SaveAndCloseBtn"));
    By SuccessMsg=By.xpath(BVCLocators.getProperty("SuccessMsg"));
    By SearchBox=By.xpath(BVCLocators.getProperty("SearchBox"));
    By SearchBtn=By.xpath(BVCLocators.getProperty("SearchBtn"));
   public static String targetUsername = UserName;
    
    
    public void locateVendors()
    {
        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        WebElement element = driver.findElement(Vendors);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }
    public void validateCorrectPage()
    {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive : Vendors"),"Error Locating");
    }
    public void clickNew() throws InterruptedException
    {
        clickOnElement(driver.findElement(NewBtn));

    }
    public void clickSelectUser() throws InterruptedException {
        clickOnElement(driver.findElement(SelectUserBtn));

        Thread.sleep(3000);
    }
    public void clickUsername() throws InterruptedException {
        driver.switchTo().frame("Select User");
        sendText(driver.findElement(SearchBox), targetUsername);
        clickOnElement(driver.findElement(SearchBtn));

        Thread.sleep(2000);
        
        
        WebElement table = driver.findElement(By.cssSelector("table.table.table-sm"));
        
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            
            WebElement nameCell = row.findElement(By.cssSelector("th a"));
            
            String name = nameCell.getText();
            
            if (name.equals(targetUsername)) {
                
                clickOnElement(nameCell);


                driver.switchTo().defaultContent();
                logStep("Clicked on user: " + name);
                break;
            }
        }
    }
    public void enterVendorName(String text)
    {
        sendText(driver.findElement(Name), text);
    }
    public void enterAlias(String text)
    {
        sendText(driver.findElement(Alias), text);
    }
    public void enterDescription(String text)
    {
        sendText(driver.findElement(Description), text);
    }
    public void uploadImage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 800)");
        String imagePath = "src/test/java/test/resources/media/image1.jpg";
        File file = new File(imagePath);
        String absPath = file.getAbsolutePath();
        sendText(driver.findElement(LogoUploadBtn), absPath);
    }
    public void enterPhoneNumber(long num)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -800)");
        sendText(driver.findElement(PhoneNumber), String.valueOf(num));
    }
    public void enterAddress(String text)
    {
        sendText(driver.findElement(Address), text);
    }
    public void selectCountry(String text) throws InterruptedException
    {
        WebElement country=driver.findElement(Country);
        Select dropdown = new Select(country);
        dropdown.selectByVisibleText(text);
        Thread.sleep(2000);
    }
    public void selectRegion(String text) throws InterruptedException
    {
        WebElement region=driver.findElement(Region);
        Select dropdown=new Select(region);
        dropdown.selectByVisibleText(text);
        Thread.sleep(2000);
    }
    public void selectCity(String text) throws InterruptedException
    {
        WebElement city=driver.findElement(City);
        Select dropdown=new Select(city);
        dropdown.selectByVisibleText(text);
    }
    public void enterZipCode(long num)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,800)");
        sendText(driver.findElement(Zip), String.valueOf(num));
    }
    public void enterWebsite(String text)
    {
        sendText(driver.findElement(Website), text);
    }
    public void enterVATNumber(long num)
    {
        sendText(driver.findElement(VAT), String.valueOf(num));
    }

    public void enterPaypalEmail(String text)
    {
        sendText(driver.findElement(PaypalEmail), text);
    }
    public void saveAndClose() throws InterruptedException
    {
        clickOnElement(driver.findElement(SaveAndCloseBtn));

        Thread.sleep(3000);
    }


    public Boolean validateWebElement(String element) {
        switch (element) {
            case "Save":
                return driver.findElement(SuccessMsg).isDisplayed();
        }

        return null;

    }
}
