package pom.global_config_tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
public class Global_Config_3 extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/global_config/";
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties GlobalConfigLocators = loader.getProperties("GlobalConfig3Locators.properties");
    
    
    
    By username = By.id(GlobalConfigLocators.getProperty("username"));
    By password = By.id(GlobalConfigLocators.getProperty("password"));
    By loginBtn = By.id(GlobalConfigLocators.getProperty("loginBtn"));
    By SystemLink=By.xpath(GlobalConfigLocators.getProperty("SystemLink"));
    By GlobalConfigLink=By.xpath(GlobalConfigLocators.getProperty("GlobalConfigLink"));
    By jGiveOption=By.xpath(GlobalConfigLocators.getProperty("jGiveOption"));
    By PaymentTab = By.xpath(GlobalConfigLocators.getProperty("PaymentTab"));
    By GuestDonationYes = By.xpath(GlobalConfigLocators.getProperty("GuestDonationYes"));
    By QuickDonationYes = By.xpath(GlobalConfigLocators.getProperty("QuickDonationYes"));
    By CampaignSettingTab = By.xpath(GlobalConfigLocators.getProperty("CampaignSettingTab"));
    By ShowCampaignActivitiesNo = By.xpath(GlobalConfigLocators.getProperty("ShowCampaignActivitiesNo"));
    By EnableReportYes = By.xpath(GlobalConfigLocators.getProperty("EnableReportYes"));
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
    By AllCampaigns = By.xpath(GlobalConfigLocators.getProperty("AllCampaigns"));
    By Donate = By.xpath(GlobalConfigLocators.getProperty("Donate"));
    By DonorName = By.xpath(GlobalConfigLocators.getProperty("DonorName"));
    By DonorEmail = By.xpath(GlobalConfigLocators.getProperty("DonorEmail"));
    By NextBtn = By.xpath(GlobalConfigLocators.getProperty("NextBtn"));
    By ByChequeRadio = By.xpath(GlobalConfigLocators.getProperty("ByChequeRadio"));
    By ConfirmOrder = By.xpath(GlobalConfigLocators.getProperty("ConfirmOrder"));
    By AllDonationsLink = By.xpath(GlobalConfigLocators.getProperty("AllDonationsLink"));
    By PaymentStatus = By.xpath(GlobalConfigLocators.getProperty("PaymentStatus"));
    By DonorsLink = By.xpath(GlobalConfigLocators.getProperty("DonorsLink"));
    By DonationReceived = By.xpath(GlobalConfigLocators.getProperty("DonationReceived"));
    By MyDonations = By.xpath(GlobalConfigLocators.getProperty("MyDonations"));
    By MyDonations_DonationReceived = By.xpath(GlobalConfigLocators.getProperty("MyDonations_DonationReceived"));
    By SearchIcon = By.xpath(GlobalConfigLocators.getProperty("SearchIcon"));
    By SearchBox = By.xpath(GlobalConfigLocators.getProperty("SearchBox"));
    
    
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
    public void clickPaymentTab() {
        clickOnElement(driver.findElement(PaymentTab));
    }
    public void clickGuestDonationYes()  {

        WebElement element = driver.findElement(GuestDonationYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void clickQuickDonationYes() {
        WebElement element = driver.findElement(QuickDonationYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void clickCampaignSettingTab()  {
        WebElement element = driver.findElement(CampaignSettingTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }
    public void clickShowCampaignActivitiesNo() {

        WebElement element = driver.findElement(ShowCampaignActivitiesNo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void clickEnableReportYes() {
        WebElement element = driver.findElement(EnableReportYes);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void clickSaveBtn() throws InterruptedException {
        WebElement element = driver.findElement(SaveBtn);
        clickOnElement(element);
    }
    
    public void locateRegisterMenu()
    {
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

    public void locateCreateCampaign()
    {
        clickOnElement(driver.findElement(CreateCampaign));

    }
    public void enterCampaignTitle()
    {
        sendText(driver.findElement(CampaignTitle), BrowserManager.CampaignTitle);
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
    public void enterGivebackTitle() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(3000);
        sendText(driver.findElement(GiveBackTitle), BrowserManager.generateGivebackTitle());

    }
    public void enterMinGivebackAmount() throws InterruptedException {
        scrollToBottom();
        Thread.sleep(3000);
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
        clickOnElement(driver.findElement(SubmitButton));

        Thread.sleep(3000);
    }

    
    public void locateAllCampaigns() throws InterruptedException {
        clickOnElement(driver.findElement(AllCampaigns));

    }

    public void clickDonate()
    {
        clickOnElement(driver.findElement(Donate));

    }
    public void enterDonorName()
    {
        sendText(driver.findElement(DonorName), BrowserManager.generateRandomIDonor());

    }
    public void enterDonorEmail()
    {
        sendText(driver.findElement(DonorEmail), BrowserManager.generateRandomEmail());

    }
    public void clickPayByRadio() throws InterruptedException {

        clickOnElement(driver.findElement(ByChequeRadio));

    }
    public void clickNextBtn() throws InterruptedException
    {
        scrollDown(1000);
        clickOnElement(driver.findElement(NextBtn));

    }
    public void clickConfirmOrder() throws InterruptedException {
        scrollToBottom();
        WebElement element2 = BrowserManager.waitForElementToBeVisible(ConfirmOrder, 30);
        if (element2 != null) {
            scrollToBottom();
            clickOnElement(element2);


        }
        else
        {
            logStep("Failed to Locate : ConfirmOrder Element");
        }
    }
    public void verifySubmit() throws InterruptedException
    {
        Thread.sleep(3000);
        String msg = driver.findElement(SuccessMsg).getText();
        Assert.assertTrue(msg.contains("Thank you for your donation"),"Error Locating");
    }
    public void locateAllDonations()
    {
        clickOnElement(driver.findElement(AllDonationsLink));

    }
    public void selectConfirmed() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element=driver.findElement(PaymentStatus);
        Select dropdown=new Select(element);
        dropdown.selectByVisibleText("Confirmed");
        Thread.sleep(3000);
    }
    public void locateDonors()
    {
        clickOnElement(driver.findElement(DonorsLink));

    }
    public void verifyDonorsDonationAmount()
    {
        String donation=driver.findElement(DonationReceived).getText();
        Assert.assertTrue(donation.contains("100"),"Donation Not Matched");
    }
    public void locateMyDonations()
    {
        clickOnElement(driver.findElement(MyDonations));

    }
    public void verifyMyDonationAmount()
    {
        String donation=driver.findElement(MyDonations_DonationReceived).getText();
        Assert.assertTrue(donation.contains("100"),"Donation Not Matched");
    }
    public void searchCampaign() throws InterruptedException {

        clickOnElement(driver.findElement(SearchIcon));
        sendText(driver.findElement(SearchBox), BrowserManager.CampaignTitle);
        clickOnElement(driver.findElement(SearchIcon));

    }


    public Boolean validateWebElement(String element) throws InterruptedException {
        switch (element) {

            case "Save":
                Thread.sleep(3000);
                return driver.findElement(SuccessMsgForCampaign).isDisplayed();


        }

        return false;

    }


    public String validateMessage(String msg) {
        switch (msg) {

            case "SaveMessage":
                return driver.findElement(ConfigSaveSuccessMsg).getText();
            case "Register":
                return driver.findElement(SuccessMsg).getText();
        }

        return null;
    }



}
