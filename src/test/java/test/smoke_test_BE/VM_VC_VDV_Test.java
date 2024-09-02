package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.UM_LOGN_BLG;
import pom.smoke_test_BE.VM_VC_VDV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class VM_VC_VDV_Test extends BrowserManager
{
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
    public void VM_VC_VDV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        VM_VC_VDV VDV = PageFactory.initElements(driver, VM_VC_VDV.class);
        logStep( "Steps performed according to VM_VC_VDV Test Cases");
         
        openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Vendors");
        VDV.locateVendors();
        logStep("Validating correct page");
        VDV.validateCorrectPage();
        logStep("Searching Title");
        VDV.enterSearchTitle(VendorName);
        logStep("Clicking Saerch Button");
        VDV.clickSearchBtn();
        logStep("Validating Search Result");
        VDV.validateSearchTitle(VendorName);
        logStep("Selecting Vendor");
        VDV.clickCheckBox01();
        logStep("Clicking Actions");
        VDV.clickActions();
        logStep("Clicking Unpublish");
        VDV.clickUnpublish();
        logStep("Verifying Unpublish");
        VDV.verifyUnpublish();
        logStep("Selecting Vendor");
        VDV.clickCheckBox01();
        logStep("Clicking Actions");
        VDV.clickActions();
        logStep("Clicking Publish");
        VDV.clickPublish();
        VDV.verifyPublish();
 
        logStep("Clicking Fees of First Vendor");
        VDV.clickFees1();
        logStep("Clicking New Button");
        VDV.clickNew();
        logStep("Entering Percent Commission 10");
        VDV.enterPercentCommission(10);
        logStep("Clicking Save");
        VDV.clickSave();
        logStep("Clicking New");
        VDV.clickNew();
        logStep("Selecting Currency");
        VDV.selectCurrency();
        logStep("entering Flat commission 100");
        VDV.enterFlatCommission(100);
        logStep("Clicking Save");
        VDV.clickSave();
        logStep("Click Clear Search");
        VDV.clickClearSearchBtn();
        stopTimer("VM_VC_VDV Test Cases Execution Completed");
    }
}
