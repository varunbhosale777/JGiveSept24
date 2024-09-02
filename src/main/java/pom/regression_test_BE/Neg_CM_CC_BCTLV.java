package pom.regression_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_CM_CC_BCTLV extends BrowserManager {
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/BE/";
    public Neg_CM_CC_BCTLV(WebDriver driver)
    {
        BrowserManager.driver=driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCTLVLocators = loader.getProperties("CM_CC_BCTLVLocators.properties");

    By Components=By.xpath(BCTLVLocators.getProperty("Components"));
    By JGive=By.xpath(BCTLVLocators.getProperty("JGive"));
    By Categories=By.xpath(BCTLVLocators.getProperty("Categories"));
    By searchCategory=By.id(BCTLVLocators.getProperty("searchCategory"));
    By searchBtn=By.xpath(BCTLVLocators.getProperty("searchBtn"));
    By ErrorMsg=By.xpath(BCTLVLocators.getProperty("ErrorMsg"));
    By clearBtn=By.xpath(BCTLVLocators.getProperty("clearBtn"));
    
    public void locateCategories() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        logStep("Clicking components");
        clickOnElement(driver.findElement(JGive));
        logStep("Clicking JGive");
        clickOnElement(driver.findElement(Categories));
        logStep("Clicking Categories");
    }
    public void enterSearchCategory()
    {
        sendText(driver.findElement(searchCategory), "abc#1");
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(searchBtn));

    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                waitFor(10);
                return driver.findElement(ErrorMsg).getText();
        }

        return null;
    }
    public void clickClear()
    {
        clickOnElement(driver.findElement(clearBtn));

    }
}
