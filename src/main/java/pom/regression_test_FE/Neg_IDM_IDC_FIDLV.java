package pom.regression_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_IDM_IDC_FIDLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties IDM_IDC_FIDLV = loader.getProperties("IDM_IDC_FIDLVLocators.properties");
    
    By IndividualContact = By.xpath(IDM_IDC_FIDLV.getProperty("IndividualContact"));
    By ClearBtn = By.xpath(IDM_IDC_FIDLV.getProperty("ClearBtn"));
    By SearchBox = By.xpath(IDM_IDC_FIDLV.getProperty("SearchBox"));
    By SearchBtn = By.xpath(IDM_IDC_FIDLV.getProperty("SearchBtn"));
    By ValidationMsg = By.xpath(IDM_IDC_FIDLV.getProperty("ValidationMsg"));
    
    public void locateIndividualContacts()
    {
        WebElement element = driver.findElement(IndividualContact);
        Assert.assertTrue(element.isDisplayed(),"Individual Contact Not Displayed");
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
