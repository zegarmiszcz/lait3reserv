package pl.lait.Przychodnia2;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {

	static WebDriver driver = null;
	
	static DesiredCapabilities cap = DesiredCapabilities.firefox();
	//dasd
	public static WebDriver getDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");
		log("Wewnatrz metody getDriver");
		if (driver == null) {
			log("Wewnatrz Ifa, FF jest uruchomiony");
			URL seleniumAdress = null ;
			try {
				seleniumAdress = new URL("http://192.168.0.109:4444/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver = new RemoteWebDriver(seleniumAdress, cap);
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

