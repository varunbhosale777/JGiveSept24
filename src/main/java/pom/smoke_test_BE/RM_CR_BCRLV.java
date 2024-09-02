

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
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
public class RM_CR_BCRLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public RM_CR_BCRLV(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties RM_CR_BCRLV = loader.getProperties("RM_CR_BCRLVLocators.properties");
    
    String pageTitle = RM_CR_BCRLV.getProperty("pageTitle");
    By Components = By.xpath(RM_CR_BCRLV.getProperty("Components"));
    By JGive = By.xpath(RM_CR_BCRLV.getProperty("JGive"));
    By Reports = By.xpath(RM_CR_BCRLV.getProperty("Reports"));
    By ReportsDropdown = By.xpath(RM_CR_BCRLV.getProperty("ReportsDropdown"));
    By SearchFilter = By.xpath(RM_CR_BCRLV.getProperty("SearchFilter"));
    By SelectPromoter = By.xpath(RM_CR_BCRLV.getProperty("SelectPromoter"));
    By ShowHideMenu = By.xpath(RM_CR_BCRLV.getProperty("ShowHideMenu"));
    By CampaignCol = By.xpath(RM_CR_BCRLV.getProperty("CampaignCol"));
    By ClearBtn = By.xpath(RM_CR_BCRLV.getProperty("ClearBtn"));

     
 
    public void locateReports() throws InterruptedException {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,700)");
        clickOnElement(driver.findElement(Reports));

        logStep("Clicking Report");
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


        dropdown.selectByValue("jgivecampaigns");
    }
    public void clickSearchTools() throws InterruptedException {
        clickOnElement(driver.findElement(SearchFilter));

    }
    public void selectPromoter() throws InterruptedException {
        WebElement element=driver.findElement(SelectPromoter);
        Select dropdown= new Select(element);
        dropdown.selectByVisibleText("superuser");
        Thread.sleep(2000);
    }
    public void clickShowHideCols()
    {
        clickOnElement(driver.findElement(ShowHideMenu));

    }
    public void deselectCols() throws InterruptedException {
        clickOnElement(driver.findElement(CampaignCol));
    }
    public void clickClearBtn() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(driver.findElement(ClearBtn));
        logStep("Clicking Clear Filter Button");
    }

}
