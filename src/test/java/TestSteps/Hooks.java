package TestSteps;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import TestBase.CucumberBaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	static WebDriver driver;
	static Logger logger;
	
		@BeforeAll
		public static void setup() {
			driver = CucumberBaseClass.initializeDriver();
			logger = CucumberBaseClass.getLogger();
		}

		@AfterAll
		public static void teardown() {
			driver.quit();
			logger.info("Closed browser");
		}

		@AfterStep
	    public void addScreenshot(Scenario scenario) {
	        TakesScreenshot ts=(TakesScreenshot) driver;
	        byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png",scenario.getName());
	    }
}
