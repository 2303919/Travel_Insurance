package TestSteps;

import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObejctsModel.PolicyBazaarHome;
import TestBase.CucumberBaseClass;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VHealthInsurancePageSteps {
	

	WebDriver driver;
	Logger logger;
	Properties p;
	PolicyBazaarHome Pb;
	
	@Given("User should be on Home page")
	public void user_should_be_on_home_page() {
		driver = CucumberBaseClass.getDriver();
		logger = CucumberBaseClass.getLogger();
		p = CucumberBaseClass.getProperties();
		
		driver.get(p.getProperty("url"));
		 Pb = new PolicyBazaarHome(driver);

	}

	@When("User hovers on Insurance products")
	public void user_hovers_on_insurance_products() {
	    
	}

	@Then("Health insurance menu should be printed or displayed")
	public void health_insurance_menu_should_be_printed_or_displayed() {
		PolicyBazaarHome pbh = new PolicyBazaarHome(driver);
		List<WebElement> subMenu = pbh.getHealthMenu();
		int row = 1;
		for(WebElement subItem : subMenu) {
			System.out.println(" - " + subItem.getText());
			String[] data = new String[1];
			data[0] = subItem.getText();
			ExcelUtility.healthDetails(data, row++, "health.xlsx","menu_sheet");		
		}
	}

}
