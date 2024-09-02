package test.regression_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_FE.Neg_IDM_IDC_FIDLV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_IDM_IDC_FIDLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  Neg_IDM_IDC_FIDLV failed. Capturing Screenshot...");
            tss.screenshot(driver, " Neg_IDM_IDC_FIDLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void IDM_IDC_FIDLV_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_IDM_IDC_FIDLV FIDLV = PageFactory.initElements(driver, Neg_IDM_IDC_FIDLV.class);
       logStep( "Steps performed according to  Neg_IDM_IDC_FIDLV Test Cases");
        openFEURL();
        logStep("Clicking Individual Contact");
        FIDLV.locateIndividualContacts();
        logStep("Entering Individual Name to Search");
        FIDLV.enterSearch();
        logStep("Clicking Search Button");
        FIDLV.clickSearchButton();
        logStep("Validating Search Result");
        Assert.assertTrue(FIDLV.validateMessage("Error").contains("No matching results found"),"Error Locating");
        logStep("Clicking Clear Button");
        FIDLV.clickClear();
        stopTimer("Neg_IDM_IDC_FIDLV Test Cases Execution Completed");
    }
}
