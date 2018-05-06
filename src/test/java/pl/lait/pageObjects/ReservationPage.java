package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.lait.Przychodnia2.Init;

public class ReservationPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/"
			+ "td[2]/table/tbody/tr[4]/td/table/tbody"
			+ "/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/"
			+ "tr[2]/td[2]/b/font/input[1]")
	WebElement roundTrip;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/"
			+ "td[2]/table/tbody/tr[4]/td/table/tbody"
			+ "/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/"
			+ "tr[2]/td[2]/b/font/input[2]")
	WebElement oneWay;
	
	@FindBy(name = "passCount")
	WebElement passCount;
	
	@FindBy(name = "fromPort")
	WebElement fromPort;
	
	@FindBy(name = "fromMonth")
	WebElement fromMonth;
	
	@FindBy(name = "fromDay")
	WebElement fromDay;
	
	@FindBy(name = "toPort")
	WebElement toPort;
	
	@FindBy(name = "toMonth")
	WebElement toMonth;
	
	@FindBy(name = "toDay")
	WebElement toDay;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/"
			+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/"
			+ "tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input")
	WebElement ecoClass;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/"
			+ "tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/"
			+ "td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")
	WebElement bizClass;
	
	@FindBy(xpath = "/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/"
			+ "tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/"
			+ "td/form/table/tbody/tr[9]/td[2]/font/font/input[2]")
	WebElement firstClass;
	
	@FindBy(name = "airline")
	WebElement airline;
	
	@FindBy(name = "findFlights")
	WebElement continueBtn;
	
	
	public ReservationPage() {
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);	
	}
	public void oneWayRadioClick() {
		Init.log("Klikam w oneWay radiobutton");
		oneWay.click();
	}
	public void roundTripRadioClick() {
		Init.log("Klikam w rounTrip radiobutton");
		roundTrip.click();
	}
	public void setPassengersCount(String count) {
		Init.log("Ustalam liczbe pasazerow " + count);
		Select passCountSelect = new Select(passCount);
		passCountSelect.selectByVisibleText(count);
	}
	public void setDepartingFromDest(String from) {
		Init.log("Ustalam miejsce odlotu " + from);
		Select fromPortSelect = new Select(fromPort);
		fromPortSelect.selectByVisibleText(from);
	}
	/**
	 * 
	 * @param month from month
	 * @param day 	from day
	 */
	public void setFromDate(String month, String day) {
		Init.log("Ustalam date wylotu " + month + " " + day);
		Select fromMonthSelect = new Select(fromMonth);
		fromMonthSelect.selectByVisibleText(month);
		
		Select fromDaySelect = new Select(fromDay);
		fromDaySelect.selectByVisibleText(day);
	}
	public void setArrivingIn(String to) {
		Init.log("Ustalam miejsce przylotu " + to);
		Select toPortSelect = new Select(toPort);
		toPortSelect.selectByVisibleText(to);
	}
	public void setToDate(String month, String day) {
		Init.log("Ustalam date powrotu " + month + " "+ day);
		Select toMonthSelect = new Select(toMonth);
		toMonthSelect.selectByVisibleText(month);
		
		Select toDaySelect = new Select(toDay);
		toDaySelect.selectByVisibleText(day);
	}
	
	public void setEconomicClass() {
		ecoClass.click();
	}
	public void setBusinessClass() {
		bizClass.click();
	}
	public void setFirstClass() {
		firstClass.click();
	}
	
	// sposób 1 - uniwersalny (przyjmie parametr z nazwa linii lotniczej)
	/**
	 * Example data:
	 * Blue Skies Airlines
	 * Unified Airlines
	 * Pangea Airlines
	 * @param line
	 */
	public void setAirline(String line) {
		Select airlineSelect = new Select(airline);
		airlineSelect.selectByVisibleText(line);
	}
	// sposób 2 - każa opcja wybierana jako osobna metoda java
	//<option>No Preferences</option>
	// <option>Blue Skies Airlines</option>
	// <option>Unified Airlines</option>
	// <option>Pangea Airlines</option>
	public void setAirline_noPreferences(){
		Select airlineSelect = new Select(airline);
		airlineSelect.selectByVisibleText("No Preferences");
	}
	public void setAirline_BlueSkies() {
		Select airlineSelect = new Select (airline);
		airlineSelect.selectByVisibleText("Blue Skies Airlines");
	}
	public void setAirline_PangeaAirlines() {
			Select airlineSelect = new Select (airline);
			airlineSelect.selectByVisibleText("Pangea Airlines");
	}
	public void continueButtonClick() {
		continueBtn.click();
	}
}
