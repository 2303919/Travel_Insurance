package TestSteps;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObejctsModel.PolicyBazaarHome;
import PageObejctsModel.UCarDetails;
import TestBase.CucumberBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UCarInsurancePageSteps {
	

	WebDriver driver;
	Logger logger;
	Properties p;
	PolicyBazaarHome Pb;

@Given("User is on HomePage and clicks on Car Insurance")
public void user_is_on_home_page_and_clicks_on_car_insurance() {
   
	driver = CucumberBaseClass.getDriver();
	logger = CucumberBaseClass.getLogger();
	p = CucumberBaseClass.getProperties();
	
	driver.get(p.getProperty("url"));
	 Pb = new PolicyBazaarHome(driver);
	Pb.clickCarInsurance();
	
}

@When("Fills all the car details")
public void fills_all_the_car_details() {
  
		UCarDetails ucd = new UCarDetails(driver);
		ucd.BuyingCar();
		
		
}

@When("Gives invalid number or email")
public void gives_invalid_number_or_email() {
	UCarDetails ucd = new UCarDetails(driver);
	ucd.PersonalDetails();
}

@Then("Invalid email or number message should be displayed")
public void invalid_email_or_number_message_should_be_displayed() {
	UCarDetails ucd = new UCarDetails(driver);
	ucd.emailErrorMsg();
}

//@Then("Enter all valid details and get car insurance quote")
//public void enter_all_valid_details_and_get_car_insurance_quote() {
//	UCarDetails ucd = new UCarDetails(driver);
//	ucd.enter_valid_email();
//	ucd.click_view_prices();
//	ucd.click_Next_7_Days();
//	ucd.enter_car_price();
//	ucd.click_submit_button();
//	ucd.click_first_insurance();
//	String s=ucd.getInsuranceQuote();
//	System.out.println(s);
//} 
}
