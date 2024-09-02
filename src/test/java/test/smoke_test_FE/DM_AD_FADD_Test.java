package test.smoke_test_FE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pom.smoke_test_FE.DM_AD_FADD;
import pom.smoke_test_FE.VM_VC_FUVD;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class DM_AD_FADD_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test  DM_AD_FADD failed. Capturing Screenshot...");
            tss.screenshot(driver, "DM_AD_FADD test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void DM_AD_FADD_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        DM_AD_FADD FADD  = PageFactory.initElements(driver, DM_AD_FADD.class);
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
        logStep("Clicking Continue");
        FADD.clickContinue();
        logStep("Clicking By Check Radio Button");
        FADD.clickPayByRadio();
        logStep("Clicking Place Donation Button");
        FADD.clickPlaceDonationBtn();
        logStep("Clicking ConfirmOrder");
        FADD.clickConfirmOrder();
        logStep("Verifying Donation Success Message");
        Assert.assertTrue(FADD.validateMessage("Save").contains("Thank you for your donation"),"Error Locating");
        logStep("Clicking All Donations");
        FADD.locateAllDonations();
        FADD.selectConfirmed();
        logStep("Locating Donors");
        FADD.locateDonors();
        logStep("Verifying Donors Donation");
        FADD.verifyDonorsDonationAmount();
        logStep("Locating My Donations");
        FADD.locateMyDonations();
        logStep("Verifying My Donation Amount");
        FADD.verifyMyDonationAmount();
       logStep( "Steps performed according to  DM_AD_FADD Test Cases");
        stopTimer("DM_AD_FADD Test Cases Execution Completed");
    }
}
