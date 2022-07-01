package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.login;
import pages.dashboard;
import pages.directory;
import utils.navbar;

public class TS_001_Directory {
	WebDriver driver;
	ExtentSparkReporter spark ;
	ExtentReports extent;
	@BeforeTest
	public void setUpTest() {
		
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("SparkReport.html");
		extent.attachReporter(spark);
		
		String rootPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", rootPath+"/driver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test
	public void TC_001_shouldLogin() {
		ExtentTest test = extent.createTest("User Should Login: ");
		login.user_login(driver);
		dashboard.checkIfDashboard(driver);
		// logs the details to extent report
		test.log(Status.PASS, "User Successfully logs in to the system");
		
	}
	
	@Test
	public void TC_002_navigateToDirectory() {
		ExtentTest test = extent.createTest("Should Navigate to Directory");
		// Navigate to Directory and verify landing page
		directory.clickOnDirectory(driver);
		directory.checkIfDirectory(driver);
		test.log(Status.PASS, "User Successfully redirected to Directory");
		// Types Search text
		String searchtext = "ch";
		directory.typeSearchText(driver, searchtext);
		test.log(Status.PASS, "Enter Text");
		// Select dropdown option
		String selectOption = "United States";
		directory.selectLocationDropdown(driver, selectOption);
		test.log(Status.PASS, "Selected Dropdown");
		
		// search button invoke
		directory.clickOnSearch(driver);
		test.log(Status.PASS, "Search Invoked");
		List<WebElement> tableContents = driver.findElements(By.tagName("tr"));
		
		// this functionality will verify the search result
		// I have tried to make this functionality dynamic, 
		// so that it can be used to check other details as well, though it just a prototype
		directory.checkTableContain(tableContents, "User Name", driver, searchtext);
		test.log(Status.PASS, "Table search content Verified");
		
	}
	
	@Test
	public void TC_003_logOut() throws InterruptedException {
		navbar.initiateLogout(driver);
	}
	
	
	@AfterTest
	public void tearDownTest() {
		extent.flush();
		driver.close();
		driver.quit();
		System.out.println("LOG: Completed Successfully");
	}
}