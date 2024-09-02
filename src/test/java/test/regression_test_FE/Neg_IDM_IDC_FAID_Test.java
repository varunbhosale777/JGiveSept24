package test.regression_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_FE.Neg_IDM_IDC_FAID;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_IDM_IDC_FAID_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  Neg_IDM_IDC_FAID failed. Capturing Screenshot...");
            tss.screenshot(driver, " Neg_IDM_IDC_FAID test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Neg_IDM_IDC_FAID_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_IDM_IDC_FAID FUVD = PageFactory.initElements(driver, Neg_IDM_IDC_FAID.class);
       logStep( "Steps performed according to  Neg_IDM_IDC_FAID Test Cases");
        logStep("Clicking Create Individual Contact");
        FUVD.locateCreateIndividualContact();
        logStep("Clicking Submit");
        FUVD.clickSubmit();
        Assert.assertTrue(FUVD.validateMessage("Error").contains("The form cannot be submitted as it's missing required data."),"Error Locating");
        stopTimer("Neg_IDM_IDC_FAID Test Cases Execution Completed");
    }
}
