package PageObejctsModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class VHealthInsurancePage extends BasePage {

	public VHealthInsurancePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//label[@class='male']")
	WebElement member;

	@FindBy(xpath = "//button[@id='step1ContinueBtn']")
	WebElement continueButton1;

	@FindBy(xpath = "//select[@id='Self']")
	WebElement age;

	@FindBy(xpath = "//option[text()='21 yr']")
	WebElement clickAge;

	@FindBy(xpath = "//button[@id='step2ContinueBtn']")
	WebElement continueButton2;

	@FindBy(xpath = "//li[text()='Pune']")
	WebElement city;

	@FindBy(xpath = "//input[@id='fullName']")
	WebElement fullname;

	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobileNo;

	@FindBy(xpath = "//button[@id='step4ContinueBtn']")
	WebElement continueButton3;

	@FindBy(xpath = "//input[@id='ped_last']")
	WebElement illness;

	@FindAll(@FindBy(xpath = "//div[@class='quotes_rvmp_card segmentation_quoteCard ']//span[@class='quotes_rvmp_card__content__plan_header__name']"))
	List<WebElement> healthPlans;

	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement insuranceProducts;
	
	public void memberDetails() {
		//member.click();
		continueButton1.click();
		age.click();
		clickAge.click();
		continueButton2.click();
		clickByJavascript(city);
		fullname.sendKeys("NamanPrTopre");
		mobileNo.sendKeys("9665425936");
		continueButton3.click();
		//illness.click();
	}

	public List<WebElement> healthCarePlans() {
		return healthPlans;
	}
}
