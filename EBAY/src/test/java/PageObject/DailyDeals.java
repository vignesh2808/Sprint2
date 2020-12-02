package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DailyDeals 
{
WebDriver driver;
	
	public DailyDeals(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//title")
	WebElement title;
	
	@FindBy(xpath="//a[text()=' Daily Deals']")
	WebElement dailydeals;
	
	@FindBy(xpath="//span[@itemprop='name']")
	WebElement dailydealsproducts;
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getdailydeals() {
		return dailydeals;
	}
	
	public WebElement getdailydealsproducts() {
		return dailydealsproducts;
	}
}
