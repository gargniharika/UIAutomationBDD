package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.actions.CartSummaryPage;
import pages.actions.HomePage;
import pages.actions.ProductDetailsPage;
import pages.actions.ProductPage;
import pages.base.Page;

public class ProductSearchSteps {

	HomePage home =new HomePage();
	ProductPage productPage;
	ProductDetailsPage prodDtlsPage;
	CartSummaryPage cartSummaryPage;
	@Given("^user is on home page \"([^\"]*)\"$")
	public void user_is_on_home_page(String websiteURL) throws Throwable {
		//Go to the application home page
	    Page.driver.get(websiteURL);
	}
	
	@Then("^user checks if MegaMenu exists$")
	public void user_checks_if_MegaMenu_exists(DataTable megamenu) throws Throwable {
	   //Check if the MegaMenu exists in GUI
		List<Map<String,String>> data=megamenu.asMaps(String.class, String.class);
		boolean flag =home.validateMegaMenuExistence(data.get(0).get("MainMenu"), data.get(0).get("SubMenu"));
		assertEquals(true,flag);
	}

	@When("^user click on SubMenu$")
	public void user_click_on_SubMenu(DataTable megamenu) throws Throwable {
		//click on selected menu
		List<Map<String,String>> data=megamenu.asMaps(String.class, String.class);
		//System.out.println("User selected " + data.get(0).get("MainMenu") + " -> " + data.get(0).get("SubMenu"));
		productPage = home.clickProductType(data.get(0).get("MainMenu"), data.get(0).get("SubMenu"));
	}

	@Then("^page title should be \"([^\"]*)\"$")
	public void title_should_be(String expCategory) throws Throwable {
		//Verify if user landed on the selected dress page
	    boolean flag= productPage.verifyProductPage(expCategory);
		assertEquals("Correct Product Page not displayed",true, flag);
	}

	@When("^user click on Sort By: \"([^\"]*)\"$")
	public void user_click_on_Sort_By(String sortType) throws Throwable {
	    //User clicks on the sort by 
		productPage.clickOnSortType(sortType);
	    
	}

	@Then("^Validate if product grid is sorted in \"([^\"]*)\" order$")
	public void validate_if_product_grid_is_sorted_in_order(String sortType) throws Throwable {
		//Verify if the sort functionality is working as expected
	    boolean flag = productPage.ValidateSortType(sortType);
	    assertEquals("Products are not sorted in correct order",true, flag);
	  
	}

	@Then("^select Product \"([^\"]*)\" with color \"([^\"]*)\"$")
	public void select_Product_with_color(String prodName, String color) throws Throwable {
	    // User selects the color of the dress/product  
		prodDtlsPage=productPage.selectProduct(prodName, color);
		if(prodDtlsPage==null)
			fail("Unable to find the given product");
	}

	@Then("^add the item quantity \"([^\"]*)\" to Cart$")
	public void add_the_item_quantity_to_Cart(String quantity) throws Throwable {
	    // Add the input quantity to the cart
		cartSummaryPage = prodDtlsPage.addProdToCart(quantity);
	}

	@Then("^Validate Product \"([^\"]*)\" with Qty \"([^\"]*)\" and color \"([^\"]*)\" in cart$")
	public void validate_Product_with_Qty_and_color_in_cart(String prodName, String quantity, String color) throws Throwable {
	    // Verify if the cart has correct product, quantity and color
		boolean flag=cartSummaryPage.validateCartSummary(prodName, quantity, color);
		assertEquals("Cart does not contain the desired product",true, flag);
	    
	}

	
}
