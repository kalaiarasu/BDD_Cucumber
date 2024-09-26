package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	private WebDriver driver;
	
	//1.By Locators
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By forgotPasswordLnk = By.linkText("Forgot your password?11");
	
	//2.Constructor of page class
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//3. page actions: behaviour of Login page
	
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
   public boolean isForgotPasswordLinkIsExist() {
      return driver.findElement(forgotPasswordLnk).isDisplayed();
}
   
   public void enterUserName(String username) {
	   driver.findElement(emailID).sendKeys(username);
   }
   public void enterPassword(String pwd) {
	   driver.findElement(password).sendKeys(pwd);
   }
   public void clickLogin( ) {
	   driver.findElement(signInButton).click();
   }
   
   public AccountsPage dologin(String username,String pwd) {
	   System.out.println("User login "+username + "Password "+pwd); 
	   driver.findElement(emailID).sendKeys(username);
	   driver.findElement(password).sendKeys(pwd);
	   driver.findElement(signInButton).click();
	   return new AccountsPage(driver);
   }
   
   
}
