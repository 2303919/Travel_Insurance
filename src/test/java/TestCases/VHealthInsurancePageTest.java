package TestCases;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import PageObejctsModel.PolicyBazaarHome;
import PageObejctsModel.VHealthInsurancePage;
import TestBase.BaseClass;
import Utilities.ExcelUtility;

public class VHealthInsurancePageTest extends BaseClass {
	
	@Test(priority = 1)
	public void PrintHeathInsuranceMenu() {
		driver.get(p.getProperty("url"));
		PolicyBazaarHome pbh = new PolicyBazaarHome(driver);
		List<WebElement> subMenu = pbh.getHealthMenu();
		int row = 1;
		for(WebElement subItem : subMenu) {
			System.out.println(" - " + subItem.getText());
			String[] data = new String[1];
			data[0] = subItem.getText();
			ExcelUtility.healthDetails(data, row++, "health.xlsx","menu_sheet");
		
			
			logger.info("mouse hover on health insurance menu is done properly and printed the list of health insurances");
		}
		
		
		

		
	
	}
		

}
