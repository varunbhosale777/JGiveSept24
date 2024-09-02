package test.regression_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_FE.Neg_ODM_ODC_FODC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_ODM_ODC_FODC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  Neg_ODM_ODC_FODC_Test failed. Capturing Screenshot...");
            tss.screenshot(driver, " Neg_ODM_ODC_FODC_Test test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void New_ODM_ODC_FODC_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_ODM_ODC_FODC FODC = PageFactory.initElements(driver, Neg_ODM_ODC_FODC.class);
       logStep( "Steps performed according to  Neg_ODM_ODC_FODC_Test Test Cases");
        openFEURL();
        logStep("Clicking Create Organization Contact");
        FODC.locateCreateOrganizationContact();
        logStep("Clicking Submit Button");
        FODC.clickSubmit();
        logStep("Verifying Error message");
        Assert.assertTrue(FODC.validateMessage("Error").contains("The form cannot be submitted as it's missing required data."),"Error Locating");


        stopTimer("Neg_ODM_ODC_FODC_Test Cases Execution Completed");
    }
}
