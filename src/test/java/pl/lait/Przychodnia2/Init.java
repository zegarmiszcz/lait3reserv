package pl.lait.Przychodnia2;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

public class Init {

	static WebDriver driver = null;
	//dasd
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
		public static void printScr (WebDriver driver) {
	Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
	Long milis = timestamp.getTime();
	
	WebDriver driver_tmp = new Augmenter().augment(driver);
	File srcFile = ((TakesScreenshot)driver_tmp).getScreenshotAs(OutputType.FILE);
	        
			        try {
						FileUtils.copyFile(srcFile, new File("target/screenshot-"+milis+".png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
	}
}

