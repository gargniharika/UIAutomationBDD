package pages.locators;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class HomePageLocators {
	
	@FindBy(css = ".login")
	public WebElement logInButton;
	
	@FindBy(xpath="//*[@id='block_top_menu']/ul")
	public WebElement blockMenuElement;
	}
