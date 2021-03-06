package pl.lait.Steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.*;
import pl.lait.Przychodnia2.Init;
import pl.lait.pageObjects.LoginPage;


public class LoginPageStepDefs extends Init {
	WebDriver driver = getDriver();
	LoginPage loginPage;
	
	@Given("^I open main page$")
	public void i_open_main_page() throws Throwable {
		driver = getDriver();
	}

	@When("^I click on the SIGN-ON link$")
	public void i_click_on_the_SIGN_ON_link() throws Throwable {
		driver.findElement(By.linkText("SIGN-ON")).click();
	}
	@When("^I click on the \"([^\"]*)\" link$")
	public void i_click_on_the_link(String arg1) throws Throwable {
		  driver.findElement(By.linkText(arg1)).click();
	}
	@Then("^system is on SIGN-ON page$")
	public void system_is_on_SIGN_ON_page() throws Throwable {
		String title;
		title = driver.getTitle();
		assertTrue(title.equals("Sign-on: Mercury Tours"));
		printScr(driver);
	}
	
	@When("^I login as \"([^\"]*)\" with passowrd \"([^\"]*)\"$")
	public void i_login_as_with_passowrd(String arg1, String arg2) throws Throwable {
	    loginPage = new LoginPage();
	    loginPage.login(arg1, arg2);
	    printScr(driver);
	}

	@Then("^user is logged in$")
	public void user_is_logged_in() throws Throwable {
	   printScr(driver);
	   //TODO sprawdzic asercja czy aby napewno jestem na dobrej stornie
	}
	@After
	public void finishTest() {
		endTest();
	}
}
