package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 private WebDriver driver;
	
	// 1. By Locators: OR
		private By emailId = By.id("user-name");
		private By password = By.id("password");
		private By signInButton = By.id("login-button");
		private By forgotPwdLink = By.linkText("Forgot your password?111");
		private By product=By.xpath("//div[text()='Sauce Labs Backpack']");
		private By Addtocart=By.xpath("//button[text()='Add to cart']");
		private By ShoppingCart= By.xpath("//a[@data-test='shopping-cart-link']");
		private By Remove=By.xpath("//button[text()='Remove']");
		private By Checkout=By.xpath("//button[text()='Checkout']");
		
		// 2. Constructor of the page class:
		public HomePage(WebDriver driver) {
			this.driver = driver;
		}

		// 3. page actions: features(behavior) of the page the form of methods:

		public String getHomePageTitle() {
			return driver.getTitle();
		}
		
		
		public void clickOnProduct()
		{
			 driver.findElement(product).click();
		}
		
		public void clickOnAddToCart()
		{
			 driver.findElement(Addtocart).click();
		}
		
		public void clickOnShoppingCart()
		{
			 driver.findElement(ShoppingCart).click();
		}
		
		public void clickOnRemove()
		{
			 driver.findElement(Remove).click();
		}
		public void clickOnCheckOut()
		{
			 driver.findElement(Checkout).click();
		}
		
		
		

		public boolean isForgotPwdLinkExist() {
			return driver.findElement(forgotPwdLink).isDisplayed();
		}

		public void enterUserName(String username) {
			driver.findElement(emailId).sendKeys(username);
		}

		public void enterPassword(String pwd) {
			driver.findElement(password).sendKeys(pwd);
		}

		public void clickOnLogin() {
			driver.findElement(signInButton).click();
		}
		
		public void signIn(String username,String pwd )
		{
			driver.findElement(emailId).sendKeys(username);
			driver.findElement(password).sendKeys(pwd);
			driver.findElement(signInButton).click();
			 
		}

}
