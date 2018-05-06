package pl.lait.Przychodnia2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Init {

	static WebDriver driver = null;

	public static WebDriver getDriver() {
		// System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");

		if (driver == null) {
			Init.log("Uruchamiam przegladarke Firefox");
			System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");
			//System.out.println("Wewnatrz metody getDriver");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			Init.log("Wchodzę na strone http://newtours.demoaut.com" );
			driver.get("http://newtours.demoaut.com");
			return driver;
		} 
		else
		{
			return driver;
		}
	}

	public static void endTest() {
		driver.quit();
		driver = null;
	}
	/**
	 * Usypia watek na x sekund
	 * @param milis
	 */
	
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void log(String tekst) {
		System.out.print("----- ");
		System.out.print(tekst);
		System.out.println(" -----");
	}
}

