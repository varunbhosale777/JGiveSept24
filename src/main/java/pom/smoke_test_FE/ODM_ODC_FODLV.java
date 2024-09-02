package pom.smoke_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class ODM_ODC_FODLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties ODM_ODC_FODLV = loader.getProperties("ODM_ODC_FODLVLocators.properties");
    
    By OrganizationContacts = By.xpath(ODM_ODC_FODLV.getProperty("OrganizationContacts"));
    By OrganizationName = By.xpath(ODM_ODC_FODLV.getProperty("OrganizationName"));
    By Checkbox1 = By.xpath(ODM_ODC_FODLV.getProperty("Checkbox1"));
    By UnpublishBtn = By.xpath(ODM_ODC_FODLV.getProperty("UnpublishBtn"));
    By PublishBtn = By.xpath(ODM_ODC_FODLV.getProperty("PublishBtn"));
    By EditBtn = By.xpath(ODM_ODC_FODLV.getProperty("EditBtn"));
    By OrgNameTxt = By.xpath(ODM_ODC_FODLV.getProperty("OrgNameTxt"));
    By SubmitBtn = By.xpath(ODM_ODC_FODLV.getProperty("SubmitBtn"));
    By ClearBtn = By.xpath(ODM_ODC_FODLV.getProperty("ClearBtn"));
    By SearchBox = By.xpath(ODM_ODC_FODLV.getProperty("SearchBox"));
    By SearchBtn = By.xpath(ODM_ODC_FODLV.getProperty("SearchBtn"));
    
    public void locateOrganizationContacts()
    {
        WebElement element = driver.findElement(OrganizationContacts);
        Assert.assertTrue(element.isDisplayed(),"Organization Contacts Not Displayed");
        clickOnElement(element);


    }
    public void validateOrganizationName()
    {
        WebElement element = driver.findElement(OrganizationName);
        String name=element.getText();
        Assert.assertEquals(ORG_Donor, name,"Organization Name not matched ");
    }
    public void clickCheckbox()
    {
        WebElement element = driver.findElement(Checkbox1);
        Assert.assertTrue(element.isDisplayed(),"Checkbox not displayed");
        clickOnElement(element);


    }
    public void clickUnpublish()
    {
        WebElement element = driver.findElement(UnpublishBtn);
        Assert.assertTrue(element.isDisplayed(),"Unpublish button not displayed");
        clickOnElement(element);


    }
    public void clickPublish()
    {
        clickCheckbox();
        WebElement element=driver.findElement(PublishBtn);
        Assert.assertTrue(element.isDisplayed(),"Publish button not displayed");
        clickOnElement(element);


    }
    public void clickEdit()
    {
        clickCheckbox();
        WebElement element=driver.findElement(EditBtn);
        Assert.assertTrue(element.isDisplayed(),"Edit button not displayed");
        clickOnElement(element);


    }
    public void enterFirstName()
    {
        WebElement element=driver.findElement(OrgNameTxt);
        Assert.assertTrue(element.isDisplayed(),"First Name not displayed");
        element.clear();
        sendText(element, "abc");
    }
    public void clickSubmit() throws InterruptedException
    {
        scrollDown(700);
        WebElement element=driver.findElement(SubmitBtn);
        Assert.assertTrue(element.isDisplayed(),"Submit button not displayed");
        clickOnElement(element);


        Thread.sleep(3000);
    }
    public void verifyEdit()
    {
        WebElement element2= BrowserManager.waitForElementToBeVisible( OrganizationName, 10);
        if (element2 != null) {
            String name=element2.getText();
            Assert.assertEquals(name, "abc","Edited Organization Name not matched ");
        }
        else
        {
            logStep("Failed to Locate : OrganizationName Element");
            Assert.fail("Enable to verify edit");
        }
    }
    public void enterSearch()
    {
        sendText(driver.findElement(SearchBox), ORG_Donor);
    }
    public void clickSearchButton()
    {
        clickOnElement(driver.findElement(SearchBtn));

    }


    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(OrganizationName).getText();
        }

        return null;
    }





    public void clickClear()
    {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
