package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import pages.base.Page;
import pages.locators.SigninPageLocators;

public class SignInPage extends Page {
	
	public SigninPageLocators signinPage;
	
	public SignInPage(){
		
		this.signinPage = new SigninPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.signinPage);
		
	}
	
	public void enterEmail(String email){
		
		type(signinPage.email,email);
	}
	
	public void ClickSubmitButton(){
		click(signinPage.submit);
	}
	
	public String confirmRegPage() {
		String msgText="";
		try
		{
			//confirm if user landed on the registration or not
			msgText=signinPage.accountPageElement.getText();
			
		}
		catch(Throwable t)
		{
			System.out.println("Failed to find the element");
		}
		return msgText;
	}
	
	public String confirmErrorMessage() {
		
		String msgText="";
		try
		{
			//verify if the correct error message is thrown on entering invalid email address
			msgText=signinPage.accountErrorElement.getText();
			
		}
		catch(Throwable t)
		{
			System.out.println("Failed to find the element");
		}
		return msgText;
	}
}
