package TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;



public class CucumberBaseClass {
	public static WebDriver driver;

		public static Logger logger;

		public static Properties p;

		public static WebDriver initializeDriver() {

			// initializing logger.

			logger = LogManager.getLogger();

			logger.info("Starting cucumber tests");

			try {

				// loading config.properties file. 

				p = new Properties();

				FileReader propertiesFile = new FileReader(".\\src\\test\\resources\\config.properties");

				p.load(propertiesFile);

				propertiesFile.close();

			} catch (FileNotFoundException e) {

				logger.fatal("Properties file not found. Cannot run tests");

			} catch (IOException e) {

				logger.fatal("Error reading properties file. Cannot run tests");

			}

			switch (p.getProperty("cucumber_browser").toLowerCase()) {

				case "chrome":

					ChromeOptions options = new ChromeOptions();

					options.addArguments("--disable-notifications");

					options.addArguments("--disable-blink-features=AutomationControlled");

					driver = new ChromeDriver(options);

					break;

				case "edge":

					EdgeOptions edgeOptions = new EdgeOptions();

					edgeOptions.addArguments("--disable-notifications");

					edgeOptions.addArguments("--disable-blink-features=AutomationControlled");

					driver = new EdgeDriver(edgeOptions);

					break;

				default:

					logger.error("No browser found");

					return null;

			}

			logger.info("Started " + p.getProperty("cucumber_browser") + " browser");

			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			driver.manage().window().maximize();

			return driver;

		}

		public static WebDriver getDriver() {

			return driver;

		}

		public static Logger getLogger() {

			return logger;

		}

		public static Properties getProperties() {

			return p;

		}
}
