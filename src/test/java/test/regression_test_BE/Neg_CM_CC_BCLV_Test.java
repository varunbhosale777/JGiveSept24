package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_CM_CC_BCLV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_CM_CC_BCLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_CM_CC_BCLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_CM_CC_BCLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void CM_CC_BCLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_CM_CC_BCLV BCLV = PageFactory.initElements(driver, Neg_CM_CC_BCLV.class);
       logStep( "Steps performed according to Neg_CM_CC_BCLV Test Cases");
        BCLV.openBEUrl();
        logStep("Locating Campaigns ");
        BCLV.locateCampaigns();
        logStep("Entering Search Title");
        BCLV.enterSearchTitle();
        logStep("Clicking Search Button");
        BCLV.clickSearchBtn();
        logStep("Validating Search");
        Assert.assertTrue(BCLV.validateMessage("Error").contains("No matching results found."),"Error Locating");
        logStep("Clicking Clear Button");
        BCLV.clickClearBtn();
        stopTimer("Neg_CM_CC_BCLV Test Cases Execution Completed");
    }
}
