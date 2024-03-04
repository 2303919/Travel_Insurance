package PageObejctsModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TravelPlansPage  extends BasePage {

	public TravelPlansPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//input[@id='studentTrip']")
	WebElement studentPlan;
	
	@FindBy(xpath = "//input[@id='Traveller_1']")
	WebElement traveller1;
	
	@FindBy(xpath = "//input[@id='Traveller_2']")
	WebElement traveller2;
	
	@FindBy(xpath = "//select[@id='feet']")
	WebElement tripDuration;
	
	@FindBy(xpath = "//button[text()='Apply']")
	WebElement apply;
	
	@FindBy(xpath = "//p[text()='Sort by']")
	WebElement sortBy;
	
	@FindBy(xpath = "//label[text()='Premium low to high']")
	WebElement premium;
	
	@FindAll(@FindBy(xpath = "//article[@class=\"quotesCardWrapper \"]//p[@class=\"quotesCard--insurerName\"]"))
	List<WebElement> plans;
	
	@FindBy(xpath = "(//div[@class='cardWrapper__showMore '])[1]")
	WebElement morePlans;
	
	@FindAll(@FindBy(xpath = "//article[@class=\"quotesCardWrapper \"]//span[@class=\"premiumPlanPrice\"]"))
	List<WebElement>prices;
	
	
	public void showPlans() throws InterruptedException {
		clickByJavascript(studentPlan);
		Thread.sleep(3000);
		traveller1.click();
		Thread.sleep(3000);
		traveller2.click();
		Thread.sleep(3000);
		tripDuration.click();
	}
	
	public void dropDown() {
		
		Select select = new Select(tripDuration);
		select.selectByVisibleText("30 Days");
		apply.click();
		waitFor(3);
		sortBy.click();
		premium.click(); 
		morePlans.click();
	}
	
	
	public List<WebElement> getPlans(){
	return plans;
	}
	
	public List<WebElement> getPrices(){
		return prices;
	}
	
}
