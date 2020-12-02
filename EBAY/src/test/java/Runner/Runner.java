package Runner;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import dataProviders.ConfigFileReader;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
		glue={"stepDefinitions"},
		monochrome= true,
		//tags= {"@DailyDeals"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)
public class Runner extends AbstractTestNGCucumberTests
{
	@AfterClass
	public static void writeExtentReport() {
			
		Reporter.loadXMLConfig("config/extent-configs.xml");
	    
	}
}
