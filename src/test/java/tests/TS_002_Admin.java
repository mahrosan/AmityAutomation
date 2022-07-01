package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.login;
import pages.dashboard;
import utils.navbar;
import pages.admin;

public class TS_002_Admin {
	WebDriver driver;
	
	@BeforeTest
	public void setUpTest() {
		String rootPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootPath+"/driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void TC_001_shouldLogin() {
		login.user_login(driver);
		dashboard.checkIfDashboard(driver);
	}
	
	@Test
	public void TC_002_navigateToAdmin() {
		// Navigate to Directory and verify landing page
		admin.navigateToJobs(driver);
		admin.checkIfDirectory(driver);
	}
	
	@Test
	private void TC_003_adminTestModule() throws InterruptedException {
		String payGradeName = "Grade 8";
		admin.createNewPayGrade(driver, payGradeName);
		admin.createNewCurrency(driver);

	}
	
	@Test
	public void TC_003_logOut() throws InterruptedException {
		navbar.initiateLogout(driver);
	}
	
	
	@AfterTest
	public void tearDownTest() {
		 driver.close();
		 driver.quit();
		 System.out.println("LOG: Completed Successfully");
	}
}