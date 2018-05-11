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
	
	@After
	public void finishTest() {
		endTest();
	}
}
