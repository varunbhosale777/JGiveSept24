package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.ODM_ODC_BODC;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class ODM_ODC_BODC_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test ODM_ODC_BODC failed. Capturing Screenshot...");
            tss.screenshot(driver, "ODM_ODC_BODC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    static String Website=WebSite;
     
    static String Address1=generateVendorAddress();
    static String Address2=generateVendorAddress();
    static String Country="India";
    static String State="Maharashtra";
    static String City="Pune";
    static long Zip=generateVendorZipCode();
    static long Tax=generateVendorVAT();
     
    @Test
    public void ODM_ODC_BODC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        ODM_ODC_BODC BIDC = PageFactory.initElements(driver, ODM_ODC_BODC.class);
       logStep( "Steps performed according to ODM_ODC_BODC Test Cases");
         
        openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking ORG Donors");
        BIDC.locateOrgDonors();
        logStep("Validating correct page");
        BIDC.validateCorrectPage();
        logStep("Clicking new");
        BIDC.clickNew();
        logStep("Selecting Vendor");
        BIDC.selectVendor(VendorName);
        logStep("Entering OrgName");
        BIDC.enterOrgName(ORG_Donor);
        logStep("Entering OrgWebsite");
        BIDC.enterOrgWebsite(Website);
        logStep("Entering Org Email");
        BIDC.enterOrgEmail(Email);
        
        logStep("Clicking Address Tab");
        BIDC.clickAddressTab();
        logStep("Entering Address 1");
        BIDC.enterAddress1(Address1);
        logStep("Entering Address 2");
        BIDC.enterAddress2(Address2);
        logStep("Selecting Country");
        BIDC.selectCountry(Country);
        logStep("Selecting State");
        BIDC.selectState(State);
        logStep("Selecting City");
        BIDC.selectCity(City);
        logStep("Entering Zip");
        BIDC.enterZip(Zip);
        logStep("Entering Tax");
        BIDC.enterTax(Tax);
        logStep("Clicking Save and Close");
        BIDC.saveAndClose();
        logStep("Verify Save");
        Assert.assertTrue(BIDC.validateMessage("Save").contains("Organization saved"),"Error Locating");
        stopTimer("ODM_ODC_BODC Test Cases Execution Completed");
    }
}
