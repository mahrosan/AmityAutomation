package tests;
import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import initializer.initializer;
import pages.login;
import pages.dashboard;
import utils.helper;
import utils.navbar;
import pages.admin;

public class TS_002_Admin {
	WebDriver driver;
	String username;
	String password;
	@BeforeTest
	public void setUpTest() throws CsvValidationException, FileNotFoundException {
		driver = initializer.setUpChromeDriver();

		List<String> response = helper.getLoginCredentials("logindata.csv");
		
		username = response.get(0);
		password = response.get(1);
		String browserUrl = response.get(2);
		driver.get(browserUrl);

	}
	
	@Test
	public void TC_001_shouldLogin() {
		
		login.user_login(driver,username,password);
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