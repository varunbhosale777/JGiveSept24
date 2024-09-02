package test.regression_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.regression_test_FE.Neg_DM_AD_FADD;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Neg_DM_AD_FADD_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  Neg_DM_AD_FADD failed. Capturing Screenshot...");
            tss.screenshot(driver, "Neg_DM_AD_FADD test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Neg_DM_AD_FADD_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        Neg_DM_AD_FADD FADD  = PageFactory.initElements(driver, Neg_DM_AD_FADD.class);
        openFEURL();
        logStep("Clicking AllCampaigns");
        FADD.locateAllCampaigns();
        
        logStep("Searching Campaign");
        FADD.searchCampaign();
        logStep("Clicking Donate");
        FADD.clickDonate();
        logStep("Entering First Name");
        FADD.enterFirstName();
        logStep("Entering Last Name");
        FADD.enterLastName();
        logStep("Entering Address");
        FADD.enterAddress();
        logStep("Selecting Country");
        FADD.selectCountry();
        logStep("Selecting Region");
        FADD.selectRegion();
        logStep("Selecting City");
        FADD.selectCity();
        logStep("Entering Zip");
        FADD.enterZip();
        logStep("Entering Email");
        FADD.enterEmail();
        logStep("Entering Phone Number");
        FADD.enterPhoneNumber();
        logStep("Entering TaxID");
        FADD.enterTaxID();
        logStep("Entering Donation Amount");
        FADD.enterDonationAmount();
        logStep("Clicking Continue");
        FADD.clickContinue();
        logStep("Verifying Alert Popup");
        FADD.verifyPopup();
       logStep( "Steps performed according to  Neg_DM_AD_FADD Test Cases");
        stopTimer("Neg_DM_AD_FADD Test Cases Execution Completed");
    }
}
