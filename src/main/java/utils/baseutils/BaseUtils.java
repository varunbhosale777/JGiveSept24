package utils.baseutils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.javautils.LoggerUtil;
import utils.javautils.Reporter;
import java.time.Duration;
import java.util.logging.Logger;
public class BaseUtils extends GenerateValidData{
    //REUSABLE METHODS:
    static Logger LOGGER = LoggerUtil.getLogger();

    public static WebDriver driver;
    public static void logStep(String log) {
        LOGGER.info(log);
        Reporter.logStep(Status.INFO, log);
    }
    public static void scrollDown(int px)
    {
        String script1="window.scrollTo(0,"+px+ ")";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script1);
    }
    public static void scrollToBottom()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public static void scrollUp(int px)
    {
        String script1="window.scrollTo(0,-"+px+ ")";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script1);
    }
    public static void clickOnElement(WebElement element)
    {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            // Wait until the element passed as a parameter is clickable
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            // Click the element
            clickableElement.click();
        } catch (Exception e) {
            logStep(e.getMessage());
        }
    }

    public static void sendText(WebElement element,String text)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement interactElement = wait.until(ExpectedConditions.visibilityOf(element));
            interactElement.sendKeys(text);

        }
        catch (Exception e)
        {
            logStep(e.getMessage());
        }
    }



    public static void waitFor(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }
    // Wait for an element to be visible
    public static WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.out.println("Element not visible within the timeout period");
            return null;
        }
    }
    // Wait for an element to be clickable
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.out.println("Element not clickable within the timeout period");
            return null;
        }
    }



    public static void stopTimer(String text)
    {
        LoggerUtil.stopTimeMeasurement(text);
    }
}
