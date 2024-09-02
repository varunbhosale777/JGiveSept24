package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BaseUtils;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.ReadExcelData;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class UM_LOGN_BLG_Test extends BrowserManager{
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @BeforeSuite
    public void generateReport() throws Exception {

        logger.info("Generating Test Report");
        Reporter.setupReport("JGIVE_Test_Report");
        logger.info("Setting up the browser...");
        browserRun();
        waitFor(15);
    }
    @AfterSuite
    public void closeBrowser()
    {
        logger.info("Closing the browser...");
        driver.close();
    }
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test UM_LOGN_BLG_1 failed. Capturing Screenshot...");
            tss.screenshot(driver, "UM_LOGN_BLG_1 test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void UM_LOGN_BLG_1(Method testMethodName) throws IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        logStep("Executing UM_LOGN_BLG Test Cases");
        UM_LOGN_BLG login = PageFactory.initElements(driver, UM_LOGN_BLG.class);
        logStep( "Steps performed according to UM_LOGN_BLG Test Cases");
        openBEUrl();
        logStep("Entering Username");
        login.username(BEusername);
        logStep("Entering Password");
        login.password(BEpassword);
        logStep("Clicking Login Button");
        login.loginBtn();
        logStep("Validating Login");
        login.validateLogin();
        stopTimer("UM_LOGN_BLG Test Cases Execution Completed");
    }
}
