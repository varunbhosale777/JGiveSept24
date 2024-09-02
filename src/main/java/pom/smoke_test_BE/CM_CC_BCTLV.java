package pom.smoke_test_BE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class CM_CC_BCTLV extends BrowserManager{
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/BE/";
    public CM_CC_BCTLV(WebDriver driver)
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
    By categoryTitle=By.xpath(BCTLVLocators.getProperty("actualCategoryTitle"));
    
     
    public void locateCategories() throws InterruptedException
    {
        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        clickOnElement(driver.findElement(Categories));
    }
    public void validateCorrectPage()
    {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Categories"),"Error Locating");
    }
    public void enterSearchCategory(String text)
    {
        sendText(driver.findElement(searchCategory), text);
    }
    public void clickSearchBtn()
    {
        clickOnElement(driver.findElement(searchBtn));

    }



    public String validateMessage(String msg) throws InterruptedException {
        switch (msg) {
            case "Locate":
                waitFor(10);
                Thread.sleep(3000);
                return driver.findElement(categoryTitle).getText();
        }

        return null;
    }
}
