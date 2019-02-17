package pages.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import pages.base.Page;
import pages.locators.ProductPageLocators;

public class ProductPage extends Page{

public ProductPageLocators home;
	
	public ProductPage(){
		
		this.home = new ProductPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.home);
		
	}
	
	public boolean verifyProductPage(String expCategory)
	{
		boolean flag = false;
		if(home.categoryName.getText().contains(expCategory))
			flag = true;
		return flag;
	}
	
	public void clickOnSortType(String sortType)
	{
		Select select= new Select(home.sortTypeElement);
		select.selectByVisibleText(sortType);
	}
	
	public boolean ValidateSortType(String sortType) throws InterruptedException
	{
		//Code to find the prices of the listed items
		clickOnSortType(sortType);	
		ArrayList<String> priceArray = new ArrayList<String>(); 
		ArrayList<String> priceSorted = new ArrayList<String>();
		Thread.sleep(2000);
		for(int i=1; i<=home.priceList.size();i=i+2)
			priceArray.add(home.priceList.get(i).getAttribute("innerText"));
		
		//Create second list as the copy to verify the sorting
		priceSorted= priceArray;
		//Check if the sorting is Price: Lowest first , then sort the  priceSorted list in ascending order
		//Check if the sorting is Highest first , then sort the  priceSorted list in ascending order
		if(sortType.equals("Price: Lowest first"))
			Collections.sort(priceSorted);
		else if(sortType.equals("Price: Highest first"))
			Collections.sort(priceSorted,Collections.reverseOrder());
		
		if(priceSorted.equals(priceArray))
			return true;
		return false;
	}
	
	public ProductDetailsPage selectProduct(String prodName, String color)
	{
		ProductDetailsPage prodDtlsPage=null;
		boolean found=false;
		Actions action=new Actions(Page.driver);
		
		for (WebElement element: home.prodDtlsBlock)
		{
			if(element.getAttribute("title").contains(prodName))
			{
				//Got the input product and below code is to choose the color
				action.moveToElement(element).perform();
				home.blueColorLink.click();
				found=true;
				break;
			}
		}
		if (found)
		{
			prodDtlsPage=new ProductDetailsPage();
		}
		
		return prodDtlsPage;
	}
	
}
