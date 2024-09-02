package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.IDM_IDC_BIDLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class IDM_IDC_BIDLV_Test extends BrowserManager {
     
    static String FirstName = "Varun";
    static String LastName = "Bhosale";
    static String SearchText = FirstName + " " + LastName;
    static long Phone = generateVendorPhone();
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test IDM_IDC_BIDLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "IDM_IDC_BIDLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void IDM_IDC_BIDLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        UM_LOGN_BLG BE_Login = PageFactory.initElements(driver, UM_LOGN_BLG.class);
        IDM_IDC_BIDLV BIDLV = PageFactory.initElements(driver, IDM_IDC_BIDLV.class);
       logStep( "Steps performed according to IDM_IDC_BIDLV Test Cases");
         
        openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Individual Donors");
        BIDLV.locateIndividualDonors();
        logStep("Validating correct page");
        BIDLV.validateCorrectPage();
        logStep("Selecting Checkbox");
        BIDLV.clickCheckbox();
        logStep("Clicking Edit");
        BIDLV.clickEdit();
        logStep("Entering Contact");
        BIDLV.enterContact(Phone);
        logStep("Clicking Save and Close");
        BIDLV.saveAndClose();
        logStep("Verify Save");
        BIDLV.verifySave();
        logStep("Entering Search Text");
        BIDLV.enterSearchText(IND_Donor);
        logStep("Clicking Search Button");
        BIDLV.clickSearch();
        logStep("Validating Search Result");


        Assert.assertTrue(BIDLV.validateMessage("Save").contains(IND_Donor),"Error Locating");

        stopTimer("IDM_IDC_BIDLV Test Cases Execution Completed");
    }
}
