package pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPageLocators {

	@FindBy(css="#selectProductSort")
	public WebElement sortTypeElement;
	
	@FindBy(xpath="//span[@itemprop='price']")
	public List<WebElement> priceList;
	
	//@FindBy(css=".right-block")
	@FindBy(css="div.right-block > h5 > a")
	public List<WebElement> prodDtlsBlock;
	
	@FindBy(css="#color_20")
	public WebElement blueColorLink;
	
	@FindBy(how = How.CSS, using = ".category-name")
	public WebElement categoryName;
	
	
}
