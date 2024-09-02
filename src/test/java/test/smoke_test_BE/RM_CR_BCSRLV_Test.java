
 
package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.RM_CR_BCSRLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class RM_CR_BCSRLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("RM_CR_BCSRLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "RM_CR_BCSRLV test case");
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
        UM_LOGN_BLG BE_Login = PageFactory.initElements(driver, UM_LOGN_BLG.class);
        RM_CR_BCSRLV bcc = PageFactory.initElements(driver, RM_CR_BCSRLV.class);
       logStep( "Steps performed according to RM_CR_BCSRLV Test Cases");
        openBEUrl();
        logStep("Locating Reports");
        bcc.locateReports();
        logStep("Selecting Contribution Report");
        bcc.selectReportsDropdown();
        logStep("Clicking Show Hide Cols Menu");
        bcc.clickShowHideCols();
        logStep("Unchecking First Column");
        logStep("Unchecking Second Column");
        bcc.deselectCols();
        logStep("Clicking Clear Filter Button");
        bcc.clickClearBtn();
        stopTimer("RM_CR_BCSRLV Test Cases Execution Completed");
    }
}
