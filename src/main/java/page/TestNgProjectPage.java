package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestNgProjectPage{

	WebDriver driver;
	String insertedCategoryName;
	
	public TestNgProjectPage(WebDriver driver) {
		driver = this.driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']") WebElement ADD_CATEGORY_INPUT_BOX_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @value='Add category']") WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']") WebElement MONTHS_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//html/body/div[3]") WebElement ALL_CATAGORIES_BODY_TEXT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//html/body") WebElement DUPLICATED_CATEGORY_BODY_TEXT_ELEMENT;
		
	/*** Method to insert category name ***/
	public void insertNewCategoryName(String categoryName) {
		insertedCategoryName=categoryName;
		ADD_CATEGORY_INPUT_BOX_ELEMENT.sendKeys(insertedCategoryName);
	}

	/*** Method to click on add button ***/
	public void clickOnAddButtonToInsertNewCategory() {
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}
	
	/*** Method to print all months names from Due Date drop down ***/
	public void getAllMonthsFromDropDown() {
		Select select=new Select(MONTHS_DROPDOWN_ELEMENT);
		 List<WebElement> dropDownAllOptions=select.getOptions();

		 // Loop to print all drop down options one by one
		 List<String> strings = new ArrayList<String>();
		    for (int j = 1; j < dropDownAllOptions.size(); j++) {
		        System.out.print(dropDownAllOptions.get(j).getText()+", ");
		    }
	}
	
	/*** Method to validate duplicated category name ***/
	public void validateDuplicatedCategoryName() {
		Assert.assertNotEquals(insertedCategoryName, DUPLICATED_CATEGORY_BODY_TEXT_ELEMENT.getText());
	}
	
	
	
	
	
}
