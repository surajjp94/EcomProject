package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverfactory {
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlocal = new ThreadLocal<>();

	public WebDriver init_driver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlocal.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			tlocal.set(new EdgeDriver());
		}
		else
		{
			System.out.println("Please enter the correct value");
		}
		
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();
		return getdriver();
	}

	public static WebDriver getdriver()
	{
		return tlocal.get();
		
		
	}
}
