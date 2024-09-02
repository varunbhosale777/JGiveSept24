package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_VM_VC_BVC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_VM_VC_BVC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_VM_VC_BVC failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_VM_VC_BVC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }

     
    @Test
    public void Neg_VM_VC_BVC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_VM_VC_BVC BVC = PageFactory.initElements(driver, Neg_VM_VC_BVC.class);
        logStep( "Steps performed according to Neg_VM_VC_BVC Test Cases");
        openBEUrl();
        logStep("Locating Vendors");
        BVC.locateVendors();
        logStep("Clicking new");
        BVC.clickNew();
        logStep("Clicking Save and Close");
        BVC.saveAndClose();
        logStep("Verify Error on Save");
        Assert.assertTrue(BVC.validateMessage("Error").contains("Cannot save a vendor without a user."),"Error Locating");
        stopTimer("Neg_VM_VC_BVC Test Cases Execution Completed");
    }
}
