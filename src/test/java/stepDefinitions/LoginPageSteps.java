package stepDefinitions;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {
	private static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	@Given("users is on login page")
	public void users_is_on_login_page() {

	  DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	}

	@When("users gets the title of the page")
	public void users_gets_the_title_of_the_page() {
	  
	   title = loginpage.getLoginPageTitle();
		  System.out.println("Login Page Title is: "+title);
	}

	@Then("page tiltle should be {string}")
	public void page_tiltle_should_be(String expectedTitleName) {
	
		 
		  Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

	    Assert.assertTrue(loginpage.isForgotPasswordLinkIsExist());
	}

	@When("user enter username {string}")
	public void user_enter_username(String username) {
	
		loginpage.enterUserName(username);
	}

	@When("user enter password {string}")
	public void user_enter_password(String pwd) {
	 
		loginpage.enterPassword(pwd);
	}

	@When("user click on Login buttton")
	public void user_click_on_login_buttton() {
	
	   loginpage.clickLogin();
	}

	




}
