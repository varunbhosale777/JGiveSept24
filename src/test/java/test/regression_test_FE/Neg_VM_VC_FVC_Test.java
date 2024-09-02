package test.regression_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_FE.Neg_VM_VC_FVC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_VM_VC_FVC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  VM_VC_FVC failed. Capturing Screenshot...");
            tss.screenshot(driver, " VM_VC_FVC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Blank_Neg_VM_VC_FVC_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_VM_VC_FVC FVC = PageFactory.initElements(driver, Neg_VM_VC_FVC.class);
       logStep( "Steps performed according to Blank Neg_VM_VC_FVC Test Cases");
        openFEURL();
        logStep("Clicking Vendor Profile");
        FVC.locateVendorProfile();
        logStep("Clicking Submit");
        FVC.clickSubmit();
        logStep("Verifying Submit");
        Assert.assertTrue(FVC.validateMessage("Error").contains("The form cannot be submitted as it's missing required data."),"Error Locating");
        stopTimer("Blank Neg_VM_VC_FVC Test Cases Execution Completed");
    }
}
