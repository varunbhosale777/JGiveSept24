package pom.smoke_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class CM_CTC_BCTC extends BrowserManager {
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/BE/";
    public CM_CTC_BCTC(WebDriver driver)
    {
        this.driver=driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCTCLocators = loader.getProperties("CM_CTC_BCTCLocators.properties");

    By Components=By.xpath(BCTCLocators.getProperty("Components"));
    By JGive=By.xpath(BCTCLocators.getProperty("JGive"));
    By Categories=By.xpath(BCTCLocators.getProperty("Categories"));
    By NewBtn=By.xpath(BCTCLocators.getProperty("NewBtn"));
    By titleTxt=By.xpath(BCTCLocators.getProperty("titleTxt"));
    By aliasTxt = By.xpath(BCTCLocators.getProperty("aliasTxt"));
    By saveAndClose=By.xpath(BCTCLocators.getProperty("saveAndClose"));
    By saveSuccessMessage=By.xpath(BCTCLocators.getProperty("saveSuccessMessage"));
    

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
    public void clickNew()
    {
        clickOnElement(driver.findElement(NewBtn));
    }
    public void enterCategoryTitle(String text)
    {
        sendText(driver.findElement(titleTxt), text);
    }
    public void enterAlias(String text)
    {
        sendText(driver.findElement(aliasTxt), text);
    }
    public void clickSave(){
        clickOnElement(driver.findElement(saveAndClose));
    }


    public Boolean validateWebElement(String element) {
        switch (element) {
            case "Save":
                return driver.findElement(saveSuccessMessage).isDisplayed();
        }

        return false;

    }


}
