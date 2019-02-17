package rough;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.actions.HomePage;
import pages.base.Page;

public class RoughTest {

	public static void main (String[] args) throws InterruptedException
	{
		Page.initConfiguration();
		Page.driver.navigate().to("http://automationpractice.com/index.php?id_category=11&controller=category#/");
		Actions action=new Actions(Page.driver);
		WebElement element=Page.driver.findElement(By.xpath("//ul[@class='product_list grid row']/li[1]/div/div[2]"));
		action.moveToElement(element).perform();
		//Thread.sleep(2000);
		Page.driver.findElement(By.cssSelector("#color_20")).click();
		
			/*if(Page.driver!=null){
				Page.quitBrowser();
				}*/
	}
}
