package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.TestNgProjectPage;
import util.BrowserFactory;

public class TestNgProjectTest {

	WebDriver driver;
	TestNgProjectPage testPage;
	String actualCategoryName="Project5";

	@BeforeTest
	public void openUrl() {
		driver = BrowserFactory.init();
		testPage = PageFactory.initElements(driver, TestNgProjectPage.class);
	}

	@Test(priority=1)
	public void validateUserAddsNewCategory() {
		testPage.insertNewCategoryName(actualCategoryName);
		testPage.clickOnAddButtonToInsertNewCategory();
		String bodytext = driver.findElement(By.xpath("//html/body/div[3]")).getText();
		String[] allCategoryNames = bodytext.split(" ");
		String allCategoryNamesWithComma= allCategoryNames.toString().replace(" ", ", ");
		System.out.println(allCategoryNames[allCategoryNames.length-1]);
		String expectedCategoryName=allCategoryNames[allCategoryNames.length-1];
		
		Assert.assertEquals(actualCategoryName, expectedCategoryName, "Category Names are not matching!");
	}

	@Test(priority=3)
	public void validateUserNotAbleToAddDuplicateCategory() {

		testPage.insertNewCategoryName(actualCategoryName);
		testPage.clickOnAddButtonToInsertNewCategory();
		testPage.validateDuplicatedCategoryName();
	}

	@Test(priority=2)
	public void validateAllMonthsNamesExistsInDueDropDown() {

		testPage.getAllMonthsFromDropDown();
	}

	@AfterTest
	public void closeBrowser() {
		BrowserFactory.tearDown();
	}
}
