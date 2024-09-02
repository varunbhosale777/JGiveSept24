package test.regression_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_FE.Neg_CM_CC_FCC;
import pom.regression_test_FE.Neg_IDM_IDC_FAID;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import javax.annotation.Priority;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_CM_CC_FCC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Neg_CM_CC_FCC_Test failed. Capturing Screenshot...");
            tss.screenshot(driver, " Neg_CM_CC_FCC_Test test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test(priority = 1)
    public void Neg_CM_CC_FCC_Test_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_CM_CC_FCC FCC = PageFactory.initElements(driver, Neg_CM_CC_FCC.class);
       logStep( "Steps performed according to Blank Validation Neg_CM_CC_FCC_Test Test Cases");
        logStep("Clicking Create Campaign");
        FCC.locateCreateCampaign();
        logStep("Clicking Submit to Save Campaign");
        FCC.clickSubmit();
        Assert.assertTrue(FCC.validateMessage("Error").contains("Please fill all required fields"),"Error Locating");
        stopTimer("Neg_CM_CC_FCC_Test Blank Validation Test Case Execution Completed");
    }
}
