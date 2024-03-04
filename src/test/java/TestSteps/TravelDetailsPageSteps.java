package TestSteps;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObejctsModel.PolicyBazaarHome;
import PageObejctsModel.TravelDetails;
import PageObejctsModel.TravelPlansPage;
import TestBase.CucumberBaseClass;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TravelDetailsPageSteps {
	
	WebDriver driver;
	Logger logger;
	Properties p;
	PolicyBazaarHome Pb;
	
	@Given("User is on HomePage and clicks on Travel Insurance")
	public void user_is_on_home_page_and_clicks_on_travel_insurance() {
		driver = CucumberBaseClass.getDriver();
		logger = CucumberBaseClass.getLogger();
		p = CucumberBaseClass.getProperties();
		
		driver.get(p.getProperty("url"));
		Pb = new PolicyBazaarHome(driver);
		Pb.clickTravelInsurance();
	}

	@When("User fills all the details")
	public void user_fills_all_the_details() {
		TravelDetails Td = new TravelDetails(driver);
		Td.clickCountry();
		Td.clickNext();
		Td.clickCalendar();
		Td.noOfPeople();
		Td.healthCondition();
		Td.mobileNo();
	}

	@When("User clicks on student plans and fills details")
	public void user_clicks_on_student_plans_and_fills_details() throws InterruptedException {
		TravelPlansPage Tpp = new TravelPlansPage(driver);
		Tpp.showPlans();
		Tpp.dropDown();
	}

	@Then("Student plans should be displayed in low to high price")
	public void student_plans_should_be_displayed_in_low_to_high_price() throws IOException {
		TravelPlansPage Tpp = new TravelPlansPage(driver);
		List<WebElement> plans = Tpp.getPlans();
		List<WebElement> prices = Tpp.getPrices();
		for(int i = 0 ; i<3; i++ ) {
			System.out.println(plans.get(i).getText());
			System.out.println(prices.get(i).getText());
	}
		ExcelUtility.travelDetails(plans,prices);
	}
}
