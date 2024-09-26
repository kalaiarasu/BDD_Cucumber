package apphooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0, value= "@skip")
	public void skipscenario(Scenario scenario)
	{
		System.out.println("Skipped scenario"+scenario.getName());
		Assume.assumeTrue(false);
	}
	@Before(order=1)
	public void getProperty() {
		configReader = new  ConfigReader();
		prop =  configReader.init_prop();
		
	}
	@Before(order=2)
	public void launchBrowser() {
		String browsername = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initdriver(browsername);
	}

	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
		 String ScreenshotName = scenario.getName().replaceAll("", "_");
		 byte[] sourepath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(sourepath, "image/png", ScreenshotName);
		}
	}
}
