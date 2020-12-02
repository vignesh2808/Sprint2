package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//title")
	WebElement title;
	
	@FindBy(xpath="//a[@href=\"https://www.ebay.com\"]")
	WebElement ebaysites;
	
	@FindBy(xpath="//a[@href=\"https://www.ebay.com.au\"]")
	WebElement ebaycountry;
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getEbaysites() {
		return ebaysites;
	}
	
	public WebElement getEbaycountry() {
		return ebaycountry;
	}
}
