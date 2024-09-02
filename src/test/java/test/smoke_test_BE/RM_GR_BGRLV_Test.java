
 
package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.RM_GR_BGRLV;
import pom.smoke_test_BE.RM_IDR_BIDLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class RM_GR_BGRLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("RM_GR_BGRLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "RM_GR_BGRLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void RM_CR_BCRLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        RM_GR_BGRLV bcc = PageFactory.initElements(driver, RM_GR_BGRLV.class);
       logStep( "Steps performed according to RM_GR_BGRLV Test Cases");
        openBEUrl();
        logStep("Locating Reports");
        bcc.locateReports();
        logStep("Selecting Giveback Report");
        bcc.selectReportsDropdown();
        logStep("Clicking Show Hide Cols Menu");
        bcc.clickShowHideCols();
        logStep("Deselecting Columns");
        bcc.deselectCols();
        logStep("Clicking Clear Filter Button");
        bcc.clickClearBtn();
        stopTimer("RM_GR_BGRLV Test Cases Execution Completed");
    }
}
