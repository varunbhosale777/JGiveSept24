package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.BE_RegisterUser;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class BE_RegisterUser_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test RegisterUser failed. Capturing Screenshot...");
            tss.screenshot(driver, "RegisterUser test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void RegisterUser(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        BE_RegisterUser bcc = PageFactory.initElements(driver, BE_RegisterUser.class);
        logStep( "Steps performed according to RegisterUser Test Cases");
        openBEUrl();

        logStep("Clicking Users");
        bcc.locateUsers();

        logStep("Entering Name");
        bcc.enterName(UserName);

        logStep("Entering Username");
        bcc.enterUsername(UserName);

        logStep("Entering Password");
        bcc.enterPassword(Password);

        logStep("Entering Confirm Password");
        bcc.enterConfirmPassword(Password);

        logStep("Entering Email");
        bcc.enterEmail(Email);

        logStep("Clicking Save and Close");
        bcc.clickSaveAndClose();

        logStep("Verifying Save");
        Assert.assertTrue(bcc.validateWebElement("Save"),"Error Locating");

        stopTimer("RegisterUser Test Cases Execution Completed");
    }
}
