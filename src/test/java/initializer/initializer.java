package initializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class initializer {
	public static WebDriver setUpChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		return new ChromeDriver();
	}
}
