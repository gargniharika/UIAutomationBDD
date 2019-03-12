package steps;

import cucumber.api.java.After; 
import cucumber.api.java.Before;

import pages.base.Page;

public class BaseSteps {

	@Before
	public void SetUp(){
		//call the initial setup from page class
		Page.initConfiguration();
	}
	
	@After
	public void tearDown(){
		if(Page.driver!=null)
		{
			Page.quitBrowser();
		}
		
	}
}
