package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class BaseClass {

	
	public static WebDriver driver;
		public static Logger logger;
		public static Properties p;

		@BeforeTest(groups = {"sanity","regression"})
		@Parameters({"browser" , "os"})

		public void setup(String browser, String os) {
			// initializing logger.

			logger = LogManager.getLogger();
			try {
				// loading config.properties file. 
				p = new Properties();
				FileReader propertiesFile = new FileReader(".\\src\\test\\resources\\config.properties");
				p.load(propertiesFile);
				propertiesFile.close();
			} catch (FileNotFoundException e) {
				logger.error("Properties file not found");
				
			} catch (IOException e) {
				
				logger.error("IO exception occured");

			}

			// for local machine execution.

			if(p.getProperty("env").equalsIgnoreCase("local")) {
				logger.info("--- Running on local system ---");
				switch (browser.toLowerCase()) {
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

						return;

				}

			}

			// for execution on selenium grid.

			else if(p.getProperty("env").equalsIgnoreCase("remote")) {
				logger.info("--- Running on selenium grid system ---");
				DesiredCapabilities capabilities = new DesiredCapabilities();

				switch (browser.toLowerCase()) {

					case "chrome":

						ChromeOptions options = new ChromeOptions();
						options.addArguments("--disable-notifications");
						options.addArguments("--disable-blink-features=AutomationControlled");
						capabilities.setBrowserName("chrome");
						capabilities.setCapability(ChromeOptions.CAPABILITY, options);

						break;

					case "edge":

						EdgeOptions edgeOptions = new EdgeOptions();
						edgeOptions.addArguments("--disable-notifications");
						edgeOptions.addArguments("--disable-blink-features=AutomationControlled");
						capabilities.setBrowserName("MicrosoftEdge");
						capabilities.setCapability(ChromeOptions.CAPABILITY, edgeOptions);

						break;

					default:

						logger.error("No browser found");

						return;

				}

				switch (os.toLowerCase()) {

					case "win11":

						capabilities.setPlatform(Platform.WIN11);

						break;

					case "win":

						capabilities.setPlatform(Platform.WINDOWS);

						break;

					case "mac":

						capabilities.setPlatform(Platform.MAC);

						break;

					default:

						logger.error("No matching os found with name " + os);

						return;

				}

				try {

					driver = new RemoteWebDriver(new URL(p.getProperty("hubUrl")), capabilities);

				} catch (MalformedURLException e) {

					logger.error("Hub url not correct");

					return;

				}

			}

			logger.info("Started " + browser + " browser");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			driver.manage().window().maximize();

		}

		@AfterTest(groups = {"sanity","regression"})

		public void teardown() {

			logger.info("Closed browser");

			driver.quit();

		}

		// for capturing screenshot.

		public String captureScreen(String tname) {
	 
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);

			try {

				FileUtils.copyFile(sourceFile, targetFile);

			} catch (IOException e) {

				e.printStackTrace();

			}

			return targetFilePath;
}
}
