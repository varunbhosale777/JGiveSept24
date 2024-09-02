
 
package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.RM_CPR_BCPRLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class RM_CPR_BCPRLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("RM_CR_BCRLV_Test failed. Capturing Screenshot...");
            tss.screenshot(driver, "RM_CR_BCRLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void RM_CPR_BCPRLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        UM_LOGN_BLG BE_Login = PageFactory.initElements(driver, UM_LOGN_BLG.class);
        RM_CPR_BCPRLV bcc = PageFactory.initElements(driver, RM_CPR_BCPRLV.class);
       logStep( "Steps performed according to RM_CPR_BCPRLV Test Cases");
        openBEUrl();
        logStep("Locating Reports");
        bcc.locateReports();
        logStep("Selecting Campaigns Promoter Report");
        bcc.selectReportsDropdown();
        logStep("Clicking Show Hide Cols Menu");
        bcc.clickShowHideCols();
        logStep("Unchecking Campaigns Promoter Column");
        logStep("Unchecking Promoter Email Column");
        bcc.deselectCols();
        logStep("Clicking Clear Filter Button");
        bcc.clickClearBtn();
        stopTimer("RM_CPR_BCPRLV Test Cases Execution Completed");
    }
}
