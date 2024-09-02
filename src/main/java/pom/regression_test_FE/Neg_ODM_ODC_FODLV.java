package pom.regression_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_ODM_ODC_FODLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties ODM_ODC_FODLV = loader.getProperties("ODM_ODC_FODLVLocators.properties");
    
    By OrganizationContacts = By.xpath(ODM_ODC_FODLV.getProperty("OrganizationContacts"));
    By ClearBtn = By.xpath(ODM_ODC_FODLV.getProperty("ClearBtn"));
    By SearchBox = By.xpath(ODM_ODC_FODLV.getProperty("SearchBox"));
    By SearchBtn = By.xpath(ODM_ODC_FODLV.getProperty("SearchBtn"));
    By ValidationMsg = By.xpath(ODM_ODC_FODLV.getProperty("ValidationMsg"));
    
    public void locateOrganizationContacts()
    {
        WebElement element = driver.findElement(OrganizationContacts);
        Assert.assertTrue(element.isDisplayed(),"Organization Contacts Not Displayed");
        clickOnElement(element);


    }
    public void enterSearch()
    {
        sendText(driver.findElement(SearchBox), "abc");
    }
    public void clickSearchButton()
    {
        clickOnElement(driver.findElement(SearchBtn));

    }
    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(ValidationMsg).getText();
        }

        return null;
    }




    public void clickClear()
    {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
