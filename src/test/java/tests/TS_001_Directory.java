package tests;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.opencsv.exceptions.CsvValidationException;

import pages.login;
import pages.dashboard;
import pages.directory;
import utils.navbar;
import utils.helper;
import initializer.initializer;
public class TS_001_Directory {
	WebDriver driver;
	ExtentSparkReporter spark;
	ExtentReports extent;

	String username;
	String password;

	@BeforeTest
	public void setUpTest() throws CsvValidationException, FileNotFoundException {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("SparkReport.html");
		extent.attachReporter(spark);

		
		driver = initializer.setUpChromeDriver();

		List<String> response = helper.getLoginCredentials("logindata.csv");
		
		username = response.get(0);
		password = response.get(1);
		String browserUrl = response.get(2);
		driver.get(browserUrl);

	}

	@Test
	public void TC_001_shouldLogin() {
		ExtentTest test = extent.createTest("User Should Login: ");

		login.user_login(driver, username, password);
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
		// so that it can be used to check other details as well, though it just a
		// prototype
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