package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_FE.FE_RegisterUser;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class FE_RegisterUser_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @BeforeSuite
    public void generateReport() throws Exception {

        logger.info("Generating Test Report");
        Reporter.setupReport("JGIVE_Test_Report");
        logger.info("Setting up the browser...");
        browserRun();
        waitFor(20);
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
            logger.warning("Test Register User failed. Capturing Screenshot...");
            tss.screenshot(driver, "RegisterUser test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void FERegisterUser(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        logStep("Executing RegisterUser Test Cases");
        FE_RegisterUser reg = PageFactory.initElements(driver, FE_RegisterUser.class);
        logStep( "Steps performed according to RegisterUser Test Cases");
        openFEURL();
        logStep("Clicking Register Menu");
        reg.locateRegisterMenu();
        reg.clickSignup();
        Assert.assertTrue(reg.validateMessage("Save").contains("registration failed"),"Error Locating");
        logStep("Entering Username");
        reg.enterUsername(FEUser);
        logStep("Entering Email");
        reg.enterEmail(FEEmail);
        logStep("Entering Confirm Email");
        reg.enterConfirmEmail(FEEmail);
        logStep("Clicking Signup");
        reg.clickSignup();
        Assert.assertTrue(reg.validateMessage("Save").contains("A user account has been created for you & the access details have been emailed at the address provided."),"Error Locating");
        stopTimer("Front End Register User Test Cases Execution Completed");
    }
}
