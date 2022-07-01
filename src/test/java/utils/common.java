package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class common {
	
	public static void clickOnButtonId(WebDriver driver,String btnId) {
		driver.findElement(By.id(btnId)).click();
	}
	
	public static void typeOnInputId(WebDriver driver,String inputId, String inputText) {
		driver.findElement(By.id(inputId)).sendKeys(inputText);
	}
	
	public static void verifyToastMessage(WebDriver driver,String elementXpath, String Message) {
		driver.findElement(By.xpath(elementXpath)).isDisplayed();
		String toastText = driver.findElement(By.xpath(elementXpath)).getText();
		
		Assert.assertTrue(toastText.contains(Message));  
		System.out.println("Toast contains the search keyword: "+Message);
		  
	}

}
