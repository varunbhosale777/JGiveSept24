

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
import java.util.Properties;
import java.util.logging.Logger;
public class RM_GR_BGRLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public RM_GR_BGRLV(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCPRLV = loader.getProperties("RM_GR_BGRLVLocators.properties");
    
    String pageTitle = BCPRLV.getProperty("pageTitle");
    By Components = By.xpath(BCPRLV.getProperty("Components"));
    By JGive = By.xpath(BCPRLV.getProperty("JGive"));
    By Reports = By.xpath(BCPRLV.getProperty("Reports"));
    By ReportsDropdown = By.xpath(BCPRLV.getProperty("ReportsDropdown"));
    By ShowHideMenu = By.xpath(BCPRLV.getProperty("ShowHideMenu"));
    By ClearBtn = By.xpath(BCPRLV.getProperty("ClearBtn"));
    By FirstCol = By.xpath(BCPRLV.getProperty("FirstCol"));
    By SecondCol = By.xpath(BCPRLV.getProperty("SecondCol"));
    
    public void locateReports() throws InterruptedException {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,700)");
        clickOnElement(driver.findElement(Reports));
        logStep("Clicking Campaigns");
    }
    
    public void validateCorrectPage() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, pageTitle, "Not Matched");
        logStep("Validating correct page");
    }
    public void selectReportsDropdown()
    {
        WebElement element=driver.findElement(ReportsDropdown);
        Select dropdown= new Select(element);


        dropdown.selectByValue("jgivegiveback");
    }
    public void clickShowHideCols()
    {
        clickOnElement(driver.findElement(ShowHideMenu));

    }
    public void deselectCols() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(driver.findElement(FirstCol));
        logStep("Unchecking First Column");
        Thread.sleep(2000);
        clickOnElement(driver.findElement(SecondCol));
        logStep("Unchecking Second Column");
    }

    public void clickClearBtn() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(driver.findElement(ClearBtn));

    }

}
