package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.common;

public class admin {
	
	public static void checkIfDirectory(WebDriver driver) {
		String directoryIdentification = "//*[@id=\'search-results\']/div[1]/h1";
		String pageTitle = driver.findElement(By.xpath(directoryIdentification)).getText();
		Assert.assertEquals(pageTitle, "Pay Grades");
	}
	public static void navigateToJobs(WebDriver driver) {
		clickOnAdmin(driver);
		clickOnJob(driver);
		clickOnAPaygrade(driver);
	}
	public static void clickOnAdmin(WebDriver driver) {
		clickOnBtn(driver,"menu_admin_viewAdminModule");
	}
	
	public static void clickOnJob(WebDriver driver) {
		clickOnBtn(driver,"menu_admin_Job");
	}
	
	public static void clickOnAPaygrade(WebDriver driver) {
		clickOnBtn(driver,"menu_admin_viewPayGrades");
	}
	
	
	private static void clickOnBtn(WebDriver driver,String btnId) {
		driver.findElement(By.id(btnId)).click();
	}
	
	
	
	public static void createNewPayGrade(WebDriver driver, String payGradeName) throws InterruptedException {
		clickOnAdd(driver);
		enterPaygrade(driver,payGradeName);
		clickOnPaygradeSave(driver);
		
		verifySuccessToast(driver);
	}
	private static void clickOnAdd(WebDriver driver) {
		common.clickOnButtonId(driver, "btnAdd");
	}
	
	private static void enterPaygrade(WebDriver driver, String payGradeName) {
		common.typeOnInputId(driver, "payGrade_name", payGradeName);
	}
	
	private static void clickOnPaygradeSave(WebDriver driver) {
		common.clickOnButtonId(driver, "btnSave");
	}
	
	private static void verifySuccessToast(WebDriver driver) {
		common.verifyToastMessage(driver, "//*[@id=\'payGrade\']/div[2]/div", "Successfully Saved");
	}
	
	private static void clickOnAddCurrency(WebDriver driver) {
		common.clickOnButtonId(driver, "btnAddCurrency");
	}
	
	
	public static void createNewCurrency(WebDriver driver)
	{
		clickOnAddCurrency(driver);
		enterCurrency(driver,"Indian Rupee");
		enterMinSal(driver,"30000");
		enterMaxSal(driver,"100000");
		clickOnSaveCurrency(driver);
		verifyCurrencyToas(driver);
	}
	private static void enterCurrency(WebDriver driver, String currenyName) {
		common.typeOnInputId(driver, "payGradeCurrency_currencyName", currenyName);
		driver.findElement(By.id("payGradeCurrency_currencyName")).sendKeys(Keys.ENTER);
		
	}
	
	private static void enterMinSal(WebDriver driver,String minSalary) {
		common.typeOnInputId(driver, "payGradeCurrency_minSalary", minSalary);
	}
	
	private static void enterMaxSal(WebDriver driver,String maxSalary) {
		common.typeOnInputId(driver, "payGradeCurrency_maxSalary", maxSalary);
		
	}
	
	private static void clickOnSaveCurrency(WebDriver driver) {
		common.clickOnButtonId(driver, "btnSaveCurrency");
	}
	
	private static void verifyCurrencyToas(WebDriver driver) {
		common.verifyToastMessage(driver, "//*[@id=\'currency\']/div[2]/div", "Successfully Saved");
	}
	
	

}
