package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_IDM_IDC_BIDLV;
import pom.smoke_test_BE.IDM_IDC_BIDLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_IDM_IDC_BIDLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_IDM_IDC_BIDLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_IDM_IDC_BIDLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Neg_IDM_IDC_BIDLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_IDM_IDC_BIDLV BIDLV = PageFactory.initElements(driver, Neg_IDM_IDC_BIDLV.class);
       logStep( "Steps performed according to Neg_IDM_IDC_BIDLV Test Cases");
         
        openBEUrl();
        logStep("Locating Individual Donors");
        BIDLV.locateIndividualDonors();
        logStep("Entering Search Text");
        BIDLV.enterSearchText();
        logStep("Clicking Search Button");
        BIDLV.clickSearch();
        logStep("Validating Error on Search Result");
        Assert.assertTrue(BIDLV.validateMessage("Error").contains("No matching results found."),"Error Locating");
        logStep("Clicking Clear Btn");
        BIDLV.clickClearBtn();
        stopTimer("Neg_IDM_IDC_BIDLV Test Cases Execution Completed");
    }
}
