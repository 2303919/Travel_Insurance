package TestCases;

import org.testng.annotations.Test;

import PageObejctsModel.PolicyBazaarHome;
import PageObejctsModel.UCarDetails;
import TestBase.BaseClass;

public class UCarDetailsPageTest extends BaseClass {
	
	@Test(priority = 1)
	public void clickCar() {
		driver.get(p.getProperty("url"));
		PolicyBazaarHome pbh = new PolicyBazaarHome(driver);
		pbh.clickCarInsurance();
		logger.info("clicked on Car insurance menu and fetched car details");
	}
	
	@Test(priority = 2)
	public void clickBuyingCar() {
		UCarDetails ucd = new UCarDetails(driver);
		ucd.BuyingCar();
		ucd.PersonalDetails();
		ucd.emailErrorMsg();	
		logger.info("filled personal details with wrong email and printed the wrong email error msg");
	}
	
//	@Test(priority=3)
//	public void writeCarQuotes() throws InterruptedException {
//		UCarDetails ucd = new UCarDetails(driver);
//		ucd.enter_valid_email();
//		//Thread.sleep(3000);
//		ucd.click_view_prices();
//		ucd.click_Next_7_Days();
//		ucd.enter_car_price();
//		Thread.sleep(3000);
//		ucd.click_submit_button();
//		ucd.click_first_insurance();
//		String s=ucd.getInsuranceQuote();
//		System.out.println(s);
//		
//	}
}
