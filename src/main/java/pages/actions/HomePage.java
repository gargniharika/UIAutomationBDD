package pages.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import pages.base.Page;
import pages.locators.HomePageLocators;

public class HomePage extends Page {
	
	public HomePageLocators home;
		
	public HomePage(){
		
		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.home);
		
	}
	
	public SignInPage gotoSignIn(){
		
		click(home.logInButton);
		return new SignInPage();
	}
	
	public boolean validateMegaMenuExistence(String mainMenu, String subMenu)
	{
		//Validate if the Mega Menu exists by mouse hovering on Menu -> SubMenu Item
		Actions action = new Actions(driver);
		List<WebElement> menuList = home.blockMenuElement.findElements(By.tagName("li"));
		boolean flag= false;
		for (int i=0; i < menuList.size(); i++)
		{	
			if (menuList.get(i).getText().contains(mainMenu))
			{
				//Got the Menu Item  and now traverse to the SubMenu Item user wants to verify
				action.moveToElement(menuList.get(i)).perform();
				List<WebElement> subMenuList = menuList.get(i).findElements(By.tagName("li"));
				
				for (int j=0; j < subMenuList.size(); j++)
				{	
					
					if (subMenuList.get(j).getAttribute("innerHTML").contains(subMenu))
					{
						flag =  true;
						break;
						
					}
				}
				break;
			}
		}
	
		return flag;
	}

	public ProductPage clickProductType(String mainMenu, String subMenu) throws InterruptedException
	{
		Actions action = new Actions(driver);
		List<WebElement> menuList = home.blockMenuElement.findElements(By.tagName("li"));
		for (int i=0; i < menuList.size(); i++)
		{	
			if (menuList.get(i).getText().contains(mainMenu))
			{
				//Got the Menu Item  and now traverse to the SubMenu Item user wants to verify
				action.moveToElement(menuList.get(i)).perform();
				List<WebElement> subMenuList = menuList.get(i).findElements(By.tagName("li"));
				for (int j=0; j < subMenuList.size(); j++)
				{	
					//Thread.sleep(1000);
					if (subMenuList.get(j).getAttribute("innerHTML").contains(subMenu))
					{
						//Found the input Sub Menu and its time to click the same
						action.moveToElement(subMenuList.get(j)).click().perform();
						break;
					}
				}
				break;
			}
		}
		
		return new ProductPage();
	}
			

}
