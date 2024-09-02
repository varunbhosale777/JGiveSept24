package pom.regression_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_VM_VC_FUVD extends BrowserManager {
    static String locatorsPath=System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    static
    {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties VM_VC_FUVD = loader.getProperties("VM_VC_FUVDLocators.properties");
    
    By VendorProfile = By.xpath(VM_VC_FUVD.getProperty("VendorProfile"));
    By UpdateProfile = By.xpath(VM_VC_FUVD.getProperty("UpdateProfile"));
    By VendorNameTxt = By.xpath(VM_VC_FUVD.getProperty("VendorNameTxt"));
    By UpdateErrorMessage = By.xpath(VM_VC_FUVD.getProperty("UpdateErrorMessage"));
    By SubmitBtn = By.xpath(VM_VC_FUVD.getProperty("SubmitBtn"));
    public Neg_VM_VC_FUVD(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateVendorProfile() {
        clickOnElement(driver.findElement(VendorProfile));

    }
    public void clickUpdateProfile()
    {
        clickOnElement(driver.findElement(UpdateProfile));

    }
    public void enterVendorName()
    {
        WebElement element=driver.findElement(VendorNameTxt);
        element.clear();
    }
    public void clickSubmit() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(3000);
        clickOnElement(driver.findElement(SubmitBtn));
        Thread.sleep(3000);
    }
    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(UpdateErrorMessage).getText();
        }

        return null;
    }




}
