package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.UM_LOGN_BLG;
import pom.smoke_test_BE.CM_CC_BCC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class CM_CC_BCC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test CM_CC_BCC_1 failed. Capturing Screenshot...");
            tss.screenshot(driver, "CM_CC_BCC_1 test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    static String aliasTxt = generateRandomAlias();
    static String start_date = generateStartDate();
    static String end_date = generateEndDate();
    static int goal_amt = generateGoalAmount();
    static String Individuals = "Individuals";
    static String giveBackTitle = generateGivebackTitle();
    static int giveBackMinAmount = generateMinGiveback();
    static int totalGiveback = generateTotalGiveback();

    @Test
    public void CM_CC_BCC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());

        CM_CC_BCC bcc = PageFactory.initElements(driver, CM_CC_BCC.class);
        logStep( "Steps performed according to CM_CC_BCC Test Cases");
        openBEUrl();

        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Campaigns");
        bcc.locateCampaigns();

        logStep("Validating correct page");
        bcc.validateCorrectPage();

        logStep("Clicking new");
        bcc.clickNew();

        logStep("Clicking Select User");
        bcc.clickSelectUser();

        bcc.clickUsername();

        logStep("Entering Title");
        bcc.enterTitle(CampaignTitle);

        logStep("Entering Alias");
        bcc.enterAlias(aliasTxt);

        logStep("Selecting Organization/Individual Type");
        bcc.select_org_ind_DropDown(Individuals);

        logStep("Selecting Category");
        bcc.select_categoryDropDown(CategoryTitle);

        logStep("Uploading Display Image");
        bcc.uploadImage();

        logStep("Entering Start Date");
        bcc.enterStartDate(start_date);

        logStep("Entering End Date");
        bcc.enterEndDate(end_date);

        logStep("Entering Goal amount");
        bcc.enterGoalAmt(goal_amt);

        logStep("Entering Minimum donation/investment amount");
        bcc.enterMinAmt(10);
        
        logStep("Clicking Givebacks");
        bcc.clickGivebacks();

        logStep("Clicking Add Givebacks");
        bcc.clickAddGiveback();

        logStep("Entering Giveback Title");
        bcc.enterGivebackTitle(giveBackTitle);

        logStep("Entering Min amount to avail giveback");
        bcc.enterMinAmountGiveback(giveBackMinAmount);

        logStep("Entering Total giveback");
        bcc.enterTotalGivebacks(totalGiveback);

        logStep("Uploading Image");
        bcc.uploadGivebackFile();

        logStep("Clicking Gallery");
        bcc.clickGallery();

        logStep("Uploading Gallery Img");
        bcc.uploadGalleryImg();

        logStep("Clicking Save and Close");
        bcc.clickSave();

        logStep("Verify Save");
        Assert.assertTrue(bcc.validateWebElement("Save"),"Error Locating");

        stopTimer("CM_CC_BCC Test Cases Execution Completed");
    }
}
