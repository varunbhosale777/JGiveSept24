package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
import java.util.logging.Logger;
public class Neg_IDM_IDC_BIDLV extends BrowserManager {
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
    By ErrorMsg = By.xpath(IDM_IDC_BIDLV.getProperty("ErrorMsg"));
    By SearchBox = By.xpath(IDM_IDC_BIDLV.getProperty("SearchBox"));
    By SearchBtn = By.xpath(IDM_IDC_BIDLV.getProperty("SearchBtn"));
    By ClearBtn = By.xpath(IDM_IDC_BIDLV.getProperty("ClearBtn"));
    public Neg_IDM_IDC_BIDLV(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateIndividualDonors() throws InterruptedException {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        clickOnElement(driver.findElement(IndividualDonors));
        logStep("Clicking Individual Donors");
    }
    public void enterSearchText() {
        sendText(driver.findElement(SearchBox), "abc#1");
    }
    public void clickSearch() throws InterruptedException {
        clickOnElement(driver.findElement(SearchBtn));

        Thread.sleep(2000);
    }
      public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                waitFor(10);
                return driver.findElement(ErrorMsg).getText();
        }

        return null;
    }
    public void clickClearBtn() {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
