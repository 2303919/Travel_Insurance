package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import PageObejctsModel.TravelDetails;
import PageObejctsModel.TravelPlansPage;
import TestBase.BaseClass;
import Utilities.ExcelUtility;

public class TravelDetailsPageTest extends BaseClass {
	@Test(priority = 1)
	public void selectCountry() throws InterruptedException {
		
		TravelDetails Td = new TravelDetails(driver);
		Thread.sleep(3000);
		Td.clickCountry();
		Thread.sleep(3000);
		Td.clickNext();
		Td.clickCalendar();
		Td.noOfPeople();
		Td.healthCondition();
		Thread.sleep(3000);
		Td.mobileNo();
	
		logger.info("personal details filled successfully");
	}
	@Test(priority = 2)
	 
	public void studentPlans() throws InterruptedException {
		
		TravelPlansPage Tpp = new TravelPlansPage(driver);
		Tpp.showPlans();
		Tpp.dropDown();
		
		logger.info("filters applied on student plans");
	}
	
	@Test(priority = 3)
	public void printTop3Plans() throws IOException {
		
		TravelPlansPage Tpp = new TravelPlansPage(driver);
		List<WebElement> plans = Tpp.getPlans();
		List<WebElement> prices = Tpp.getPrices();
		for(int i = 0 ; i<3; i++ ) {
			System.out.println(plans.get(i).getText());
			System.out.println(prices.get(i).getText());
			
			logger.info("top 3 travel plans displayed on console");
	}
		ExcelUtility.travelDetails(plans,prices);
	
	}
	
}
	
	
	
