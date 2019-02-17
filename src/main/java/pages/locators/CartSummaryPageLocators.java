package pages.locators;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class CartSummaryPageLocators {
	
	@FindBy(xpath = "//tbody/tr/td[2]/p/a")
	public WebElement prodElement;
	
	@FindBy(xpath="//tbody/tr/td[2]/small[2]/a")
	public WebElement colorElement;
	
	@FindBy(xpath="//tbody/tr/td[5]/input[2]")
	public WebElement qtyElement;
	}
