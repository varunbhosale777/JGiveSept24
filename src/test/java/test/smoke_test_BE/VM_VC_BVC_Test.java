package test.smoke_test_BE;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.smoke_test_BE.UM_LOGN_BLG;
import pom.smoke_test_BE.VM_VC_BVC;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class VM_VC_BVC_Test extends BrowserManager
{
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test VM_VC_BVC failed. Capturing Screenshot...");
            tss.screenshot(driver, "VM_VC_BVC test case");
        }
        Reporter.reportonTestResult(result, driver);
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
     
    static String Alias=generateVendorAlias();
    static String Description=generateVendorDescription();
    static long Phone=generateVendorPhone();
    static String Address=generateVendorAddress();
    static String Country="India";
    static String Region="Maharashtra";
    static String City="Pune";
    static long Zip=generateVendorZipCode();
    static String Website="www.testsite.com";
    static long VAT=generateVendorVAT();
    static String paypalEmail="varun.bhosale@tekditechnologies.com";
     
    @Test
    public void VM_VC_BVC_1(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        VM_VC_BVC BVC = PageFactory.initElements(driver, VM_VC_BVC.class);
        logStep( "Steps performed according to VM_VC_BVC Test Cases");
        openBEUrl();
        logStep("Clicking components");
        logStep("Clicking JGive");
        logStep("Clicking Vendors");
        BVC.locateVendors();
        logStep("Validating correct page");
        BVC.validateCorrectPage();
        logStep("Clicking new");
        BVC.clickNew();
        logStep("Clicking Select User");
        BVC.clickSelectUser();
        logStep("Selecting User");
        BVC.clickUsername();
        logStep("Entering Vendor Name");
        BVC.enterVendorName(VendorName);
        logStep("Entering Alias");
        BVC.enterAlias(Alias);
        BVC.enterDescription(Description);
        logStep("Uploading Display Image");
        BVC.uploadImage();
        logStep("Entering Phone Number");
        BVC.enterPhoneNumber(Phone);
        logStep("Entering Address");
        BVC.enterAddress(Address);
        logStep("Selecting Country: India");
        BVC.selectCountry(Country);
        logStep("Selecting Region: Maharashtra");
        BVC.selectRegion(Region);
        logStep("Selecting City: Pune");
        BVC.selectCity(City);
        logStep("Entering ZIP Code");
        BVC.enterZipCode(Zip);
        logStep("Entering Website");
        BVC.enterWebsite(Website);
        logStep("Entering VAT Number");
        BVC.enterVATNumber(VAT);
        logStep("Clicking Payment Gateway Tab");

        logStep("Clicking Save and Close");
        BVC.saveAndClose();
        logStep("Verify Save");
        Assert.assertTrue(BVC.validateWebElement("Save"),"Error Locating");

        stopTimer("VM_VC_BVC Test Cases Execution Completed");
    }
}
