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
public class ODM_ODC_BODLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public ODM_ODC_BODLV(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BODLV = loader.getProperties("ODM_ODC_BODLVLocators.properties");

    By Components = By.xpath(BODLV.getProperty("Components"));
    By JGive = By.xpath(BODLV.getProperty("JGive"));
    By OrgDonors=By.xpath(BODLV.getProperty("OrgDonors"));
    By FirstCheckBox=By.xpath(BODLV.getProperty("FirstCheckBox"));
    By EditButton=By.xpath(BODLV.getProperty("EditButton"));
    By WebsiteTxtBox=By.xpath(BODLV.getProperty("WebsiteTxtBox"));
    By SaveAndCloseBtn=By.xpath(BODLV.getProperty("SaveAndCloseBtn"));
    By SuccessMsg=By.xpath(BODLV.getProperty("SuccessMsg"));
    By SearchTxtBox=By.xpath(BODLV.getProperty("SearchTxtBox"));
    By SearchBtn=By.xpath(BODLV.getProperty("SearchBtn"));
    By FirstResult=By.xpath(BODLV.getProperty("FirstResult"));
    By ClearBtn=By.xpath(BODLV.getProperty("ClearBtn"));
    

    public void locateOrgDonors() throws InterruptedException
    {

        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
        clickOnElement(driver.findElement(OrgDonors));
    }
    public void validateCorrectPage()
    {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Organization Donors"),"Error Locating");
    }
    public void clickCheckbox()
    {
        clickOnElement(driver.findElement(FirstCheckBox));

    }
    public void clickEdit()
    {
        clickOnElement(driver.findElement(EditButton));

    }
    public void enterWebsite(String text)
    {
        WebElement textbox = driver.findElement(WebsiteTxtBox);
        textbox.clear();
        sendText(textbox, text);
    }
    public void clickSaveAndClose()
    {
        clickOnElement(driver.findElement(SaveAndCloseBtn));

    }
    public void verifyEdit()
    {
        String welcomeMessage = driver.findElement(SuccessMsg).getText();
        Assert.assertTrue(welcomeMessage.contains("Organization saved"),"Error Locating");
    }
    public void enterSearchQuery(String text)
    {
        sendText(driver.findElement(SearchTxtBox), text);
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(SearchBtn));

    }
    public void verifyFirstResult(String text)
    {
      String FirstRes =   driver.findElement(FirstResult).getText();
      Assert.assertTrue(FirstRes.contains(text),"Error Locating");
    }
    public void clickClear()
    {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
