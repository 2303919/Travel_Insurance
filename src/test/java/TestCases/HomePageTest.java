package TestCases;

import org.testng.annotations.Test;

import PageObejctsModel.PolicyBazaarHome;
import TestBase.BaseClass;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class HomePageTest extends BaseClass{

	@Test(priority = 1)
	public void loadWebsite() {
		driver.get(p.getProperty("url"));
		logger.info("website is loaded");
	}
	
	@Test(priority = 2)
	public void clickTravel() {
		PolicyBazaarHome Pb = new PolicyBazaarHome(driver);
		Pb.clickTravelInsurance();
		logger.info("travel insurance menu is clicked successfully");
	}
	
	
}
