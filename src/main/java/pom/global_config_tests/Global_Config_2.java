package pom.global_config_tests;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
public class Global_Config_2 extends BrowserManager {
    static String locatorsPath=System.getProperty("user.dir")+"/src/test/java/test/resources/locators/global_config/";
    public Global_Config_2(WebDriver driver)
    {
        BrowserManager.driver=driver;
    }
    
    static
    {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader=PropertiesFileManager.getInstance();
    Properties GlobalConfigLocators=loader.getProperties("GlobalConfig2Locators.properties");
    
    
    By username = By.id(GlobalConfigLocators.getProperty("username"));
    By password = By.id(GlobalConfigLocators.getProperty("password"));
    By loginBtn = By.id(GlobalConfigLocators.getProperty("loginBtn"));
    By SystemLink=By.xpath(GlobalConfigLocators.getProperty("SystemLink"));
    By GlobalConfigLink=By.xpath(GlobalConfigLocators.getProperty("GlobalConfigLink"));
    By jGiveOption=By.xpath(GlobalConfigLocators.getProperty("jGiveOption"));
    By AdminApprovalNo=By.xpath(GlobalConfigLocators.getProperty("AdminApprovalNo"));
    By DurationInDaysYes=By.xpath(GlobalConfigLocators.getProperty("DurationInDaysYes"));
    By CampaignTypeDonation=By.xpath(GlobalConfigLocators.getProperty("CampaignTypeDonation"));
    By SaveBtn=By.xpath(GlobalConfigLocators.getProperty("SaveBtn"));
    By ConfigSaveSuccessMsg=By.xpath(GlobalConfigLocators.getProperty("ConfigSaveSuccessMsg"));
    
    By RegisterMenu= By.xpath(GlobalConfigLocators.getProperty("RegisterMenu"));
    By UsernameTxtField=By.xpath(GlobalConfigLocators.getProperty("UsernameTxtField"));
    By UserEmailTxtField=By.xpath(GlobalConfigLocators.getProperty("UserEmailTxtField"));
    By ConfirmUserEmailTxtField= By.xpath(GlobalConfigLocators.getProperty("ConfirmUserEmailTxtField"));
    By SignupBtn=By.xpath(GlobalConfigLocators.getProperty("SignupBtn"));
    By SuccessMsg=By.xpath(GlobalConfigLocators.getProperty("SuccessMsg"));
    By CreateCampaign=By.xpath(GlobalConfigLocators.getProperty("CreateCampaign"));
    By CampaignTitle = By.xpath(GlobalConfigLocators.getProperty("CampaignTitle"));
    By StartDate = By.xpath(GlobalConfigLocators.getProperty("StartDate"));
    By DaysLabel = By.xpath(GlobalConfigLocators.getProperty("DaysLabel"));
    By UploadImage=By.xpath(GlobalConfigLocators.getProperty("UploadImage"));
    By OrgIndType = By.xpath(GlobalConfigLocators.getProperty("OrgIndType"));
    By GoalAmount = By.xpath(GlobalConfigLocators.getProperty("GoalAmount"));
    By MinAmount = By.xpath(GlobalConfigLocators.getProperty("MinAmount"));
    By MaxDonation = By.xpath(GlobalConfigLocators.getProperty("MaxDonation"));
    By AddGiveBack = By.xpath(GlobalConfigLocators.getProperty("AddGiveBack"));
    By GiveBackTitle = By.xpath(GlobalConfigLocators.getProperty("GiveBackTitle"));
    By MinGivebackAmount = By.xpath(GlobalConfigLocators.getProperty("MinGivebackAmount"));
    By TotalGivebackAmount = By.xpath(GlobalConfigLocators.getProperty("TotalGivebackAmount"));
    By SubmitButton = By.xpath(GlobalConfigLocators.getProperty("SubmitButton"));
    By SuccessMsgForCampaign = By.xpath(GlobalConfigLocators.getProperty("SuccessMsgForCampaign"));
    
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

    public void clickCampaignTypeDonation() throws InterruptedException {
        waitFor(5);
        Thread.sleep(2000);
        WebElement element = driver.findElement(CampaignTypeDonation);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        clickOnElement(element);
    }


    public void clickAdminApprovalNo()  {
        WebElement element = driver.findElement(AdminApprovalNo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void clickDurationInDaysYes() {

        WebElement element = driver.findElement(DurationInDaysYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickSaveBtn(){
        clickOnElement(driver.findElement(SaveBtn));
    }

    
    public void locateRegisterMenu() throws InterruptedException {
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
    public void verifyRegistration()
    {
        String msg=driver.findElement(SuccessMsg).getText();
        Assert.assertTrue(msg.contains("A user account has been created for you & the access details have been emailed at the address provided."),"Registration Failed");
    }
    public void locateCreateCampaign()
    {
        clickOnElement(driver.findElement(CreateCampaign));

    }
    public void enterCampaignTitle()
    {
        sendText(driver.findElement(CampaignTitle), BrowserManager.generateRandomCampaignTitle());

    }
    public void enterStartDate()
    {
        
        LocalDateTime now = LocalDateTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        String formattedDateTime = now.format(formatter);
        WebElement element=driver.findElement(StartDate);
        element.clear();
        sendText(element, formattedDateTime);
    }
    public void verifyEndDateLabel()
    {
        Assert.assertTrue(driver.findElement(DaysLabel).isDisplayed(),"Error Locating");
    }
    public void uploadImage()
    {
        String imagePath = "src/test/java/test/resources/media/image1.jpg";
        File file = new File(imagePath);
        String absPath = file.getAbsolutePath();
        sendText(driver.findElement(UploadImage), absPath);
    }
    public void selectOrgIndType()
    {
        scrollDown(500);
        WebElement element=driver.findElement(OrgIndType);
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText("Individuals ");
    }
    public void enterGoalAmount()
    {
        WebElement element = driver.findElement(GoalAmount);
        element.clear();
        sendText(element, "1200000");
    }
    public void enterMinDonationAmount()
    {
        WebElement element = driver.findElement(MinAmount);
        element.clear();
        sendText(element, "100");
    }
    public void enterMaxDonationAmount()
    {
        WebElement element = driver.findElement(MaxDonation);
        element.clear();
        sendText(element, "1000");
    }
    public void clickAddGiveback() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(2000);
        clickOnElement(driver.findElement(AddGiveBack));

        Thread.sleep(2000);
    }
    public void enterGivebackTitle() {
        scrollToBottom();
        sendText(driver.findElement(GiveBackTitle), BrowserManager.generateGivebackTitle());

    }
    public void enterMinGivebackAmount() {
        scrollToBottom();
        WebElement element = driver.findElement(MinGivebackAmount);
        element.clear();
        sendText(element, "100");
    }
    public void enterTotalGivebackAmount() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(3000);
        WebElement element = driver.findElement(TotalGivebackAmount);
        element.clear();
        sendText(element, "10");
    }
    public void clickSubmit() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(2000);
        clickOnElement(driver.findElement(SubmitButton));

        Thread.sleep(3000);
    }



    public Boolean validateWebElement(String element) throws InterruptedException {
        switch (element) {

            case "Save":
                Thread.sleep(3000);
                return driver.findElement(SuccessMsgForCampaign).isDisplayed();

        }

        return null;

    }


    public String validateMessage(String msg) {
        switch (msg) {

            case "SaveMessage":
                return driver.findElement(ConfigSaveSuccessMsg).getText();
        }

        return null;
    }
}
