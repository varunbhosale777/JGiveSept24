package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_CM_CTC_BCTC;
import pom.smoke_test_BE.CM_CTC_BCTC;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_CM_CTC_BCTC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test CM_CTC_BCTC failed. Capturing Screenshot...");
            tss.screenshot(driver, "CM_CTC_BCTC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Neg_CM_CTC_BCTC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_CM_CTC_BCTC BCTC = PageFactory.initElements(driver, Neg_CM_CTC_BCTC.class);
       logStep( "Steps performed according to Neg_CM_CTC_BCTC Test Cases");
        openBEUrl();
        logStep("Locating Categories");
        BCTC.locateCategories();
        logStep("Clicking New Button");
        BCTC.clickNew();
        logStep("Clicking Save");
        BCTC.clickSave();
        logStep("Validating Error Message ");
        Assert.assertTrue(BCTC.validateMessage("Error").contains("missing required data."),"Error Locating");

        stopTimer("Neg_CM_CTC_BCTC Test Cases Execution Completed");
    }
}
