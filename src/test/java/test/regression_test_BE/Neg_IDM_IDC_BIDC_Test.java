package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_IDM_IDC_BIDC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_IDM_IDC_BIDC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_IDM_IDC_BIDC failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_IDM_IDC_BIDC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    @Test
    public void Neg_IDM_IDC_BIDC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_IDM_IDC_BIDC BIDC = PageFactory.initElements(driver, Neg_IDM_IDC_BIDC.class);
       logStep( "Steps performed according to Neg_IDM_IDC_BIDC Test Cases");
        openBEUrl();
        logStep("Locating Individual Donors");
        BIDC.locateIndividualDonors();
        logStep("Clicking New");
        BIDC.clickNew();
        logStep("Clicking Save");
        BIDC.saveAndClose();
        logStep("Validating Error Message");
        Assert.assertTrue(BIDC.validateMessage("Error").contains("missing required data."),"Error Locating");
        stopTimer("Neg_IDM_IDC_BIDC Test Cases Execution Completed");
    }
}
