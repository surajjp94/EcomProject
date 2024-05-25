package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import com.factory.driverfactory;
import com.pages.LoginPage;


import io.cucumber.java.en.Given;

public class LoginStep {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(driverfactory.getdriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		driverfactory.getdriver()
		.get("https://www.saucedemo.com/");
		
	    
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    title=loginPage.getLoginPageTitle();
	}

	
	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	   
		Assert.assertEquals("Swag Labs", string);
		
	}
	
	@When("user enters username {string}")
	public void user_enters_username(String string) {
		loginPage.enterUserName(string);
	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
		loginPage.enterPassword(string);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
	}




}
