package utils.baseutils;
import utils.javautils.PropertiesFileManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
public class GenerateValidData {
    static String locatorsPath = System.getProperty("user.dir") + "/src/test/java/test/resources/locators/BE/";
    static {
        PropertiesFileManager.getInstance().setPath(locatorsPath);
    }
    //Common Test Data
    public static String UserName = generateRandomUsername();
    public static String Password = "123456789012";
    public static String Email = generateRandomEmail();
    public static String VendorName = generateVendorName();
    public static long Phone = generateVendorPhone();
    public static String Address1 = generateVendorAddress();
    public static String Address2 = generateVendorAddress();
    public static String Country = "India";
    public static String State = "Maharashtra";
    public  static String City = "Pune";
    public  static long Zip = generateVendorZipCode();
    public static long Tax = generateVendorVAT();
    //Backend Test Data:
    public static String CategoryTitle = generateCategoryTitle();
    public static String IND_Donor = generateRandomIDonor();
    public static String ORG_Donor = generateRandomODonor();
    public static String WebSite = generateRandomWebsite();
    public static String CampaignTitle = generateRandomCampaignTitle();
    public static String FEUser = generateRandomUsername();
    public static String FEEmail = generateRandomEmail();
    static PropertiesFileManager loader = PropertiesFileManager.getInstance();
    static Properties loginCred = loader.getProperties("LoginCred.properties");
    public static String BEusername = loginCred.getProperty("BEusername");
    public static String BEpassword = loginCred.getProperty("BEpassword");
    //Front End Test Data:
    public static String FEusername = loginCred.getProperty("FEusername");
    public static String FEpassword = loginCred.getProperty("FEpassword");
    //Generate User Details:
    public static String generateRandomUsername() {
        int randomNumber = (int) (Math.random() * 10000); // Generate a random number between 0 and 999
        return "User" + "_" + randomNumber;
    }
    public static String generateRandomEmail() {
        int randomNumber = (int) (Math.random() * 10000); // Generate a random number between 0 and 999
        return "User" + "_" + randomNumber + "@test.com";
    }
    public static String generateRandomWebsite() {
        int randomNumber = (int) (Math.random() * 10000); // Generate a random number between 0 and 999
        return "www.user" + randomNumber + ".com";
    }
    public static String generateRandomIDonor() {
        int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 999
        return "IND_DONOR" + "_" + randomNumber;
    }
    public static String generateRandomODonor() {
        int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 999
        return "ORG_DONOR" + "_" + randomNumber;
    }
    //Generating Data For Campaign Creation:
    public static String generateRandomCampaignTitle() {

        int randomNumber = (int) (Math.random() * 10000); // Generate a random number between 0 and 999
        return "Campaign" + "_" + randomNumber;
    }
    public static String generateRandomAlias() {
        int randomNumber = (int) (Math.random() * 1000); // Generate a random number between 0 and 999
        return "ALS_Test" + "_" + randomNumber;
    }
    public static String generateStartDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -5); // subtract 5 days
        Date fiveDaysBefore = cal.getTime();
        return dateFormat.format(fiveDaysBefore);
    }
    public static String generateEndDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Set the calendar to the current date and time
        calendar.add(Calendar.YEAR, 5); // Add 1 day to make sure the end date is greater than the current date
        Date endDate = calendar.getTime();
        return dateFormat.format(endDate);
    }
    public static int generateGoalAmount() {
        int min = 10000; // Minimum 4-digit number
        int max = 99999; // Maximum 4-digit number
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    public static int generateMinAmount() {
        int min = 100; // Minimum 3-digit number
        int max = 999; // Maximum 3-digit number
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    public static int generateMaxDonations() {
        int min = 10; // Minimum 2-digit number
        int max = 99; // Maximum 2-digit number
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    public static String generateGivebackTitle() {
        int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 999
        return "GiveBack_Test" + "_" + randomNumber;
    }
    public static int generateMinGiveback() {
        int min = 10000;
        int max = 99999;
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    public static int generateTotalGiveback() {
        int min = 100;
        int max = 999;
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    public static String generateGivebackDesc() {
        int randomNumber = (int) (Math.random() * 100); // Generate a random number between 0 and 999
        return " Give Description Test " + "_" + randomNumber;
    }
    //Generating Data for Categories Creation
    public static String generateCategoryTitle() {
        int randomNumber = (int) (Math.random() * 1000); // Generate a random number between 0 and 999
        return "Category" + "_" + randomNumber;
    }
    public static String generateCategoryAlias() {
        int randomNumber = (int) (Math.random() * 1000); // Generate a random number between 0 and 999
        return "CAT" + "_" + randomNumber;
    }
    //Generating Data for New Vendor Creation
    public static String generateVendorName() {
        int randomNumber = (int) (Math.random() * 1000); // Generate a random number between 0 and 999
        return "VENDOR" + "_" + randomNumber;
    }
    public static String generateVendorAlias() {
        int randomNumber = (int) (Math.random() * 1000); // Generate a random number between 0 and 999
        return "VEN_ALIAS" + "_" + randomNumber;
    }
    public static String generateVendorDescription() {
        String[] campaignTitles = {
                "Vendor One",
                "Vendor Two",
                "Vendor Three",
                "Vendor Four"
        };
        int randomIndex = (int) (Math.random() * campaignTitles.length);
        return campaignTitles[randomIndex];
    }
    public static long generateVendorPhone() {
        long min = 7000000000L;
        long max = 9999999999L;
        return (long) (Math.random() * (max - min + 1)) + min;
    }
    public static String generateVendorAddress() {
        String[] campaignTitles = {
                "Pune",
                "Mumbai",
                "Nashik",
                "Ahemadnagar"
        };
        int randomIndex = (int) (Math.random() * campaignTitles.length);
        return campaignTitles[randomIndex];
    }
    public static long generateVendorZipCode() {
        long min = 410000L;
        long max = 500000L;
        return (long) (Math.random() * (max - min + 1)) + min;
    }
    public static long generateVendorVAT() {
        long min = 410000L;
        long max = 500000L;
        return (long) (Math.random() * (max - min + 1)) + min;
    }
    //Front End Test Data Generation
}
