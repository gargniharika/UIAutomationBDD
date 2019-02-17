package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageLocators {

	@FindBy(css="#quantity_wanted")
	public WebElement qtyTextElement;
	
	//@FindBy(css="#add_to_cart")
	@FindBy(css="button.exclusive > span")
	public WebElement addToCartBtn;
	
	@FindBy(css="a.btn.btn-default.button.button-medium > span")
	public WebElement checkOutBtn;
	
	
	
}
