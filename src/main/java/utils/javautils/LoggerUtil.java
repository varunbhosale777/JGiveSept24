package utils.javautils;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUtil {
	private static final int DEFAULT_DAYS = 1; // Default days to retain logs
	private static FileHandler logFileHandler = null;
	private static SimpleFormatter simpleFormatter = null;
	private static Logger logger = null;
	private static Instant startInstant = null;
	private static FileReader fr;
	private static Properties prop;
	static String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	private static LoggerUtil instance;
	private String directoryPath;

	// Static initializer for the class
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
		try {
			fr = new FileReader("." + java.io.File.separator + "logger.properties");
			prop = new Properties();
			prop.load(fr);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// Naming to directory of log file
		String parentDirectory = "." + java.io.File.separator + "logs";
		String logFileDir = parentDirectory + java.io.File.separator + timestamp + java.io.File.separator;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("-YY-MM-dd_HHmmss");
		String logFileName = prop.getProperty("logfilename") + simpleDateFormat.format(Calendar.getInstance().getTime()) + ".log";

		try {
			File file = new File(logFileDir);
			if (!file.exists()) {
				System.out.println("Creating directory: " + logFileDir);
				file.mkdirs(); // Create logs directory if it doesn't exist
			}

			logFileHandler = new FileHandler(logFileDir + logFileName, true);
			simpleFormatter = new SimpleFormatter();
			logFileHandler.setFormatter(simpleFormatter);
			logger = Logger.getLogger("SunbirdSaas-logger");
			logger.addHandler(logFileHandler);

			// Set specific log level from properties
			String logLevel = prop.getProperty("logLevel");
			Level level;
			switch (logLevel.toUpperCase()) {
				case "SEVERE":
					level = Level.SEVERE;
					break;
				case "WARNING":
					level = Level.WARNING;
					break;
				case "INFO":
					level = Level.INFO;
					break;
				case "CONFIG":
					level = Level.CONFIG;
					break;
				case "FINE":
					level = Level.FINE;
					break;
				case "FINER":
					level = Level.FINER;
					break;
				case "FINEST":
					level = Level.FINEST;
					break;
				default:
					level = Level.INFO; // Default level if the value is not recognized
					break;
			}
			logger.setLevel(level);

			// Automatically delete old log files (default 30 days)
			getInstance().deleteOldLogFiles(); // Calls the method with default 30 days

		} catch (IOException ioe) {
			logger.warning("================= FATAL ERROR ===========================" + logFileName);
			System.out.println("================= FATAL ERROR ===========================");
			System.out.println("IOException while creating log file: " + logFileName + " in directory: " + logFileDir);
			ioe.printStackTrace();
		} catch (Exception e) {
			System.out.println("================= FATAL ERROR ===========================");
			System.out.println("Exception while creating log file : " + logFileName + " in directory: " + logFileDir);
			e.printStackTrace();
		}
	} // end of static block

	private LoggerUtil() {
		// Set the directory path where the report files are stored
		directoryPath = System.getProperty("user.dir") + java.io.File.separator + "logs" + java.io.File.separator;
	}

	public static LoggerUtil getInstance() {
		if (instance == null) {
			synchronized (LoggerUtil.class) {
				if (instance == null) {
					instance = new LoggerUtil();
				}
			}
		}
		return instance;
	}

	public void deleteOldLogFiles(int days) {
		LocalDate deletionThreshold = LocalDate.now().minus(days, ChronoUnit.DAYS);
		File directory = new File(directoryPath);
		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					LocalDate fileDate = Instant.ofEpochMilli(file.lastModified())
							.atZone(java.time.ZoneId.systemDefault())
							.toLocalDate();

					if (fileDate.isBefore(deletionThreshold)) {
						if (file.delete()) {
							System.out.println("Deleted file: " + file.getName());
						} else {
							System.out.println("Failed to delete file: " + file.getName());
						}
					}
				}
			}
		} else {
			System.out.println("The directory is empty or doesn't exist: " + directoryPath);
		}
	}

	public void deleteOldLogFiles() {
		deleteOldLogFiles(DEFAULT_DAYS);
	}

	// Method to return the logFileHandler
	public static FileHandler getLogFileHandler() {
		return logFileHandler;
	}

	// Method to return Logger so that classes can put in log statements
	public static Logger getLogger() {
		return logger;
	}

	// Log details of an exception (message and stack trace)
	public static void logException(Exception exception) {
		logException(exception, "");
	}

	// Log details of an exception with a custom message
	public static void logException(Exception exception, String customMessage) {
		logger.severe("!!!    EXCEPTION Occurred    !!!");
		logger.severe(customMessage);
		logger.severe("------------------- Exception Error Message is: --------------");
		logger.severe(exception.getMessage());
		logger.severe("=================== Exception stack trace ====================");
		logger.severe(convertStackTraceToString(exception));
	}

	// Start measuring time
	public static Instant startTimeMeasurement() {
		startInstant = Instant.now();
		logger.log(Level.INFO, "Started measuring time " + startInstant);
		return startInstant;
	}

	// Stop measuring time and print the time taken
	public static void stopTimeMeasurement() {
		stopTimeMeasurement(null);
	}

	// Stop measuring time, print the time taken, and a custom message
	public static void stopTimeMeasurement(String message) {
		Instant finishInstant = Instant.now();
		long timeElapsed = Duration.between(startInstant, finishInstant).toMillis();
		if (message != null) {
			logger.log(Level.INFO, message);
		}
		logger.log(Level.INFO, "Time elapsed - [In milli-seconds: " + timeElapsed + "] [In seconds:" + timeElapsed / 1000.0 + "]");
	}

	// Convert stack trace to a String
	private static String convertStackTraceToString(Throwable throwable) {
		try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
			throwable.printStackTrace(pw);
			return sw.toString();
		} catch (IOException ioe) {
			throw new IllegalStateException(ioe);
		}
	}
}
