package test.regression_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_BE.Neg_CM_CC_BCC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_CM_CC_BCC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test CM_CC_BCC_1 failed. Capturing Screenshot...");
            tss.screenshot(driver, "CM_CC_BCC_1 test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    public static String getCampaignTitle()
    {
        return CampaignTitle;
    }
    @Test
    public void Neg_CM_CC_BCC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_CM_CC_BCC bcc = PageFactory.initElements(driver, Neg_CM_CC_BCC.class);
       logStep( "Steps performed according to Neg_CM_CC_BCC Test Cases");
        openBEUrl();
        logStep("Locating Campaigns ");
        bcc.locateCampaigns();
         
        
        logStep("Clicking New");
        bcc.clickNew();
        logStep("Clicking Save");
        bcc.clickSave();
        logStep("Verify Save");

        Assert.assertTrue(bcc.validateMessage("Error").contains("missing required data."),"Error Locating");
        stopTimer("Neg_CM_CC_BCC Test Cases Execution Completed");
    }
}
