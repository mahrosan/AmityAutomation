package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.login;
import pages.dashboard;
import pages.directory;
import utils.navbar;

public class TS_001_Directory {
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
	public void TC_002_navigateToDirectory() {
		// Navigate to Directory and verify landing page
		directory.clickOnDirectory(driver);
		directory.checkIfDirectory(driver);
		
		// Types Search text
		String searchtext = "ch";
		directory.typeSearchText(driver, searchtext);
		
		// Select dropdown option
		String selectOption = "United States";
		directory.selectLocationDropdown(driver, selectOption);
		
		// search button invoke
		directory.clickOnSearch(driver);
		
		List<WebElement> tableContents = driver.findElements(By.tagName("tr"));
		
		// this functionality will verify the search result
		// I have tried to make this functionality dynamic, 
		// so that it can be used to check other details as well, though it just a prototype
		directory.checkTableContain(tableContents, "User Name", driver, searchtext);
		
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