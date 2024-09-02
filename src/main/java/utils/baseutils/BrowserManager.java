package utils.baseutils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.javautils.LoggerUtil;
import utils.javautils.PropertiesFileManager;
import utils.javautils.Reporter;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;
public class BrowserManager extends BaseUtils {
    public void browserRun() throws Exception {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/java/test/resources/browser/browserConfig.properties");
        Properties prop = new Properties();
        prop.load(fr);
        if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--remote-allow-origins=*");
            opt.addArguments("--incognito");
            opt.addArguments("window-size=1920,1080");
//            opt.addArguments("--headless=new");
            driver = new ChromeDriver(opt);
        } else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
            FirefoxOptions opt = new FirefoxOptions();
            opt.setBinary("/usr/bin/firefox");
            driver = new FirefoxDriver(opt);
        } else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
            EdgeOptions opt = new EdgeOptions();
            opt.addArguments("--remote-allow-origins=*");
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser Selection");
        }
        driver.manage().window().maximize();
    }
    public void openBEUrl() throws IOException {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/java/test/resources/browser/browserConfig.properties");
        Properties prop = new Properties();
        prop.load(fr);
        driver.get(prop.getProperty("BE_URL"));
        logStep("Opening BE URL");
    }
    public void openFEURL() throws IOException, InterruptedException {
        FileReader fr = new FileReader(System.getProperty("user.dir") + "/src/test/java/test/resources/browser/browserConfig.properties");
        Properties prop = new Properties();
        prop.load(fr);
        driver.get(prop.getProperty("FE_URL"));
        logStep("Opening FE URL");
    }
}
