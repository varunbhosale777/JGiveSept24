package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_ODM_ODC_BODC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_ODM_ODC_BODC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_ODM_ODC_BODC failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_ODM_ODC_BODC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    @Test
    public void Neg_ODM_ODC_BODC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_ODM_ODC_BODC BODC = PageFactory.initElements(driver, Neg_ODM_ODC_BODC.class);
       logStep( "Steps performed according to Neg_ODM_ODC_BODC Test Cases");
        openBEUrl();
        logStep("Locating Organization Donors");
        BODC.locateOrgDonors();
        logStep("Clicking New");
        BODC.clickNew();
        logStep("Clicking Save");
        BODC.saveAndClose();
        logStep("Verifying Error Message");
        Assert.assertTrue(BODC.validateMessage("Error").contains("missing required data."),"Error Locating");

        stopTimer("Neg_ODM_ODC_BODC Test Cases Execution Completed");
    }
}
