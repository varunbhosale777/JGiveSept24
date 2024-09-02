package pom.smoke_test_FE;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;
public class IDM_IDC_FIDLV extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/FE/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties IDM_IDC_FIDLV = loader.getProperties("IDM_IDC_FIDLVLocators.properties");
    
    By IndividualContact = By.xpath(IDM_IDC_FIDLV.getProperty("IndividualContact"));
    By IndividualName = By.xpath(IDM_IDC_FIDLV.getProperty("IndividualName"));
    By Checkbox1 = By.xpath(IDM_IDC_FIDLV.getProperty("Checkbox1"));
    By UnpublishBtn = By.xpath(IDM_IDC_FIDLV.getProperty("UnpublishBtn"));
    By PublishBtn = By.xpath(IDM_IDC_FIDLV.getProperty("PublishBtn"));
    By EditBtn = By.xpath(IDM_IDC_FIDLV.getProperty("EditBtn"));
    By IndividualContactFirstName = By.xpath(IDM_IDC_FIDLV.getProperty("IndividualContactFirstName"));
    By SubmitBtn = By.xpath(IDM_IDC_FIDLV.getProperty("SubmitBtn"));
    By ClearBtn = By.xpath(IDM_IDC_FIDLV.getProperty("ClearBtn"));
    By SearchBox = By.xpath(IDM_IDC_FIDLV.getProperty("SearchBox"));
    By SearchBtn = By.xpath(IDM_IDC_FIDLV.getProperty("SearchBtn"));
    By IndividualAddressTab = By.xpath(IDM_IDC_FIDLV.getProperty("IndividualAddressTab"));
    By IndividualAddress1 = By.xpath(IDM_IDC_FIDLV.getProperty("IndividualAddress1"));
    By IndividualAddress2 = By.xpath(IDM_IDC_FIDLV.getProperty("IndividualAddress2"));
    By SelectCountryOption = By.xpath(IDM_IDC_FIDLV.getProperty("SelectCountryOption"));
    By SelectRegionOption = By.xpath(IDM_IDC_FIDLV.getProperty("SelectRegionOption"));
    By SelectCityOption = By.xpath(IDM_IDC_FIDLV.getProperty("SelectCityOption"));

    
    public void locateIndividualContacts()
    {
        WebElement element = driver.findElement(IndividualContact);
        Assert.assertTrue(element.isDisplayed(),"Individual Contact Not Displayed");
        clickOnElement(element);


    }
    public void validateIndividualName()
    {
        WebElement element = driver.findElement(IndividualName);
        String name=element.getText();
        Assert.assertEquals(IND_Donor, name,"Individual Name not matched ");
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
    public void clickPublish() throws InterruptedException {
        clickCheckbox();
        WebElement element=driver.findElement(PublishBtn);
        Assert.assertTrue(element.isDisplayed(),"Publish button not displayed");
        clickOnElement(element);
        Thread.sleep(3000);
    }
    public void clickEdit()
    {
        clickCheckbox();
        WebElement element=driver.findElement(EditBtn);
        Assert.assertTrue(element.isDisplayed(),"Edit button not displayed");
        clickOnElement(element);


    }
    public void editFirstName()
    {
        WebElement element=driver.findElement(IndividualContactFirstName);
        Assert.assertTrue(element.isDisplayed(),"First Name not displayed");
        element.clear();
        sendText(element, "ABC");
    }
    public void clickAddressTab()
    {
        clickOnElement(driver.findElement(IndividualAddressTab));

    }
    public void enterAddress()
    {
        sendText(driver.findElement(IndividualAddress1), BrowserManager.Address1);
        sendText(driver.findElement(IndividualAddress2), BrowserManager.Address2);
    }
    public void selectCountry() throws InterruptedException
    {
        scrollDown(500);
		Thread.sleep(3000);
        WebElement element=driver.findElement(SelectCountryOption);
        Select dropdown=new Select(element);
        dropdown.selectByValue("99");
    }
    public void selectRegion() throws InterruptedException
    {
        scrollDown(500);
        Thread.sleep(2000);
        WebElement element=driver.findElement(SelectRegionOption);
        Select dropdown=new Select(element);
        dropdown.selectByValue("1344");
    }
    public void selectCity() throws InterruptedException
    {
        scrollDown(400);
         Thread.sleep(2000);
        WebElement element=driver.findElement(SelectCityOption);
        Select dropdown=new Select(element);
        dropdown.selectByValue("9149");
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
        WebElement element2= BrowserManager.waitForElementToBeVisible(IndividualName, 10);
        if (element2 != null) {
            String name=element2.getText();
            Assert.assertEquals(name, "ABC","Edited Individual Name not matched ");
        }
        else
        {
            logStep("Failed to Locate : IndividualName Element");
            Assert.fail("Enable to verify edit");
        }
    }
    public void enterSearch()
    {
        sendText(driver.findElement(SearchBox), "ABC");
    }
    public void clickSearchButton()
    {
        clickOnElement(driver.findElement(SearchBtn));

    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "Save":
                return driver.findElement(IndividualName).getText();
        }

        return null;
    }

    public void clickClear()
    {
        clickOnElement(driver.findElement(ClearBtn));

    }
}
