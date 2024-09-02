package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
public class Neg_IDM_IDC_BIDC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public Neg_IDM_IDC_BIDC(WebDriver driver) {
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
    By SaveAndCloseBtn = By.xpath(IDM_IDC_BIDC.getProperty("SaveAndCloseBtn"));
    By SuccessMsg=By.xpath(IDM_IDC_BIDC.getProperty("SuccessMsg"));
    
    public void locateIndividualDonors() throws InterruptedException
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        clickOnElement(driver.findElement(IndividualDonors));
        logStep("Clicking Individual Donors");

    }
    public void clickNew() throws InterruptedException
    {
        clickOnElement(driver.findElement(NewBtn));

        logStep("Clicking new");
    }
    public void saveAndClose() throws InterruptedException
    {
        clickOnElement(driver.findElement(SaveAndCloseBtn));
        logStep("Clicking Save and Close");
    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }


}
