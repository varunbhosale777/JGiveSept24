package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.CM_CC_BCLV;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class CM_CC_BCLV_Test extends BrowserManager{
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test CM_CC_BCLV failed. Capturing Screenshot...");
            tss.screenshot(driver, "CM_CC_BCLV test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
     
            public String statusText="Published";
            public String categoryText=CategoryTitle;
            public String typeText="Donation";
            public String org_indText="Individuals";
    @Test
    public void CM_CC_BCLV_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        CM_CC_BCLV BCLV = PageFactory.initElements(driver, CM_CC_BCLV.class);
        logStep( "Steps performed according to CM_CC_BCLV Test Cases");
        BCLV.openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Campaigns");
        BCLV.locateCampaigns();
        logStep("Validating correct page");
        BCLV.validateCorrectPage();
        logStep("Entering Campaign Title to Search");
        BCLV.enterSearchTitle(CampaignTitle);
        logStep("Clicking Search Button");
        BCLV.clickSearchBtn();
        logStep("Validating Search Result");
        BCLV.validateSearch(CampaignTitle);
        logStep("Clearing Search Box");
        BCLV.clearSearchBtn();
        logStep("Selecting statusFilter");
        BCLV.select_statusFilter(statusText);
        logStep("Selecting categoryFilter");
        BCLV.select_categoryFilter(categoryText);
        logStep("Selecting typeFilter");
        BCLV.select_typeFilter(typeText);
        logStep("Selecting org_ind_type");
        BCLV.select_org_ind_type(org_indText);

        logStep("Validating Filter Result");
        Assert.assertEquals(BCLV.validateMessage("Locate"),CampaignTitle,"Error Locating");

        stopTimer("CM_CC_BCLV Test Cases Execution Completed");
    }
}
