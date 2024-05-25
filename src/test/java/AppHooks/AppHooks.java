package AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Util.configReader;
import com.factory.driverfactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

	private driverfactory factory;
	private WebDriver driver;
	private configReader config;
	Properties prop;

	@Before(order = 0)
	public void getProperty() throws IOException {
		config = new configReader();
		prop = config.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		factory = new driverfactory();
		driver=factory.init_driver(browserName);

	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario sc)
	{
		if(sc.isFailed()) {
			String screenshotName=sc.getName().replaceAll(" ", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);
			
			//We capture screenshots in Selenium using getScreenshotAs() method of
			//TakesScreenshot interface
		}
	}

}
