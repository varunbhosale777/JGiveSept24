package test.global_config_tests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.global_config_tests.Global_Config_1;
import pom.global_config_tests.Global_Config_2;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Global_Config_2_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    public static String FEUser = generateRandomUsername();
    public static String FEEmail = generateRandomEmail();
    @BeforeSuite
    public void generateReport() {

        Reporter.setupReport("JGIVE_Test_Report");
    }
    @BeforeMethod
    public void setupOpen() throws Exception {
        logger.info("Setting up the browser...");
        browserRun();
        waitFor(15);
    }
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Global_Config_1 failed. Capturing Screenshot...");
            tss.screenshot(driver, "Global_Config_1 test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
        logger.info("Closing Browser");
        driver.quit();
    }
    @Test
    public void Global_Config_2_Tests(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        logStep("Executing Global_Config_2_Test Test Cases");

         
        Global_Config_2 GC = PageFactory.initElements(driver, Global_Config_2.class);
        logStep( "Steps performed according to Global_Config_2 Test Cases");

        openBEUrl();

        logStep("Entering Username");
        GC.username(BEusername);

        logStep("Entering Password");
        GC.password(BEpassword);

        logStep("Clicking Login");
        GC.loginBtn();

        logStep("Clicking System");
        logStep("Clicking Global Config Link");
        logStep("Clicking JGive");
        GC.locateJGiveGlobalConfig();
        logStep("Clicking CampaignTypeDonation");
        GC.clickCampaignTypeDonation();

        logStep("Click Admin Approval No");
        GC.clickAdminApprovalNo();

        logStep("Clicking DurationInDaysYes");
        GC.clickDurationInDaysYes();




        logStep("Clicking Save");
        GC.clickSaveBtn();

        logStep("Verifying Save");
        Assert.assertEquals(GC.validateMessage("SaveMessage"),"Configuration saved.","Error Locating");

        openFEURL();

        logStep("Clicking Register Menu");
        GC.locateRegisterMenu();

        logStep("Entering Username");
        GC.enterUsername(FEUser);

        logStep("Entering Email");
        GC.enterEmail(FEEmail);

        logStep("Entering Confirm Email");
        GC.enterConfirmEmail(FEEmail);

        logStep("Clicking Signup");
        GC.clickSignup();
        GC.verifyRegistration();

        logStep("Clicking Create Campaign");
        GC.locateCreateCampaign();

        logStep("Entering Campaign Title");
        GC.enterCampaignTitle();

        logStep("Entering Campaign Start Date");
        GC.enterStartDate();

        logStep("Verifying end date is in days");
        GC.verifyEndDateLabel();

        logStep("Uploading Campaign Display Image");
        GC.uploadImage();

        logStep("Selecting Org/Ind Type");
        GC.selectOrgIndType();

        logStep("Entering Campaign Goal Amount");
        GC.enterGoalAmount();

        logStep("Entering Campaign Min Donation Amount");
        GC.enterMinDonationAmount();

        logStep("Entering Campaign Max Donation Amount");
        GC.enterMaxDonationAmount();

        logStep("Clicking Add Giveback Button");
        GC.clickAddGiveback();

        logStep("Entering Giveback Title");
        GC.enterGivebackTitle();

        logStep("Entering Minimum Donation Amount to Avail Giveback");
        GC.enterMinGivebackAmount();

        logStep("Entering Total Giveback Amount");
        GC.enterTotalGivebackAmount();

        logStep("Clicking Submit to Save Campaign");
        GC.clickSubmit();

        logStep("Verify Campaign Save");
        Assert.assertTrue(GC.validateWebElement("Save"),"Error Locating");


        stopTimer("Global_Config_2 Test Cases Execution Completed");
    }
}
