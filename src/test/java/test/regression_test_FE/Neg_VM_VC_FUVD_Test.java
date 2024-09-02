package test.regression_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_FE.Neg_VM_VC_FUVD;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_VM_VC_FUVD_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  VM_VC_FUVD failed. Capturing Screenshot...");
            tss.screenshot(driver, " VM_VC_FUVD test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Neg_VM_VC_FUVD_Test_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_VM_VC_FUVD FUVD = PageFactory.initElements(driver, Neg_VM_VC_FUVD.class);
       logStep( "Steps performed according to  Neg_VM_VC_FUVD Test Cases");
        logStep("Clicking VendorProfile");
        FUVD.locateVendorProfile();
        logStep("Clicking Update Profile");
        FUVD.clickUpdateProfile();
        logStep("Updating Vendor Name To Blank");
        FUVD.enterVendorName();
        logStep("Clicking Submit Button");
        FUVD.clickSubmit();
        logStep("Verifying Error on Updating Blank Vendor Name");
        Assert.assertTrue(FUVD.validateMessage("Error").contains("The form cannot be submitted as it's missing required data."),"Error Locating");
        stopTimer("Neg_VM_VC_FUVD Test Cases Execution Completed");
    }
}
