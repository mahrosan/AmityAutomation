package initializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class initializer {
	public static WebDriver setUpChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		return new ChromeDriver(options);
	}
}
