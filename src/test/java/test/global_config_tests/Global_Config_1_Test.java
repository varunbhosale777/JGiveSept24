package test.global_config_tests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.global_config_tests.Global_Config_1;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
 
 
 
public class Global_Config_1_Test extends BrowserManager {
    Logger logger = LoggerUtil.getLogger();
    TakeScreenshot tss = new TakeScreenshot();
    public static String FEUser = generateRandomUsername();
    public static String FEEmail = generateRandomEmail();
    @BeforeSuite
    public void generateReport()  {

        Reporter.setupReport("JGIVE_Test_Report");
    }
    @BeforeMethod
    public void setupOpen() throws Exception {
        logger.info("Setting up the browser...");
        browserRun();
        waitFor(15);
    }
    @AfterMethod
    public void setupClose(ITestResult result) throws Exception {
        if (result.FAILURE == result.getStatus()) {
            logger.warning("Test Global_Config_1 failed. Capturing Screenshot...");
            tss.screenshot(driver, "Global_Config_1 test case");
        }
        Reporter.reportonTestResult(result, driver);
        logger.info("Closing Browser");
        driver.quit();
    }
    @AfterClass
    public void reportFlush() {
        Reporter.flushReport();
    }
    @Test
    public void Global_Config_1_Tests(Method testMethodName) throws InterruptedException, IOException {
        LoggerUtil.startTimeMeasurement();
        Reporter.createTest(testMethodName.getName());
        logStep("Executing Global_Config_1 Test Cases");

 
        Global_Config_1 GC = PageFactory.initElements(driver, Global_Config_1.class);
        logStep( "Steps performed according to Global_Config_1 Test Cases");
        openBEUrl();

        logStep("Entering Username");
        GC.username(BEusername);

        logStep("Entering Password");
        GC.password(BEpassword);

        logStep("Clicking Login");
        GC.loginBtn();

        logStep("Clicking System");
        logStep("Clicking Global Config Link");
        logStep("Clicking JGive");
        GC.locateJGiveGlobalConfig();

        logStep("Clicking GeneralTab");
        GC.clickGeneralTab();

        logStep("Clicking ForceUsersYes");
        GC.clickForceUsersYes();

        logStep("Clicking AutoVendorRegisterDropdownNo");
        GC.SelectAutoVendorRegisterDropdownNo();

        logStep("Clicking Save Button");
        GC.clickSaveBtn();

        logStep("Verifying Success Message");
        Assert.assertEquals(GC.validateMessage("SaveMessage"),"Configuration saved.","Error Locating");
         
        openFEURL();

        logStep("Clicking Register Menu");
        GC.locateRegisterMenu();

        logStep("Entering Username");
        GC.enterUsername(FEUser);

        logStep("Entering Email");
        GC.enterEmail(FEEmail);

        logStep("Entering Confirm Email");
        GC.enterConfirmEmail(FEEmail);

        logStep("Clicking Signup");
        GC.clickSignup();

        logStep("Verifying Signup");
        GC.verifySave();

        logStep("Clicking Create Campaign");
        GC.locateCreateCampaign();

        logStep("Verifying Error Message");
        Assert.assertTrue(GC.validateMessage("ErrorMessage").contains("A vendor profile is necessary to create a campaign"),"Error Locating");

         
        openBEUrl();

        GC.locateJGiveGlobalConfig();

        GC.clickGeneralTab();

        logStep("Clicking ForceUsersNo");
        GC.clickForceUsersNo();

        logStep("Clicking AutoVendorRegisterDropdownYes");
        GC.SelectAutoVendorRegisterDropdownYes();

        GC.clickSaveBtn();

        logStep("Verifying Save");
        Assert.assertEquals(GC.validateMessage("SaveMessage"),"Configuration saved.","Error Locating");

        stopTimer("Global_Config_1 Test Cases Execution Completed");
    }
}
