package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_BE.UM_LOGN_BLG;
import pom.smoke_test_FE.BE_Publish_Campaign;
import pom.smoke_test_FE.ODM_ODC_FODLV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class BE_Publish_Campaign_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  BE_Publish_Campaign failed. Capturing Screenshot...");
            tss.screenshot(driver, " BE_Publish_Campaign test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void BE_Publish_Campaign_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        BE_Publish_Campaign BEPC = PageFactory.initElements(driver, BE_Publish_Campaign.class);
        UM_LOGN_BLG login = PageFactory.initElements(driver, UM_LOGN_BLG.class);
       logStep( "Steps performed according to  BE_Publish_Campaign Test Cases");
        openBEUrl();
        logStep("Clicking components");
        logStep("Entering Username");
        login.username(BEusername);
        logStep("Entering Password");
        login.password(BEpassword);
        logStep("Clicking Login");
        login.loginBtn();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Campaigns");
        BEPC.locateCampaigns();
        logStep("Clicking First Campaign");
        BEPC.clickCheckbox1();
        logStep("Clicking Actions");
        BEPC.clickActions();
        logStep("Click Publish");
        BEPC.clickPublish();
        logStep("Verifying Publish Status");
        Assert.assertTrue(BEPC.validateMessage("Save").contains("successfully published"),"Error Locating");

        stopTimer("BE_Publish_Campaign Test Cases Execution Completed");
    }
}
