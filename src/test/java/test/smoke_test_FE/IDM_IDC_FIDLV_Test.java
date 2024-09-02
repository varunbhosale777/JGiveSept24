package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.IDM_IDC_FAID;
import pom.smoke_test_FE.IDM_IDC_FIDLV;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class IDM_IDC_FIDLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  IDM_IDC_FIDLV failed. Capturing Screenshot...");
            tss.screenshot(driver, " IDM_IDC_FIDLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void IDM_IDC_FIDLV_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        IDM_IDC_FIDLV FIDLV = PageFactory.initElements(driver, IDM_IDC_FIDLV.class);
       logStep( "Steps performed according to  IDM_IDC_FIDLV Test Cases");
        openFEURL();
        logStep("Clicking Individual Contact");
        FIDLV.locateIndividualContacts();
        logStep("Verifying Individual Name");
        FIDLV.validateIndividualName();
        logStep("Clicking Edit");
        FIDLV.clickEdit();
        logStep("Editing First Name");
        FIDLV.editFirstName();
        logStep("Clicking Address Tab");
        FIDLV.clickAddressTab();
        logStep("Entering Address1");
        logStep("Entering Address2");
         
        logStep("Selecting Country");
        FIDLV.selectCountry();
        logStep("Selecting Region");
        FIDLV.selectRegion();
        logStep("Selecting City");
        FIDLV.selectCity();
        logStep("Clicking Submit Button");
        FIDLV.clickSubmit();
        logStep("Verifying Edited Individual Name");
        FIDLV.verifyEdit();
        logStep("Clicking Checkbox");
        FIDLV.clickCheckbox();
        logStep("Clicking Unpublish");
        FIDLV.clickUnpublish();
        logStep("Clicking Publish");
        FIDLV.clickPublish();
        logStep("Entering Individual Name to Search");
        FIDLV.enterSearch();
        logStep("Clicking Search Button");
        FIDLV.clickSearchButton();
        logStep("Validating Search Result");
        Assert.assertTrue(FIDLV.validateMessage("Save").contains("ABC"),"Error Locating");
        logStep("Clicking Clear Button");
        FIDLV.clickClear();
        stopTimer("IDM_IDC_FIDLV Test Cases Execution Completed");
    }
}
