package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.ODM_ODC_BODLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class ODM_ODC_BODLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test ODM_ODC_BODLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "ODM_ODC_BODLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    static String Name="ABC";
    static String Website="www.test.com";
    
     
    @Test
    public void ODM_ODC_BODLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        UM_LOGN_BLG BE_Login = PageFactory.initElements(driver, UM_LOGN_BLG.class);
        ODM_ODC_BODLV BODLV = PageFactory.initElements(driver, ODM_ODC_BODLV.class);
       logStep( "Steps performed according to ODM_ODC_BODLV Test Cases");
         
        openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking ORG Donors");
        BODLV.locateOrgDonors();
        logStep("Validating correct page");
        BODLV.validateCorrectPage();
        logStep("Clicking First Checkbox");
        BODLV.clickCheckbox();
        logStep("Clicking Edit Button");
        BODLV.clickEdit();
        logStep("Entering website");
        BODLV.enterWebsite(Website);
        logStep("Clicking Save and Close");
        BODLV.clickSaveAndClose();
        logStep("Verify Edit");
        BODLV.verifyEdit();
        logStep("Entering Search Query");
        BODLV.enterSearchQuery(ORG_Donor);
        logStep("Clicking Search Button");
        BODLV.clickSearchBtn();
        logStep("Verify Search Result");
        BODLV.verifyFirstResult(ORG_Donor);
        logStep("Clicking Clear");
        BODLV.clickClear();
        stopTimer("ODM_ODC_BODLV Test Cases Execution Completed");
    }
}
