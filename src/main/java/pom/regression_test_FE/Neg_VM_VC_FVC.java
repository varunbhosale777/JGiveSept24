package pom.regression_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.util.Properties;
public class Neg_VM_VC_FVC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties VM_VC_FVCLocators = loader.getProperties("VM_VC_FVCLocators.properties");
    
    By VendorProfile = By.xpath(VM_VC_FVCLocators.getProperty("VendorProfile"));
    By VendorName = By.xpath(VM_VC_FVCLocators.getProperty("VendorName"));
    By VendorPhone = By.xpath(VM_VC_FVCLocators.getProperty("VendorPhone"));
    By VendorAddress = By.xpath(VM_VC_FVCLocators.getProperty("VendorAddress"));
    By VendorDescription = By.xpath(VM_VC_FVCLocators.getProperty("VendorDescription"));
    By VendorWebsite = By.xpath(VM_VC_FVCLocators.getProperty("VendorWebsite"));
    By VendorVAT = By.xpath(VM_VC_FVCLocators.getProperty("VendorVAT"));
    By SubmitBtn = By.xpath(VM_VC_FVCLocators.getProperty("SubmitBtn"));
    By VendorFailMessage = By.xpath(VM_VC_FVCLocators.getProperty("VendorFailMessage"));
    public Neg_VM_VC_FVC(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateVendorProfile() throws InterruptedException {
        clickOnElement(driver.findElement(VendorProfile));
    }
    public void clickSubmit()throws InterruptedException
    {
        scrollDown(1000);
        Thread.sleep(3000);
        clickOnElement(driver.findElement(SubmitBtn));
        Thread.sleep(3000);
    }

    public String validateMessage(String msg) throws InterruptedException {
        switch (msg) {
            case "Error":
                Thread.sleep(3000);
                return driver.findElement(VendorFailMessage).getText();
        }
        return null;
    }


}
