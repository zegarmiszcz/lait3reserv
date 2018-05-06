package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.lait.Przychodnia2.Init;

public class Reservation2Page {

	WebDriver driver;
	//drugi element od gory
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/"
			+ "tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")
	WebElement radio2;
	//szosty element od gory
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/"
			+ "tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")
	WebElement radio6;
	
	@FindBy(name = "reserveFlights")
	WebElement continueButton;
	
	public Reservation2Page() {
		
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);

	}
	public void departRadioClick() {
		Init.log("Wybieram opcje wyjazdu");
		radio2.click();
	}
	public void returnRadioClick() {
		Init.log("Wybieram opcje powrotu");
		radio6.click();
	}
	public void continueButtonClick() {
		continueButton.click();
	}
}
