package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.DM_AD_BAD;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class DM_AD_BAD_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test DM_AD_BAD_Test failed. Capturing Screenshot...");
            tss.screenshot(driver, "DM_AD_BAD_Test test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
     
    @Test
    public void DM_AD_BAD_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        UM_LOGN_BLG BE_Login = PageFactory.initElements(driver, UM_LOGN_BLG.class);
        DM_AD_BAD BAD = PageFactory.initElements(driver, DM_AD_BAD.class);
       logStep( "Steps performed according to DM_AD_BAD_Test Test Cases");
         
        
        openBEUrl();
        logStep("Locating Donation");
        BAD.locateDonatino();
        logStep("Validate Correct Page");
        BAD.validateCorrectPage();
        logStep("Clicking New");
        BAD.clickNew();
        logStep("Entering Donor Text");
        BAD.enterDonorText(IND_Donor);
        logStep("Selecting Donor");
        BAD.selectDonor();
        logStep("Clicking Select Campaign Button");
        BAD.clickSelectCampaignBtn();
        logStep("Selecting Campaign");
        BAD.selectCampaign();
        logStep("Selecting Donation Status");
        BAD.selectDonationStatus();
        logStep("Clicking Save Donation Button");
        BAD.clickSaveDonation();
        Assert.assertTrue(BAD.validateMessage("Locate").contains("Donation is done successfully."),"Error Locating");
        stopTimer("DM_AD_BAD Test Cases Execution Completed");
    }
}
