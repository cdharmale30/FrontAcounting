package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.testbase.TestBase;

public class SalesTypesPage extends TestBase {

	
	@FindBy(xpath = "//td[contains(text(),'Sales Types')]")
	WebElement salesTypeText;
	
	//input[@name='sales_type']
	
	@FindBy(xpath = "//input[@name='sales_type']")
	WebElement salesTypeName;

	public SalesTypesPage() {
		PageFactory.initElements(driver, this);
	}

	public String checkSalesTypePageTitle() {

		return driver.getTitle();

	}

	public void enterSalesTypeName() {
		salesTypeText.sendKeys("Retail");
	}

}
