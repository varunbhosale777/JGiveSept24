package pom.smoke_test_BE;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
public class CM_CC_BCC extends BrowserManager {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    public CM_CC_BCC(WebDriver driver) {
        this.driver = driver;
    }
    
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    PropertiesFileManager loader = PropertiesFileManager.getInstance();
    Properties BCCLocators = loader.getProperties("CM_CC_BCCLocators.properties");
    
    String pageTitle = BCCLocators.getProperty("pageTitle");
    By Components = By.xpath(BCCLocators.getProperty("Components"));
    By JGive = By.xpath(BCCLocators.getProperty("JGive"));
    By Campaigns = By.xpath(BCCLocators.getProperty("Campaigns"));
    By NewBtn = By.xpath(BCCLocators.getProperty("NewBtn"));
    By saveBtn = By.xpath(BCCLocators.getProperty("saveBtn"));
    By saveSuccessfulMSG = By.xpath(BCCLocators.getProperty("saveSuccessfulMSG"));
    By actualCampaignTitle = By.xpath(BCCLocators.getProperty("actualCampaignTitle"));
    By titleTxt = By.id(BCCLocators.getProperty("titleTxt"));
    By aliasTxt = By.id(BCCLocators.getProperty("aliasTxt"));
    By org_ind_DropDown = By.id(BCCLocators.getProperty("org_ind_DropDown"));
    By categoryDropDown = By.id(BCCLocators.getProperty("categoryDropDown"));
    By uploadImage = By.id(BCCLocators.getProperty("uploadImage"));
    By start_date = By.id(BCCLocators.getProperty("start_date"));
    By end_date = By.id(BCCLocators.getProperty("end_date"));
    By goal_amt = By.id(BCCLocators.getProperty("goal_amt"));
    By min_amt = By.id(BCCLocators.getProperty("min_amt"));
    By givebacksTab = By.linkText(BCCLocators.getProperty("givebacksTab"));
    By addGivebackbtn = By.xpath(BCCLocators.getProperty("addGivebackbtn"));
    By givebackTitle = By.id(BCCLocators.getProperty("givebackTitle"));
    By minAmountGiveback = By.id(BCCLocators.getProperty("minAmountGiveback"));
    By totalGiveback = By.id(BCCLocators.getProperty("totalGiveback"));
    By givebackImage = By.id(BCCLocators.getProperty("givebackImage"));
    By galleryTab = By.linkText(BCCLocators.getProperty("galleryTab"));
    By galleryImage = By.id(BCCLocators.getProperty("galleryImage"));
    By SelectUserBtn = By.xpath(BCCLocators.getProperty("SelectUserBtn"));
    public static String targetUsername = UserName;
    By iframe = By.cssSelector("#userModal_jform_creator_id .iframe");
    
    
    public void locateCampaigns() throws InterruptedException {
        clickOnElement(driver.findElement(Components));
        clickOnElement(driver.findElement(JGive));
        clickOnElement(driver.findElement(Campaigns));

    }
    
    public void validateCorrectPage() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("JGive: Campaigns"),"Error Locating");
    }
    public void clickNew() {
        clickOnElement(driver.findElement(NewBtn));
    }
    public void clickSelectUser() {

        clickOnElement(driver.findElement(SelectUserBtn));
    }
    public void clickUsername() {
        WebElement iframeElement = driver.findElement(iframe);
        driver.switchTo().frame(iframeElement);
        
        WebElement table = driver.findElement(By.cssSelector("table.table.table-sm"));
        
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            
            WebElement nameCell = row.findElement(By.cssSelector("th a.pointer.button-select"));
            
            String name = nameCell.getText();
            
            if (name.equals(targetUsername)) {
                clickOnElement(nameCell);
                driver.switchTo().defaultContent();
                logStep("Clicked on user: " + name);
                break;
            }
        }
    }
    public void enterTitle(String text) {
        sendText(driver.findElement(titleTxt), text);
    }


    public void enterAlias(String text) {
        sendText(driver.findElement(aliasTxt), text);
    }
    public void select_org_ind_DropDown(String text) {

        WebElement element = driver.findElement(org_ind_DropDown);
        Select dropdown1 = new Select(element);
        dropdown1.selectByVisibleText(text);
    }
    public void select_categoryDropDown(String text) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(categoryDropDown);
        Select dropdown1 = new Select(element);
        dropdown1.selectByVisibleText(text);
    }
    public void uploadImage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 800)");
        String imagePath = "src/test/java/test/resources/media/image1.jpg";
        File file = new File(imagePath);
        String absPath = file.getAbsolutePath();
        sendText(driver.findElement(uploadImage), absPath);
    }
    public void enterStartDate(String text) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1300)");
        sendText(driver.findElement(start_date), text);
    }
    public void enterEndDate(String text) {
        sendText(driver.findElement(end_date), text);
    }
    public void enterGoalAmt(int number) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 1800)");
        driver.findElement(goal_amt).clear();
        sendText(driver.findElement(goal_amt), String.valueOf(number));
    }
    public void enterMinAmt(int number) {
        driver.findElement(min_amt).clear();
        sendText(driver.findElement(min_amt), String.valueOf(number));
    }

    public void clickGivebacks()  {
        WebElement element = driver.findElement(givebacksTab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void clickAddGiveback() {
        clickOnElement(driver.findElement(addGivebackbtn));

    }
    public void enterGivebackTitle(String giveBackTitle) {
        sendText(driver.findElement(givebackTitle), giveBackTitle);
    }
    public void enterMinAmountGiveback(int giveBackMinAmount) {
        driver.findElement(minAmountGiveback).clear();
        sendText(driver.findElement(minAmountGiveback), String.valueOf(giveBackMinAmount));
    }
    public void enterTotalGivebacks(int totalGivebackAmt) {
        driver.findElement(totalGiveback).clear();
        sendText(driver.findElement(totalGiveback), String.valueOf(totalGivebackAmt));
    }
    public void uploadGivebackFile() {
        String imagePath = "src/test/java/test/resources/media/image1.jpg";
        File file = new File(imagePath);
        String absPath = file.getAbsolutePath();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 300)");
        sendText(driver.findElement(givebackImage), absPath);
    }
    public void clickGallery() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        clickOnElement(driver.findElement(galleryTab));

    }
    public void uploadGalleryImg() {
        String imagePath = "src/test/java/test/resources/media/image1.jpg";
        File file = new File(imagePath);
        String absPath = file.getAbsolutePath();
        sendText(driver.findElement(galleryImage), absPath);
    }
    public void clickSave() throws InterruptedException {
        clickOnElement(driver.findElement(saveBtn));

        Thread.sleep(2000);
    }

    public Boolean validateWebElement(String element) {
        switch (element) {
            case "Save":
                return driver.findElement(saveSuccessfulMSG).isDisplayed();
        }

        return null;

    }

}
