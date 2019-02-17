package steps;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.actions.HomePage;
import pages.actions.SignInPage;
import pages.base.Page;

public class LoginSteps  {

	HomePage home; 
	SignInPage signInPage;
	@Given("^I am on the Home Page of UIAutomation \"([^\"]*)\"$")
	public void i_am_on_the_Home_Page_of_UIAutomation_website(String websiteURL) throws Throwable {
		//Go to the application home page
		Page.driver.get(websiteURL);
	}

	@When("^I go to the Login Page$")
	public void i_go_to_the_Login_Page() throws Throwable {
	    home = new HomePage();
	    //Click the Sign In button
		signInPage= home.gotoSignIn();
	}

	@When("^enter the \"([^\"]*)\" email address$")
	public void enter_the_email_address(String email) throws Throwable {
		//Entering the email address
	   	signInPage.enterEmail(email);
	}

	@When("^Click on Create an account button$")
	public void click_on_Create_an_account_button() throws Throwable {
		//Clicking the Create Account Button
	    signInPage.ClickSubmitButton();
	}
	
	@Then("^I should see the heading \"([^\"]*)\"$")
	public void i_should_see_the_heading(String expHeading) throws Throwable {
	    String actualHeading = signInPage.confirmRegPage();
		//System.out.println("Title of my page:" + actualHeading );
		assertEquals("Didn't land on Registration Page",expHeading,actualHeading);
	}

	@Then("^I should see the error as \"([^\"]*)\"$")
	public void i_should_see_the_error_as(String expMsg) throws Throwable {
	    
		String actualMsg = signInPage.confirmErrorMessage();
		assertEquals("Didn't find the expected error message",expMsg,actualMsg);
	}	
}
