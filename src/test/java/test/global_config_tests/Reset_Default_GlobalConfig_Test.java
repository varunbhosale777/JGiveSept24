package test.global_config_tests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.global_config_tests.Default_Global_Config;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Reset_Default_GlobalConfig_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @BeforeSuite
    public void generateReport() {

        Reporter.setupReport("JGIVE_Test_Report");
    }
    @BeforeMethod
    public void setupOpen() throws Exception {
        logStep("Setting up the browser...");
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
        logStep("Closing Browser");
        driver.quit();
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test(priority = 1)
    public void BE_ResetGlobalConfig_Test_2(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Default_Global_Config GC = PageFactory.initElements(driver, Default_Global_Config.class);
        logStep( "Steps performed according to Reset Default Global Config Test Cases");
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

        logStep("Clicking GeneralTab");
        GC.clickGeneralTab();

        logStep("Clicking ForceUsersNo");
        GC.clickForceUsersNo();

        logStep("Clicking AutoVendorRegisterDropdownYes");
        GC.SelectAutoVendorRegisterDropdownYes();

        logStep("Clicking AdminApprovalYes");
        GC.clickAdminApprovalYes();

        logStep("Clicking DurationInDaysNo");
        GC.clickDurationInDaysNo();

        logStep("Clicking PaymentTab");
        GC.clickPaymentTab();

        logStep("Clicking GuestDonationNo");
        GC.clickGuestDonationNo();

        logStep("Clicking QuickDonationNo");
        GC.clickQuickDonationNo();

        logStep("Clicking CampaignSettingTab");
        GC.clickCampaignSettingTab();

        logStep("Clicking ShowCampaignActivitiesYes");
        GC.clickShowCampaignActivitiesYes();

        logStep("Clicking EnableReportNo");
        GC.clickEnableReportNo();

        logStep("Looking for Save Button");
        Assert.assertTrue(GC.validateWebElement("Save Button"),"Error Locating Save Button");

        logStep("Clicking Save Button");
        GC.clickSaveBtn();

        logStep("Verifying Success Message");
        Assert.assertEquals(GC.validateMessage("SuccessMessage"),"Configuration saved.","Error Saving");


        stopTimer("Reset Default Global Config Execution Completed");
    }
}
