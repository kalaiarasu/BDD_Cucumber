package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged into application")
	public void user_has_already_logged_into_application(DataTable credTable) {
      List<Map<String, String>> credlist = credTable.asMaps();
      
      String username = credlist.get(0).get("username");
      String password = credlist.get(0).get("password");
      
      DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
      accountsPage = loginPage.dologin(username, password);
	}

	@Given("user is on a Accounts page")
	public void user_is_on_a_accounts_page() {
		String title = accountsPage.getAccountPageTitle();
		System.out.println("Account Page Title is"+title);
	}


	
	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
     List<String> expectedAccountSectionList = sectionsTable.asList();
     System.out.println("Excepted Account Section list"+expectedAccountSectionList);
     
     List<String> actualAccountSectionList = accountsPage.getAccountsSectionList();
     System.out.println("Actual Account Section list"+actualAccountSectionList);
     
     Assert.assertTrue(expectedAccountSectionList.containsAll(actualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedsectioncount) {
		Assert.assertTrue(accountsPage.getAcccountSectionCount() == expectedsectioncount);

	}
}
