package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.CM_CTC_BCTC;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class CM_CTC_BCTC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test CM_CTC_BCTC failed. Capturing Screenshot...");
            tss.screenshot(driver, "CM_CTC_BCTC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    public static String CategoryAlias=generateCategoryAlias();
    @Test
    public void CM_CC_BCLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        CM_CTC_BCTC BCTC = PageFactory.initElements(driver, CM_CTC_BCTC.class);
       logStep( "Steps performed according to CM_CTC_BCTC Test Cases");
        openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Categories");
        BCTC.locateCategories();
        logStep("Validating correct page");
        BCTC.validateCorrectPage();
        logStep("Clicking New Button");
        BCTC.clickNew();
        logStep("Entering Title");
        BCTC.enterCategoryTitle(CategoryTitle);
        logStep("Entering Alias");
        BCTC.enterAlias(CategoryAlias);
        logStep("Clicking Save");
        BCTC.clickSave();
        logStep("Verify Save");
        Assert.assertTrue(BCTC.validateWebElement("Save"),"Error Locating");
        stopTimer("CM_CTC_BCTC Test Cases Execution Completed");
    }
}
