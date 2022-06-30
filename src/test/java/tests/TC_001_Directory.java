package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.login;
import pages.dashboard;

public class TC_001_Directory {

	public static void main(String[] args) {
		String rootPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootPath+"/driver/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		login.user_login(driver);
		dashboard.checkIfDashboard(driver);
	}
	
	

}
