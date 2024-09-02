package pom.global_config_tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;

import java.util.Properties;

public class Default_Global_Config extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/global_config/";

    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }

    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties GlobalConfigLocators = loader.getProperties("GlobalConfigLocators.properties");
    By username = By.id(GlobalConfigLocators.getProperty("username"));
    By password = By.id(GlobalConfigLocators.getProperty("password"));
    By loginBtn = By.id(GlobalConfigLocators.getProperty("loginBtn"));
    By SystemLink = By.xpath(GlobalConfigLocators.getProperty("SystemLink"));
    By GlobalConfigLink = By.xpath(GlobalConfigLocators.getProperty("GlobalConfigLink"));
    By jGiveOption = By.xpath(GlobalConfigLocators.getProperty("jGiveOption"));
    By GeneralTab = By.xpath(GlobalConfigLocators.getProperty("GeneralTab"));
    By ForceUsersNo = By.xpath(GlobalConfigLocators.getProperty("ForceUsersNo"));
    By AutoVendorRegisterDropdown = By.xpath(GlobalConfigLocators.getProperty("AutoVendorRegisterDropdown"));
    By AdminApprovalYes = By.xpath(GlobalConfigLocators.getProperty("AdminApprovalYes"));
    By DurationInDaysNo = By.xpath(GlobalConfigLocators.getProperty("DurationInDaysNo"));
    By PaymentTab = By.xpath(GlobalConfigLocators.getProperty("PaymentTab"));
    By GuestDonationNo = By.xpath(GlobalConfigLocators.getProperty("GuestDonationNo"));
    By QuickDonationNo = By.xpath(GlobalConfigLocators.getProperty("QuickDonationNo"));
    By CampaignSettingTab = By.xpath(GlobalConfigLocators.getProperty("CampaignSettingTab"));
    By ShowCampaignActivitiesYes = By.xpath(GlobalConfigLocators.getProperty("ShowCampaignActivitiesYes"));
    By EnableReportNo = By.xpath(GlobalConfigLocators.getProperty("EnableReportNo"));
    By SaveBtn = By.xpath(GlobalConfigLocators.getProperty("SaveBtn"));
    By SuccessMsg = By.xpath(GlobalConfigLocators.getProperty("SuccessMsg"));
    public Default_Global_Config(WebDriver driver) {
        BrowserManager.driver = driver;
    }

    public void username(String un) {
        sendText(driver.findElement(username), un);
    }

    public void password(String pw) {
        sendText(driver.findElement(password), pw);
    }

    public void loginBtn() {
        clickOnElement(driver.findElement(loginBtn));

    }

    public void locateJGiveGlobalConfig()  {
        clickOnElement(driver.findElement(SystemLink));
        clickOnElement(driver.findElement(GlobalConfigLink));
        WebElement element = driver.findElement(jGiveOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickGeneralTab() {
        WebElement element = driver.findElement(GeneralTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickForceUsersNo() {
        WebElement element = driver.findElement(ForceUsersNo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void SelectAutoVendorRegisterDropdownYes() {
        WebElement element = driver.findElement(AutoVendorRegisterDropdown);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Yes");
    }

    public void clickAdminApprovalYes() {
        WebElement element = driver.findElement(AdminApprovalYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickDurationInDaysNo() {
        WebElement element = driver.findElement(DurationInDaysNo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickPaymentTab() {
        WebElement element = driver.findElement(PaymentTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickGuestDonationNo() {
        WebElement element = driver.findElement(GuestDonationNo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickQuickDonationNo() {
        WebElement element = driver.findElement(QuickDonationNo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickCampaignSettingTab() {
        WebElement element = driver.findElement(CampaignSettingTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }

    public void clickShowCampaignActivitiesYes() {
        WebElement element = driver.findElement(ShowCampaignActivitiesYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickEnableReportNo() {

        WebElement element = driver.findElement(EnableReportNo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickSaveBtn() {
        clickOnElement(driver.findElement(SaveBtn));

    }

    public Boolean validateWebElement(String element) {
        switch (element) {
            case "Save Button":
                return driver.findElement(SaveBtn).isDisplayed();
        }

        return null;

    }

    public String validateMessage(String msg) {
        switch (msg) {
            case "SuccessMessage":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }
}
