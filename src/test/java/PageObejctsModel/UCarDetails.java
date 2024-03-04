package PageObejctsModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UCarDetails extends BasePage {

	public UCarDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[text()='Buying a new car? Click here']")
	WebElement buyingCar;
	
	@FindBy(xpath = "//span[@id='spn6']")
	WebElement city;
	
	@FindBy(xpath = "//span[text()='TN01']")
	WebElement noPlate;
	
	@FindBy(xpath = "//span[@class='toyota']")
	WebElement carBrand;
	
	@FindBy(xpath = "//b[text()='LAND CRUISER']")
	WebElement carModel;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement fullName;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement mobileNo;
	
	@FindBy(xpath = "//div[text()='Please enter a valid e-mail ID.'][2]")
	WebElement emailError;
	
	@FindBy(xpath="(//span[text()='View Prices'])[1]")
	WebElement view_prices;
	
	@FindBy(xpath="(//*[@class=\"radioBox bgWhite\"])[2]")
	WebElement Next_7_Days;
	
	@FindBy(xpath="//*[@name=\"exShowRoomPrice\"]")
	WebElement car_price;
	
	@FindBy(xpath="//*[text()=\"Submit\"]")
	WebElement submit;
	
	@FindBy(xpath="//*[@class=\"primaryBtnV2 fillingEffect\"]")
	WebElement firstoption;
	
	@FindBy(name="summaryFormPF")
	WebElement summary;
	
	public void BuyingCar() {
		buyingCar.click();
		city.click();
		noPlate.click();
		carBrand.click();
		carModel.click();
		waitFor(3);
	}
	
	public void PersonalDetails() {
		
		fullName.sendKeys("Policy");
		email.sendKeys("car123");
		mobileNo.sendKeys("9234567809");
		System.out.println(emailError.getText());
	}
	
	public WebElement emailErrorMsg() {
		return emailError;
	}
	
	public void enter_valid_email()
	{
		email.clear();
		email.sendKeys("policy123@gmail.com");	
	}
	
	public void click_view_prices()
	{
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()",view_prices);	
		view_prices.click();
	}
	
	public void click_Next_7_Days()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Next_7_Days).perform();
		act.click().perform();
	}
	
	
	public void enter_car_price()
	{
		car_price.sendKeys("900000");
	}
	
	public void click_submit_button()
	{
		submit.click();
	}
	
	public void click_first_insurance()
	{
		firstoption.click();	
	}
		
	public String getInsuranceQuote()
	{
		return summary.getText();
	}
	
}
