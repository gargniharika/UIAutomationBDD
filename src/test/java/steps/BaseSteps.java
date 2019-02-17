package steps;

import cucumber.api.java.After; 
import cucumber.api.java.Before;

import pages.base.Page;

public class BaseSteps {

	@Before
	public void SetUp(){
		
		++Page.count;
		Page.initConfiguration();
	}
	
	@After
	public void tearDown(){
		if(Page.driver!=null)
		{
			Page.quitBrowser();
		}
		System.out.println("Report Generated at : " + System.getProperty("user.dir") + "/target/cucumber-parallel/" + Page.count+ "/index.html");
	}
}
