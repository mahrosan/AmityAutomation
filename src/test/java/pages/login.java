package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	public static void user_login(WebDriver driver) {
		enterUserCredential(driver);
		clickOnLogin(driver);
	}
	
	private static void enterUserCredential(WebDriver driver) {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	
	private static void clickOnLogin(WebDriver driver) {
		driver.findElement(By.id("btnLogin")).click();
	}

}
