package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.base.Page;
import pages.locators.ProductDetailsPageLocators;
import pages.locators.ProductPageLocators;

public class ProductDetailsPage extends Page {

public ProductDetailsPageLocators home;
	
	public ProductDetailsPage(){
		
		this.home = new ProductDetailsPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.home);
		
	}
	
	public CartSummaryPage addProdToCart(String quantity) throws InterruptedException
	{
		home.qtyTextElement.clear();
		home.qtyTextElement.sendKeys(quantity);
		home.addToCartBtn.click();
		//need to wait for Checkout button to be clickable after product added to Cart
		wait.until(ExpectedConditions.elementToBeClickable(home.checkOutBtn)).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.btn.btn-default.button.button-medium"))).click();
		
		return new CartSummaryPage();
	}
}
