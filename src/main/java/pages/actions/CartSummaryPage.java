package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import pages.base.Page;
import pages.locators.CartSummaryPageLocators;

public class CartSummaryPage extends Page{

	CartSummaryPageLocators home;
	public CartSummaryPage()
	{
		this.home = new CartSummaryPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.home);
	}
	
	public boolean validateCartSummary(String prodName, String quantity, String color)
	{
		//Verify the color, quantity and product in the cart as per input
		if( (home.prodElement.getText().contains(prodName)) 
			&& (home.qtyElement.getAttribute("value").equals(quantity))
			&& (home.colorElement.getText().contains(color)) )
		{
			return true;
		}
		return false;
	}
}
