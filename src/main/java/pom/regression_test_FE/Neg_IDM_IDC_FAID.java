package pom.regression_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class Neg_IDM_IDC_FAID extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties IDM_IDC_FAID = loader.getProperties("IDM_IDC_FAIDLocators.properties");
    
    By IndividualContact = By.xpath(IDM_IDC_FAID.getProperty("IndividualContact"));
    By SubmitBtn = By.xpath(IDM_IDC_FAID.getProperty("SubmitBtn"));
    By VerifySave = By.xpath(IDM_IDC_FAID.getProperty("VerifySave"));
    public Neg_IDM_IDC_FAID(WebDriver driver) {
        BrowserManager.driver = driver;
    }
    
    public void locateCreateIndividualContact() throws InterruptedException {
        clickOnElement(driver.findElement(IndividualContact));

    }
    public void clickSubmit()throws InterruptedException
    {
        scrollDown(700);
        Thread.sleep(3000);
        clickOnElement(driver.findElement(SubmitBtn));

    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Error":
                return driver.findElement(VerifySave).getText();
        }

        return null;
    }


}
