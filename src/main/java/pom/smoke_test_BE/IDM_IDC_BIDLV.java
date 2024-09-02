package pom.smoke_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
public class IDM_IDC_BIDLV extends BrowserManager {
    private static final Logger LOGGER = LoggerUtil.getLogger();
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties IDM_IDC_BIDLV = loader.getProperties("IDM_IDC_BIDLVLocators.properties");
    
    By Components = By.xpath(IDM_IDC_BIDLV.getProperty("Components"));
    By JGive = By.xpath(IDM_IDC_BIDLV.getProperty("JGive"));
    By IndividualDonors = By.xpath(IDM_IDC_BIDLV.getProperty("IndividualDonors"));
    By Checkbox = By.xpath(IDM_IDC_BIDLV.getProperty("Checkbox"));
    By Edit = By.xpath(IDM_IDC_BIDLV.getProperty("Edit"));
    By Contact = By.xpath(IDM_IDC_BIDLV.getProperty("Contact"));
    By SaveAndCloseBtn = By.xpath(IDM_IDC_BIDLV.getProperty("SaveAndCloseBtn"));
    By SuccessMsg = By.xpath(IDM_IDC_BIDLV.getProperty("SuccessMsg"));
    By SearchBox = By.xpath(IDM_IDC_BIDLV.getProperty("SearchBox"));
    By SearchBtn = By.xpath(IDM_IDC_BIDLV.getProperty("SearchBtn"));
    By ActualName = By.xpath(IDM_IDC_BIDLV.getProperty("ActualName"));
    public IDM_IDC_BIDLV(WebDriver driver) {
        this.driver = driver;
    }
    
     
      
    public void locateIndividualDonors() throws InterruptedException {
        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        clickOnElement(driver.findElement(IndividualDonors));

    }
    public void validateCorrectPage() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Individual Donors"),"Error Locating");
    }
    public void clickCheckbox() throws InterruptedException {
        clickOnElement(driver.findElement(Checkbox));

    }
    public void clickEdit() {
        clickOnElement(driver.findElement(Edit));

    }
    public void enterContact(long number) {
        driver.findElement(Contact).clear();
        sendText(driver.findElement(Contact), String.valueOf(number));
    }
    public void saveAndClose() throws InterruptedException {
        clickOnElement(driver.findElement(SaveAndCloseBtn));

        Thread.sleep(2000);
    }
    public void verifySave() {
        String welcomeMessage = driver.findElement(SuccessMsg).getText();
        Assert.assertTrue(welcomeMessage.contains("Individual saved"),"Error Locating");
    }
    public void enterSearchText(String text) {
        sendText(driver.findElement(SearchBox), text);
    }
    public void clickSearch() throws InterruptedException {
        clickOnElement(driver.findElement(SearchBtn));

        Thread.sleep(2000);
    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(ActualName).getText();
        }

        return null;
    }


}
