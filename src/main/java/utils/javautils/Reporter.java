package utils.javautils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Reporter {
	private static ExtentReports extent;
	private static ExtentTest test;
	static String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

	/**
	 * Sets up the report with the specified filename.
	 *
	 * @param filename The name of the report file.
	 */
	public static void setupReport(String filename) {
		// Naming file with timestamp( Runtime )
		filename = filename + "_" + timestamp;

		// ParentDirectory - where the screenshot gets stored
		String parentDirectory = System.getProperty("user.dir") + java.io.File.separator + "reports" + java.io.File.separator;

		// Calling method to create a new directory every run in the parent directory
		createDirectory(parentDirectory);

		// Create an ExtentSparkReporter for creating the report in HTML format
		ExtentSparkReporter report = new ExtentSparkReporter(
				parentDirectory + java.io.File.separator + timestamp + java.io.File.separator + filename + ".html");

		// Configure the report theme
		report.config().setTheme(Theme.STANDARD);

		// Set the view order to display charts first
		report.viewConfigurer().viewOrder().as(new ViewName[]{
				ViewName.DASHBOARD,   // This will show the charts first
				ViewName.TEST,        // Then the test details
				ViewName.CATEGORY,    // Categories
				ViewName.AUTHOR,      // Authors
				ViewName.EXCEPTION    // Exceptions
		}).apply();

		// Initialize ExtentReports and attach the ExtentSparkReporter
		extent = new ExtentReports();
		extent.attachReporter(report);
	}

	/**
	 * Creates a new test with the provided test name. used for naming the test to
	 * identify into report
	 *
	 * @param testName The name of the test.
	 */
	public static void createTest(String testName) {
		test = extent.createTest(testName);
	}

	/**
	 * Logs a step with the specified status and message.
	 *
	 * @param status  The status of the step.
	 * @param message The message associated with the step.
	 */
	public static void logStep(Status status, String message) {
		test.log(status, message);
	}

	/**
	 * flush is method provided by ExtentReporter Flushes the report to write all
	 * the logs and information to the output file.
	 *
	 */
	public static void flushReport() {
		extent.flush();
	}

	/**
	 * Reports the result of a test case.
	 *
	 * @param result The result of the test case.
	 * @param driver The WebDriver instance for capturing screenshots.
	 * @throws Exception if capturing the screenshot fails.
	 */
	public static void reportonTestResult(ITestResult result, WebDriver driver) throws Exception {
		// Log test failure details
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test case failed", ExtentColor.RED));
			// Add a screenshot of the failed test as an attachment to the report
			test.log(Status.FAIL, MarkupHelper.createLabel(
					test.addScreenCaptureFromPath(captureScreenShot(driver)) + " ---SNAP TAKEN", ExtentColor.BROWN));
		}
		// Log skipped test details
		else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test case skipped", ExtentColor.ORANGE));
		}
		// Log Success test details
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test case pass", ExtentColor.GREEN));
		}
	}

	/**
	 * Creates the directory for storing the report.
	 *
	 * @param parentDirectory The parent directory for the report.
	 */
	private static void createDirectory(String parentDirectory) {
		// Creating new Dir for sorting created report file at every runtime
		String directoryPath = parentDirectory + java.io.File.separator + timestamp;
		File directory = new File(directoryPath);
		directory.mkdirs(); // Create the directory and any necessary parent directories
	}

	/**
	 * Captures a screenshot using WebDriver and saves it to a file.
	 *
	 * @param driver The WebDriver instance for capturing the screenshot.
	 * @return The path of the captured screenshot file.
	 * @throws Exception if capturing the screenshot fails.
	 */
	private static String captureScreenShot(WebDriver driver) throws Exception {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("./failedtestcase.png");
		String path = destination.getAbsolutePath();
		FileHandler.copy(source, destination);
		return path;
	}

	// Singleton pattern
	private static Reporter instance;
	private String directoryPath;

	private Reporter() {
		// Set the directory path where the report files are stored
		directoryPath = System.getProperty("user.dir") + java.io.File.separator + "reports" + java.io.File.separator;
	}

	public static Reporter getInstance() {
		if (instance == null) {
			synchronized (Reporter.class) {
				if (instance == null) {
					instance = new Reporter();
				}
			}
		}
		return instance;
	}

	public void deleteOldReportFiles() {
		deleteOldReportFiles(1); // Default to 30 days
	}

	public void deleteOldReportFiles(int days) {
		// Calculate the deletion threshold date
		LocalDate deletionThreshold = LocalDate.now().minus(days, ChronoUnit.DAYS);
		// Get the list of files in the directory
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();
		// Iterate through the files and delete if older than the threshold
		for (File file : files) {
			LocalDate fileDate = LocalDate.ofEpochDay(file.lastModified() / (24 * 60 * 60 * 1000));
			if (fileDate.isBefore(deletionThreshold)) {
				// Delete the file
				if (file.delete()) {
					LoggerUtil.getInstance().getLogger().info("Deleted file: " + file.getName());
				} else {
					LoggerUtil.getInstance().getLogger().info("Failed to delete file: " + file.getName());
				}
			}
		}
	}
}
