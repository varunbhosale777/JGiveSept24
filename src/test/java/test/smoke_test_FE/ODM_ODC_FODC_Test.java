package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.IDM_IDC_FAID;
import pom.smoke_test_FE.ODM_ODC_FODC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class ODM_ODC_FODC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  ODM_ODC_FODC failed. Capturing Screenshot...");
            tss.screenshot(driver, " ODM_ODC_FODC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void ODM_ODC_FODC_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        ODM_ODC_FODC FODC = PageFactory.initElements(driver, ODM_ODC_FODC.class);
       logStep( "Steps performed according to  ODM_ODC_FODC Test Cases");
        openFEURL();
        logStep("Clicking Create Organization Contact");
        FODC.locateCreateOrganizationContact();
        logStep("Entering Organization Contact Name");
        FODC.enterName();
        logStep("Entering Website");
        FODC.enterWebsite();
        logStep("Entering Organization Contact Email Address");
        FODC.enterEmail();
        logStep("Entering Organization Contact Phone Number");
        FODC.enterPhoneNumber();
        logStep("Clicking Address Tab");
        FODC.clickAddressTab();
        logStep("Entering Address1");
        logStep("Entering Address2");
        FODC.enterAddress();
        logStep("Selecting Country");
        FODC.selectCountry();
        logStep("Selecting Region");
        FODC.selectRegion();
        logStep("Selecting City");
        FODC.selectCity();
        logStep("Entering zip code");
        FODC.enterZip();
        logStep("Entering Tax");
        FODC.enterTax();
        logStep("Clicking Submit Button");
        FODC.clickSubmit();
        logStep("Verifying Success message");
        Assert.assertTrue(FODC.validateMessage("Save").contains("Organization contact saved successfully"),"Error Locating");
        stopTimer("ODM_ODC_FODC Test Cases Execution Completed");
    }
}
