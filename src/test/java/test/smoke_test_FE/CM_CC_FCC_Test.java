package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.CM_CC_FCC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class CM_CC_FCC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  CM_CC_FCC failed. Capturing Screenshot...");
            tss.screenshot(driver, " CM_CC_FCC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void CM_CC_FCC_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        CM_CC_FCC FCC = PageFactory.initElements(driver, CM_CC_FCC.class);
       logStep( "Steps performed according to  CM_CC_FCC Test Cases");
        openFEURL();
        logStep("Clicking Create Campaign");
        FCC.locateCreateCampaign();
        logStep("Entering Campaign Title");
        FCC.enterCampaignTitle();
        logStep("Entering Campaign Start Date");
        FCC.enterStartDate();
        logStep("Entering Campaign End Date");
        FCC.enterEndDate();
        logStep("Uploading Campaign Display Image");
        FCC.uploadImage();
        logStep("Selecting Org/Ind Type");
        FCC.selectOrgIndType();
        logStep("Entering Campaign Goal Amount");
        FCC.enterGoalAmount();
        logStep("Entering Campaign Min Donation Amount");
        FCC.enterMinDonationAmount();
        logStep("Entering Campaign Max Donation Amount");
        FCC.enterMaxDonationAmount();
        logStep("Clicking Add Giveback Button");
        FCC.clickAddGiveback();
        logStep("Entering Giveback Title");
        FCC.enterGivebackTitle();
        logStep("Entering Minimum Donation Amount to Avail Giveback");
        FCC.enterMinGivebackAmount();
        logStep("Entering Total Giveback Amount");
        FCC.enterTotalGivebackAmount();
        logStep("Clicking Submit to Save Campaign");
        FCC.clickSubmit();
        logStep("Verify Campaign Save");
        Assert.assertTrue(FCC.validateWebElement("Save"),"Error Locating");
        stopTimer("CM_CC_FCC Test Cases Execution Completed");
    }
}
