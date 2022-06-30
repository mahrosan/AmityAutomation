package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;

public class dashboard {
	
	public static void checkIfDashboard(WebDriver driver) {
		String dashboardIdentification = "//*[@id=\'content\']/div/div[1]/h1";
		String pageTitle = driver.findElement(By.xpath(dashboardIdentification)).getText();
		Assert.assertEquals(pageTitle, "Dashboard");
		
	}
}
