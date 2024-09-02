package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.VM_VC_FVC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.ReadExcelData;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class VM_VC_FVC_Test extends BrowserManager {
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
    public void VM_VC_FVC_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        VM_VC_FVC FVC = PageFactory.initElements(driver, VM_VC_FVC.class);
        logStep( "Steps performed according to  VM_VC_FVC Test Cases");
        openFEURL();
        logStep("Clicking Vendor Profile");
        FVC.locateVendorProfile();
        logStep("Entering Vendor Name");
        FVC.enterVendorName();
        logStep("Entering Phone Number");
        FVC.enterPhoneNumber();
        logStep("Entering Address");
        FVC.enterAddress();
        logStep("Entering Description");
        FVC.enterDescription();
        logStep("Selecting Country");
        FVC.selectCountry();
        logStep("Selecting Region");
        FVC.selectRegion();
        logStep("Selecting City");
        FVC.selectCity();
        logStep("Uploding Image");
        FVC.uploadImage();
        logStep("Entering Tax");
        FVC.enterTax();
        logStep("Entering Website");
        FVC.enterWebsite();
        logStep("Clicking Submit");
        FVC.clickSubmit();
        logStep("Verifying Submit");
        FVC.verifySubmit();
        stopTimer("VM_VC_FVC Test Cases Execution Completed");
    }
}
