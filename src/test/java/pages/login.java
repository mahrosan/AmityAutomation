package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
	public static void user_login(WebDriver driver,String username, String password) {
		enterUserCredential(driver,username,password);
		clickOnLogin(driver);
	}
	
	private static void enterUserCredential(WebDriver driver,String username, String password) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}
	
	private static void clickOnLogin(WebDriver driver) {
		driver.findElement(By.id("btnLogin")).click();
	}

}
