package PageObejctsModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class PolicyBazaarHome extends BasePage {

	public PolicyBazaarHome(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//p[contains(text(),'Travel')]")
	WebElement travelInsurance;
	
	@FindBy(xpath = "/html/body/main/div[2]/section/div[4]/a/div[1]/div")
	WebElement carInsurance;
	
	@FindBy(xpath = "(//div[@class='shadowHandlerBox'])[2]")
	WebElement healthInsurance;
	
	@FindBy(xpath = "//a[text()='Insurance Products ']")
	WebElement insuranceProducts;
	
	@FindAll(@FindBy(xpath = "//div[@class='ruby-row']/div[3]//span"))
	List<WebElement> subItems; 
	
	public void clickTravelInsurance() {
		travelInsurance.click();
	}
	
	public void clickCarInsurance() {
		carInsurance.click();
	}
	
	public void clickHealthInsurance() {
		healthInsurance.click();
	}
	
	public List<WebElement> getHealthMenu(){
		Actions act = new Actions(driver);
		act.moveToElement(insuranceProducts).perform();
		return subItems;
	}
	
	
	

	
}
