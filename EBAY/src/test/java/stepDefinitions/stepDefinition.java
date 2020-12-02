package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import PageObject.DailyDeals;
import PageObject.Homepage;
import PageObject.ProductPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition
{
	WebDriver driver;
	Homepage hp;
	DailyDeals dd;
	ProductPage pp;
	static int count;
	
	@Before
	public void  setup()
	{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Given("^User is in Homepage$")
    public void user_is_in_homepage() throws Throwable
	{
   		hp = new Homepage(driver);
		driver.get("https://www.ebay.com/");
		
		String s1 = driver.getTitle();
    	String s2 = "Electronics, Cars, Fashion, Collectibles & More | eBay";
    	Assert.assertTrue(s1.equals(s2));
        System.out.println("Homepage Title Verifeid");
        //FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("C:\\Users\\Vignesh Ganesan\\Pictures\\Saved Pictures\\Homepage.png"));
    }

    @When("^User click Daily Deals option$")
    public void user_click_daily_deals_option() throws Throwable
    {
    	dd = new DailyDeals(driver);
    	dd.getdailydeals().click();
              
        String s3 = driver.getTitle();
    	String s4 = "Daily Deals on eBay | Best deals and Free Shipping";
    	Assert.assertTrue(s3.equals(s4));
        System.out.println("Daily Deals page Title Verfied");
    }

    @Then("^User can access the Daily Deals Products Posted by other Users$")
    public void user_can_access_the_daily_deals_products_posted_by_other_users() throws Throwable 
    {
    	dd.getdailydealsproducts().click();
        System.out.println("User can access the Daily Deals Products Posted by other Users");
    }
    
    @After(order = 1)
	public void attachScreenshots(Scenario scenario) throws IOException
	{
		count++;
		File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir")+"/target/screenshots/"+scenario.getName()+"_"+count+".png");
		Files.copy(sourcePath, destinationPath);
		Reporter.addScreenCaptureFromPath(destinationPath.toString());
	}
    
    @After(order = 0)
    public void Teardown() throws Exception 
    {
    	driver.close();
    }
	
    //differentcountries
	@When("^User click eBay Sites option$")
    public void user_click_ebay_sites_option() throws Throwable 
	{
		hp.getEbaysites().click();
		Thread.sleep(1000);
		hp.getEbaycountry().click();
    }

    @Then("^User can able to select the country$")
    public void user_can_able_to_select_the_country() throws Throwable 
    {
        System.out.println("User can able to select the country");
    }
	
	//localproducts
	
	@When("^User enters product (.+)$")
    public void user_enters_product(String prod) throws Throwable
	{		
		pp = new ProductPage(driver);
		pp.getProduct().sendKeys(prod);
        Thread.sleep(1500);
        pp.getSearch().click();
        Thread.sleep(1500);                
    }

    @Then("^user is able to search for the product in their locality$")
    public void user_is_able_to_search_for_the_product_in_their_locality() throws Throwable 
    {
    	System.out.println("user is able to search for the product in their locality");
     }

    @And("^User enters the zipcode (.+) in Shipping to option$")
    public void user_enters_the_zipcode_in_shipping_to_option(String zip) throws Throwable 
    {
    	pp.getShippingTo().click();
    	Thread.sleep(3000);
    	pp.getZip().sendKeys(zip);
    	Thread.sleep(1500);
    	pp.getGo().click();
    	Thread.sleep(2000);
    }
   
    @Then("^user click worldwide option in Item location$")
    public void user_click_worldwide_option_in_item_location() throws Throwable 
    {
    	
    	pp.getWorldwide().click();
    	Thread.sleep(1500);
        System.out.println("user click worldwide option in Item location");
    }
}
