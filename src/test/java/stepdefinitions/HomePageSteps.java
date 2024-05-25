package stepdefinitions;

import java.util.List;
import java.util.Map;

import com.factory.driverfactory;
import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	private LoginPage page=new LoginPage(driverfactory.getdriver());
	private HomePage hpage;
	private String title;
	
	@Given("user is already on login page")
	public void user_is_already_on_login_page(DataTable dataTable) {
	   List<Map<String,String>> credList=dataTable.asMaps();
	   String username=credList.get(0).get("Username");
	   String password=credList.get(0).get("Password");
	   driverfactory.getdriver().get("https://www.saucedemo.com/");
	  hpage= page.signIn(username, password);
	
	}
	
	
	@When("user gets the title of the Homepage")
	public void user_gets_the_title_of_the_Homepage() {
	    title=hpage.getHomePageTitle();
	}

	@Given("user is on Product page")
	public void user_is_on_product_page() {
	    System.out.println("user successfully landed on Products page");
	}

	@When("user selects the Product")
	public void user_selects_the_product() {
	   hpage.clickOnProduct();
	}

	@When("user enters the Add to cart")
	public void user_enters_the_add_to_cart() {
	 hpage.clickOnAddToCart();   
	}

	@When("user clicks on cart button")
	public void user_clicks_on_cart_button() {
	   hpage.clickOnShoppingCart();
	   
	}

	@Then("user verify the product and click on checkout")
	public void user_verify_the_product_and_click_on_checkout() {
		hpage.clickOnRemove();
		   hpage.clickOnCheckOut();
		
	}


}
