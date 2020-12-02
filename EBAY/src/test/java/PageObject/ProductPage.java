package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gh-ac")
	WebElement prod;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement search;
	
	@FindBy(xpath="//button[@aria-controls='s0-14-11-5-1[0]-56-0']")
	WebElement shippingto;
	
	@FindBy(id="s0-14-11-5-1[0]-56-zipCode")
	WebElement zip;
	
	@FindBy(xpath="//input[@value='Go']")
	WebElement go;
	
	@FindBy(xpath="//input[@data-value=\"Worldwide\"]")
	WebElement worldwide;
	
	public WebElement getProduct() {	
		return prod;
	}
	
	public WebElement getSearch() {	
		return search;
	}
	
	public WebElement getShippingTo() {	
		return shippingto;
	}
	
	public WebElement getZip() {
		zip.clear();
		return zip;
	}
	
	public WebElement getGo() {	
		return go;
	}
	
	public WebElement getWorldwide() {	
		return worldwide;
	}

}
