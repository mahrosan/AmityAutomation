package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class navbar {
	
	
	public static void initiateLogout(WebDriver driver) throws InterruptedException
	{
		clickOnUserName(driver);
		clickOnLogout(driver);
		
	}
	private static void clickOnUserName(WebDriver driver) {
//		driver.findElement(By.id("welcome")).click();
		common.clickOnButtonId(driver, "welcome");
	}
	
	private static void clickOnLogout(WebDriver driver) throws InterruptedException {		
		Thread.sleep(1000);  
		driver.findElement(By.xpath("//*[@id=\'welcome-menu\']/ul/li[3]/a")).click();
	}
	
	

}
