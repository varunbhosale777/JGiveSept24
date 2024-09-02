package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_VM_VC_VDV;
import pom.smoke_test_BE.VM_VC_VDV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_VM_VC_VDV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test VM_VC_VDV failed. Capturing Screenshot...");
            tss.screenshot(driver, "VM_VC_VDV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
     
    @Test
    public void Neg_VM_VC_VDV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_VM_VC_VDV VDV = PageFactory.initElements(driver, Neg_VM_VC_VDV.class);
        logStep( "Steps performed according to Neg_VM_VC_VDV Test Cases");
         
        openBEUrl();
        logStep("Locating Vendors");
        VDV.locateVendors();
        logStep("Entering Vendor Title to Search");
        VDV.enterSearchTitle();
        logStep("Clicking Search Button");
        VDV.clickSearchBtn();
        logStep("Validating Search Result for Blank Title");
        Assert.assertTrue(VDV.validateMessage("Error").contains("No record found"),"Error Locating");
        logStep("Clicking Clear Search Btn");
        VDV.clickClearBtn();
        stopTimer("Neg_VM_VC_VDV Test Cases Execution Completed");
    }
}
