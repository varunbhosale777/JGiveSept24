
 
package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.CM_CC_BCTLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class CM_CTC_BCTLV_Test extends BrowserManager{
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test CM_CTC_BCTLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "CM_CTC_BCTLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    @Test
    public void CM_CTC_BCLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        CM_CC_BCTLV BCTLV = PageFactory.initElements(driver, CM_CC_BCTLV.class);
       logStep( "Steps performed according to CM_CC_BCTLV Test Cases");
        openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Categories");
        BCTLV.locateCategories();
        logStep("Validating correct page");
        BCTLV.validateCorrectPage();
        logStep("Entering Category Title to Search");
        BCTLV.enterSearchCategory(CategoryTitle);
        logStep("Clicking Search Button");
        BCTLV.clickSearchBtn();
        logStep("Validating Search Result");
        Assert.assertTrue(BCTLV.validateMessage("Locate").contains(CategoryTitle),"Error Locating");


        stopTimer("CM_CC_BCTLV Test Cases Execution Completed");
    }
}
