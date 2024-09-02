package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_BE_RegisterUser;
import pom.smoke_test_BE.BE_RegisterUser;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_BE_RegisterUser_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_BE_RegisterUser failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_BE_RegisterUser test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Neg_BE_RegisterUser_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_BE_RegisterUser bcc = PageFactory.initElements(driver, Neg_BE_RegisterUser.class);
        logStep( "Steps performed according to Neg_BE_RegisterUser Test Cases");
        openBEUrl();
        logStep("Clicking Users");
        logStep("Clicking Add Users");
        bcc.locateUsers();
        logStep("Clicking Save Button");
        bcc.clickSaveBtn();
        logStep("Verifying Error Message");
        Assert.assertTrue(bcc.validateMessage("Error").contains("missing required data."),"Error Locating");
        stopTimer("Neg_BE_RegisterUser Test Cases Execution Completed");
    }
}
