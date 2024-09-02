package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.DM_DLV_BDLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class DM_DLV_BDLV_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test DM_DLV_BDLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "DM_DLV_BDLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    static String CampaignType="Donation";
    static String ApprovalStatus="Confirmed";
    static String DonorType="Individual";
     
    @Test
    public void DM_DLV_BDLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        DM_DLV_BDLV BDLV = PageFactory.initElements(driver, DM_DLV_BDLV.class);
       logStep( "Steps performed according to DM_DLV_BDLV Test Cases");
         
        openBEUrl();
        logStep("Locating Donations");
        BDLV.locateDonations();
        logStep("Validating Correct Page");
        BDLV.validateCorrectPage();
        logStep("Getting Donation ID Text");
        BDLV.getDonationIDText();
        logStep("Entering Donation ID");
        BDLV.enterDonationID();
        logStep("Clicking Search");
        BDLV.clickSearch();
        logStep("Verifying Search");
        BDLV.verifySearch();
        logStep("Clicking Filter Options");
        BDLV.clickFilterOptions();
        logStep("Select Campaign Type");
        BDLV.selectCampaignType(CampaignType);
        BDLV.clickFilterOptions();
        logStep("Select Approval Status");
        BDLV.selectApprovalStatus(ApprovalStatus);
        logStep("Clicking Filter Options");
        BDLV.clickFilterOptions();
        logStep("Selecting Donor Type");
        BDLV.selectDonorType(DonorType);
        logStep("Clicking Clear");
        BDLV.clickClear();
        stopTimer("DM_DLV_BDLV Test Cases Execution Completed");
    }
}
