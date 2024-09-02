package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_CM_CC_BCTLV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_CM_CC_BCTLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_CM_CC_BCTLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_CM_CC_BCTLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    @Test
    public void Neg_CM_CC_BCTLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_CM_CC_BCTLV BCTLV = PageFactory.initElements(driver, Neg_CM_CC_BCTLV.class);
       logStep( "Steps performed according to Neg_CM_CC_BCTLV Test Cases");
        openBEUrl();
        logStep("Locating Categories");
        BCTLV.locateCategories();
        logStep("Entering Category Title to Search");
        BCTLV.enterSearchCategory();
        logStep("Clicking Search Button");
        BCTLV.clickSearchBtn();
        logStep("Validating Search Result");
        Assert.assertTrue(BCTLV.validateMessage("Error").contains("No Matching Results"),"Error Locating");
        logStep("Click Clear Button");
        BCTLV.clickClear();
        stopTimer("Neg_CM_CC_BCTLV Test Cases Execution Completed");
    }
}
