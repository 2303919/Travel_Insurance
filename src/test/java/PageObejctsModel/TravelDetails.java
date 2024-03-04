package PageObejctsModel;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TravelDetails  extends BasePage{

	public TravelDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//p[text()='Germany']")
	WebElement country;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[1]")
	WebElement	calendar;
	
	@FindBy(xpath="(//span[text()='1'])[2]")
	WebElement startDate;
	
	@FindBy(xpath="(//span[text()='14'])[2]")
	WebElement endDate;
	
	@FindBy(xpath= "//input[@id='traveller_2']")
	WebElement twoperson;
	
	@FindBy(xpath = "(//div[@id='divarrow_undefined'])[1]")
	WebElement selectAge1;
	
	@FindBy(xpath = "//input[@id='22 years_undefined']")
	WebElement clickAge1;
	
	@FindBy(xpath = "(//div[@id='divarrow_undefined'])[2]")
	WebElement selectAge2;
	
	@FindBy(xpath = "//input[@id='21 years_undefined']")
	WebElement clickAge2;
	
	@FindBy(xpath = "//input[@id='ped_no']")
	WebElement illness;
	
	@FindBy(xpath = "//input[@id='mobileNumber']")
	WebElement mobileNo;
	
	@FindBy(xpath = "//button[text()='View plans']")
	WebElement viewPlans;
	

	
	public void clickCountry() {
		waitFor(2);
		if(!country.isSelected()) {
		country.click();
		}
		waitFor(1);
	}
	
	public void clickNext() {
		next.click();
	}
	
	
	public void clickCalendar() {
		waitFor(1);
		clickByJavascript(calendar);
		clickByJavascript(startDate);
		clickByJavascript(endDate);
		next.click();
	}
	
	public void noOfPeople() {

		clickByJavascript(twoperson);
		clickByJavascript(selectAge1);
		clickByJavascript(clickAge1);
		clickByJavascript(selectAge2);
		clickByJavascript(clickAge2);
		next.click();
		
	}
	
	public void healthCondition() {
		illness.click();
		next.click();
	}
	
	public void mobileNo() {
		mobileNo.click();
		mobileNo.sendKeys("7575757575");
		viewPlans.click();
	}
	
	
}

	
	



