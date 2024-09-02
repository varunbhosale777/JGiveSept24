package test.global_config_tests;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pom.global_config_tests.Global_Config_2;
import pom.global_config_tests.Global_Config_3;
import pom.smoke_test_BE.UM_LOGN_BLG;
import utils.baseutils.BrowserManager;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import utils.javautils.TakeScreenshot;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
public class Global_Config_3_Test extends BrowserManager {
        Logger logger = LoggerUtil.getLogger();
        TakeScreenshot tss = new TakeScreenshot();
        public static String FEUser = generateRandomUsername();
        public static String FEEmail = generateRandomEmail();
        @BeforeSuite
        public void generateReport() {

                Reporter.setupReport("JGIVE_Test_Report");
        }
        @BeforeMethod
        public void setupOpen() throws Exception {
                logStep("Setting up the browser...");
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
                logStep("Closing Browser");
                driver.quit();
        }
        @AfterClass
        public void reportFlush() {
                Reporter.flushReport();
        }
        @Test
        public void Global_Config_3_Tests(Method testMethodName) throws InterruptedException, IOException {
                LoggerUtil.startTimeMeasurement();
                Reporter.createTest(testMethodName.getName());
                Global_Config_3 GC = PageFactory.initElements(driver, Global_Config_3.class);

                logStep( "Steps performed according to Global_Config_3 Test Cases");
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

                logStep("clicking PaymentTab");
                GC.clickPaymentTab();

                logStep("Clicking Guest Donations Yes");
                GC.clickGuestDonationYes();

                logStep("Clicking QuickDonationYes");
                GC.clickQuickDonationYes();

                logStep("Clicking CampaignSettingTab");
                GC.clickCampaignSettingTab();

                logStep("Clicking ShowCampaignActivitiesNo");
                GC.clickShowCampaignActivitiesNo();

                logStep("Clicking EnableReportYes");
                GC.clickEnableReportYes();

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

                logStep("Verifying Register Success Message");
                Assert.assertEquals(GC.validateMessage("Register"),"A user account has been created for you & the access details have been emailed at the address provided.","Registration Failed");
                logStep("Clicking Create Campaign");
                GC.locateCreateCampaign();

                logStep("Entering Campaign Title");
                GC.enterCampaignTitle();
 
 
                logStep("Uploading Campaign Display Image");
                GC.uploadImage();

                logStep("Selecting Org/Ind Type");
                GC.selectOrgIndType();

                logStep("Entering Campaign Goal Amount");
                GC.enterGoalAmount();

                logStep("Entering Campaign Min Donation Amount");
                GC.enterMinDonationAmount();

                logStep("Entering Campaign Max Donation Amount");
                GC.enterMaxDonationAmount();

                logStep("Clicking Add Giveback Button");
                GC.clickAddGiveback();

                logStep("Entering Giveback Title");
                GC.enterGivebackTitle();

                logStep("Entering Minimum Donation Amount to Avail Giveback");
                GC.enterMinGivebackAmount();

                logStep("Entering Total Giveback Amount");
                GC.enterTotalGivebackAmount();

                logStep("Clicking Submit to Save Campaign");
                GC.clickSubmit();



                logStep("Verify Campaign Save");
                Assert.assertTrue(GC.validateWebElement("Save"),"Error Locating");

                logStep("Clicking AllCampaigns");
                GC.locateAllCampaigns();
                
                GC.searchCampaign();

                logStep("Clicking Donate");
                GC.clickDonate();

                logStep("Entering Donor Name");
                GC.enterDonorName();

                logStep("Entering Donor Email");
                GC.enterDonorEmail();

                logStep("Clicking By Check Radio Button");
                GC.clickPayByRadio();

                logStep("Clicking Next Button");
                GC.clickNextBtn();

                logStep("Clicking ConfirmOrder");
                GC.clickConfirmOrder();

                logStep("Verifying Donation Success Message");
                GC.verifySubmit();

                logStep("Clicking All Donations");
                GC.locateAllDonations();

                GC.selectConfirmed();

                logStep("Locating Donors");
                GC.locateDonors();

                logStep("Verifying Donors Donation");
                GC.verifyDonorsDonationAmount();

                logStep("Locating My Donations");
                GC.locateMyDonations();

                logStep("Verifying My Donation Amount");
                GC.verifyMyDonationAmount();

                stopTimer("Global_Config_3 Test Cases Execution Completed");
        }
}
