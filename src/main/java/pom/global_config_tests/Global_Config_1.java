package pom.global_config_tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.util.Properties;



public class Global_Config_1 extends BrowserManager {
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/global_config/";
    public Global_Config_1(WebDriver driver)
    {
        BrowserManager.driver=driver;
    }
    
    static
    {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader=PropertiesFileManager.getInstance();
    Properties GlobalConfigLocators=loader.getProperties("GlobalConfig1Locators.properties");
    
    
    By username = By.id(GlobalConfigLocators.getProperty("username"));
    By password = By.id(GlobalConfigLocators.getProperty("password"));
    By loginBtn = By.id(GlobalConfigLocators.getProperty("loginBtn"));
    By SystemLink=By.xpath(GlobalConfigLocators.getProperty("SystemLink"));
    By GlobalConfigLink=By.xpath(GlobalConfigLocators.getProperty("GlobalConfigLink"));
    By jGiveOption=By.xpath(GlobalConfigLocators.getProperty("jGiveOption"));
    By GeneralTab=By.xpath(GlobalConfigLocators.getProperty("GeneralTab"));
    By ForceUsersYes=By.xpath(GlobalConfigLocators.getProperty("ForceUsersYes"));
    By AutoVendorRegisterDropdown=By.xpath(GlobalConfigLocators.getProperty("AutoVendorRegisterDropdown"));
    By SaveBtn=By.xpath(GlobalConfigLocators.getProperty("SaveBtn"));
    By ConfigSaveSuccessMsg=By.xpath(GlobalConfigLocators.getProperty("ConfigSaveSuccessMsg"));
    
    By RegisterMenu= By.xpath(GlobalConfigLocators.getProperty("RegisterMenu"));
    By UsernameTxtField=By.xpath(GlobalConfigLocators.getProperty("UsernameTxtField"));
    By UserEmailTxtField=By.xpath(GlobalConfigLocators.getProperty("UserEmailTxtField"));
    By ConfirmUserEmailTxtField= By.xpath(GlobalConfigLocators.getProperty("ConfirmUserEmailTxtField"));
    By SignupBtn=By.xpath(GlobalConfigLocators.getProperty("SignupBtn"));
    By SuccessMsg=By.xpath(GlobalConfigLocators.getProperty("SuccessMsg"));
    By CreateCampaign=By.xpath(GlobalConfigLocators.getProperty("CreateCampaign"));
    By ErrorMessage=By.xpath(GlobalConfigLocators.getProperty("ErrorMessage"));
    By ForceUsersNo=By.xpath(GlobalConfigLocators.getProperty("ForceUsersNo"));
    
    
    public void username(String un) {
        sendText(driver.findElement(username), un);
    }
    
    public void password(String pw) {
        sendText(driver.findElement(password), pw);
    }
    
    public void loginBtn() {
        clickOnElement(driver.findElement(loginBtn));

    }
    public void locateJGiveGlobalConfig() {
        clickOnElement(driver.findElement(SystemLink));
        clickOnElement(driver.findElement(GlobalConfigLink));
        WebElement element = driver.findElement(jGiveOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);


    }
    public void clickGeneralTab()
    {
        clickOnElement(driver.findElement(GeneralTab));

    }
    public void clickForceUsersYes(){
        clickOnElement(driver.findElement(ForceUsersYes));

    }
    public void SelectAutoVendorRegisterDropdownNo(){
        WebElement element =driver.findElement(AutoVendorRegisterDropdown);
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText("No");
    }
    public void clickSaveBtn()
    {
        clickOnElement(driver.findElement(SaveBtn));

    }

    
    public void SelectAutoVendorRegisterDropdownYes(){
        WebElement element =driver.findElement(AutoVendorRegisterDropdown);
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText("Yes");
    }
    public void clickForceUsersNo(){
        clickOnElement(driver.findElement(ForceUsersNo));

    }
    
    public void locateRegisterMenu() {
        clickOnElement(driver.findElement(RegisterMenu));

    }
    public void enterUsername(String text)
    {
        sendText(driver.findElement(UsernameTxtField), text);
    }
    public void enterEmail(String text)
    {
        sendText(driver.findElement(UserEmailTxtField), text);
    }
    public void enterConfirmEmail(String text)
    {
        sendText(driver.findElement(ConfirmUserEmailTxtField), text);
    }
    public void clickSignup()
    {
        clickOnElement(driver.findElement(SignupBtn));

    }
    public void verifySave()
    {
        String msg=driver.findElement(SuccessMsg).getText();
        Assert.assertTrue(msg.contains("A user account has been created for you & the access details have been emailed at the address provided."),"Registration Failed");
    }
    public void locateCreateCampaign()
    {
        clickOnElement(driver.findElement(CreateCampaign));

    }


    public String validateMessage(String msg) {
        switch (msg) {
            case "ErrorMessage":
                return driver.findElement(ErrorMessage).getText();
            case "SaveMessage":
                return driver.findElement(ConfigSaveSuccessMsg).getText();
        }

        return null;
    }

}
