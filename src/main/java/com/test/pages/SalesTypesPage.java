package com.test.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.test.testbase.TestBase;

public class SalesTypesPage extends TestBase {

	
	@FindBy(xpath = "//td[contains(text(),'Sales Types')]")
	WebElement salesTypeText;
	
	
	@FindBy(xpath = "//input[@name='sales_type']")
	WebElement salesTypeName;
	
	@FindBy(xpath = "//input[@name='factor']")
	WebElement calculationFactor;
	
	@FindBy(xpath = "//input[@name='tax_included']")
	WebElement chekBoxSalestype;
	
	@FindBy(xpath = "//button[@name='ADD_ITEM']")
	WebElement btnAddNew;

	public SalesTypesPage() {
		PageFactory.initElements(driver, this);
	}

	public String checkSalesTypePageTitle() {

		return driver.getTitle();

	}

	public SalesTypesPage salesTypeData(String salestype,String cfactor ) throws IOException
	{
		salesTypeName.sendKeys(salestype);
		calculationFactor.sendKeys(cfactor);
		chekBoxSalestype.click();
		btnAddNew.click();
		
		return new SalesTypesPage();
		
	}

	
	

}
