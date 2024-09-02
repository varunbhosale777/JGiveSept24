package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.IDM_IDC_FAID;
import pom.smoke_test_FE.VM_VC_FVC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class IDM_IDC_FAID_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  IDM_IDC_FAID failed. Capturing Screenshot...");
            tss.screenshot(driver, " IDM_IDC_FAID test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void IDM_IDC_FAID_1(Method testMethodName) throws IOException, InterruptedException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        IDM_IDC_FAID FAID = PageFactory.initElements(driver, IDM_IDC_FAID.class);
       logStep( "Steps performed according to  IDM_IDC_FAID Test Cases");
        openFEURL();
        logStep("Clicking Create Individual Contact");
        FAID.locateCreateIndividualContact();
        logStep("Entering Individual Contact Name");
        FAID.enterName();
        logStep("Entering Individual Contact Email Address");
        FAID.enterEmail();
        logStep("Entering Individual Contact Phone Number");
        FAID.enterPhoneNumber();
        logStep("Clicking Address Tab");
        FAID.clickAddressTab();
        logStep("Entering Address1");
        logStep("Entering Address2");
        FAID.enterAddress();
        logStep("Selecting Country");
        FAID.selectCountry();
        logStep("Selecting Region");
        FAID.selectRegion();
        logStep("Selecting City");
        FAID.selectCity();
        logStep("Entering zip code");
        FAID.enterZip();
        logStep("Clicking Submit");
        FAID.clickSubmit();

        
        stopTimer("IDM_IDC_FAID Test Cases Execution Completed");
    }
}
