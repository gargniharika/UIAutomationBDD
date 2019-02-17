package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPageLocators {
	
	
	@FindBy(css="#email_create")
	public WebElement email;
	
	@FindBy(css="#SubmitCreate")
	public WebElement submit;
	
	@FindBy(css="#create_account_error")
	public WebElement errorTxt;
	
	@FindBy(xpath="//*[@id='account-creation_form']/div[1]/h3")
	public WebElement accountPageElement;
	
	@FindBy(xpath="//*[@id='create_account_error']/ol/li")
	public WebElement accountErrorElement;
	
	
	

}
