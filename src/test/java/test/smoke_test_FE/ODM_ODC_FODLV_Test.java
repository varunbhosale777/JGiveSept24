package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.IDM_IDC_FIDLV;
import pom.smoke_test_FE.ODM_ODC_FODLV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class ODM_ODC_FODLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  ODM_ODC_FODLV failed. Capturing Screenshot...");
            tss.screenshot(driver, " ODM_ODC_FODLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void ODM_ODC_FODLV_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        ODM_ODC_FODLV FODLV = PageFactory.initElements(driver, ODM_ODC_FODLV.class);
       logStep( "Steps performed according to  ODM_ODC_FODLV Test Cases");
        openFEURL();
        logStep("Clicking Organization Contacts");
        FODLV.locateOrganizationContacts();
        logStep("Verifying Organization Name");
        FODLV.validateOrganizationName();
        logStep("Clicking Checkbox");
        FODLV.clickCheckbox();
        logStep("Clicking Unpublish");
        FODLV.clickUnpublish();
        logStep("Clicking Publish");
        FODLV.clickPublish();
        logStep("Entering Organization Name to Search");
        FODLV.enterSearch();
        logStep("Clicking Search Button");
        FODLV.clickSearchButton();
        logStep("Validating Search Result");
        Assert.assertTrue(FODLV.validateMessage("Save").contains(ORG_Donor),"Error Locating");
        logStep("Clicking Clear Button");
        FODLV.clickClear();
        logStep("Clicking Edit");
        FODLV.clickEdit();
        logStep("Editing First Name");
        FODLV.enterFirstName();
        logStep("Clicking Submit Button");
        FODLV.clickSubmit();
        logStep("Verifying Edited Organization Name");
        FODLV.verifyEdit();
        stopTimer("ODM_ODC_FODLV Test Cases Execution Completed");
    }
}
