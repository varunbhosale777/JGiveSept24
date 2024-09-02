package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.VM_VC_FUVD;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class VM_VC_FUVD_Test extends BrowserManager {
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
    public void VM_VC_FUVD_Test_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        VM_VC_FUVD FUVD = PageFactory.initElements(driver, VM_VC_FUVD.class);
       logStep( "Steps performed according to  VM_VC_FUVD Test Cases");
        openFEURL();
        logStep("Clicking VendorProfile");
        FUVD.locateVendorProfile();
 
 
        logStep("Clicking Update Profile");
        FUVD.clickUpdateProfile();
        logStep("Updating Vendor Name");
        FUVD.enterVendorName();
        logStep("Clicking Submit Button");
        FUVD.clickSubmit();
        logStep("Verifying New Vendor Name");
        FUVD.verifyNewVendorName();
        stopTimer("VM_VC_FUVD Test Cases Execution Completed");
    }
}
