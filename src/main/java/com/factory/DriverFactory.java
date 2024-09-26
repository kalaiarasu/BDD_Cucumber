package com.factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver>  tldriver = new ThreadLocal<>();
	
	//this method is used to initialize the thread local diver on the basis of giver browser
	public WebDriver initdriver(String browser) {
		System.out.println("Browser value is "+browser);
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Kalai/Downloads/chromedriver-win64 (3)/chromedriver-win64/chromedriver.exe");
			//WebDriverManager.chromedriver().browserVersion("128.0.6613.138").setup();
			tldriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		else {
			System.out.println("Please pass driver value"+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	//this is used to get the driver with ThreadLocal
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
   
}
