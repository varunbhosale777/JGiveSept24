package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_ODM_ODC_BODLV;
import pom.smoke_test_BE.ODM_ODC_BODLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_ODM_ODC_BODLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_ODM_ODC_BODLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_ODM_ODC_BODLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    @Test
    public void Neg_ODM_ODC_BODLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_ODM_ODC_BODLV BODLV = PageFactory.initElements(driver, Neg_ODM_ODC_BODLV.class);
       logStep( "Steps performed according to Neg_ODM_ODC_BODLV Test Cases");
         
        openBEUrl();
        logStep("Locating Organization Donors");
        BODLV.locateOrgDonors();
        logStep("Entering Search Query");
        BODLV.enterSearchQuery();
        logStep("Clicking Search Button");
        BODLV.clickSearchBtn();
        logStep("Verify Error Message");
        Assert.assertTrue(BODLV.validateMessage("Error").contains("No matching results found."),"Error Locating");
        logStep("Clicking Clear Button");
        BODLV.clickClearBtn();
        stopTimer("Neg_ODM_ODC_BODLV Test Cases Execution Completed");
    }
}
