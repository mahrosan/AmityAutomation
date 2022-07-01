package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class directory {
	
	
	public static void checkIfDirectory(WebDriver driver) {
		String directoryIdentification = "//*[@id=\'content\']/div[1]/div[1]/h1";
		String pageTitle = driver.findElement(By.xpath(directoryIdentification)).getText();
		Assert.assertEquals(pageTitle, "Search Directory");
	}
	public static void clickOnDirectory(WebDriver driver) {
		driver.findElement(By.id("menu_directory_viewDirectory")).click();
	}
	
	public static void checkTableContain(List<WebElement> tablecontents,String assertType, WebDriver driver, String assertionText) {
		int tableContentSize = tablecontents.size();
		System.out.println("Total rendered Search Elements: "+(tableContentSize-1));
		
		if (assertType == "User Name") {
			// loops with the size of the table and check if the Names rendered does contain the search keyword or not
			for (int i = 2; i <= tableContentSize; i++) {
				// This step might be a bit flaky, but unless the whole tabular structure is changed, the test will continue successfully
				  String subText = driver.findElement(By.xpath("//*[@id=\'resultTable\']/tbody/tr["+i+"]/td[2]/ul/li[1]/b")).getText();
				  Assert.assertTrue(subText.toLowerCase().contains(assertionText));  
				  System.out.println("User: "+i+" contains the search keyword: "+assertionText);
			}
		}
		else if (assertType == "Some thing else to be verified") {
			// Assertion or condition to be tested can be inserted here
		}
				
	}
	
	public static void typeSearchText(WebDriver driver, String searchtext) {
		// Perform search and actions on directory page
		driver.findElement(By.id("searchDirectory_emp_name_empName")).sendKeys(searchtext);
	}
	
	public static void selectLocationDropdown(WebDriver driver, String selectOption) {
		Select locationDropdown =new Select(driver.findElement(By.id("searchDirectory_location")));
		locationDropdown.selectByVisibleText(selectOption);
	}
	
	public static void clickOnSearch(WebDriver driver) {
		driver.findElement(By.id("searchBtn")).click();
	}
}
