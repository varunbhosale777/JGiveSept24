package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.regression_test_BE.Neg_UM_LOGN_BLG;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.ReadExcelData;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_UM_LOGN_BLG_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @BeforeSuite
    public void generateReport() throws Exception {
        logStep("Generating Test Report");
        Reporter.setupReport("JGIVE_Test_Report");
        logStep("Setting up the browser...");
        browserRun();
        waitFor(15);
    }
    @AfterSuite
    public void closeBrowser()
    {
        logStep("Closing the browser...");
        driver.close();
    }
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_UM_LOGN_BLG_Test failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_UM_LOGN_BLG_Test test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Neg_UM_LOGN_BLG_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_UM_LOGN_BLG login = PageFactory.initElements(driver, Neg_UM_LOGN_BLG.class);
       logStep( "Steps performed according to Neg_UM_LOGN_BLG_Test Test Cases");
        openBEUrl();
        logStep("Clicking Login Button");
        login.loginBtn();
        logStep("Validating Error Message For Login");
        Assert.assertTrue(login.validateMessage("Error").contains("missing required data."),"Error Locating");
        stopTimer("Neg_UM_LOGN_BLG_Test Test Cases Execution Completed");
    }
}
