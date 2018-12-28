package com.test.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.test.testbase.TestBase;
import com.test.testutils.CustomListener;
@Listeners(CustomListener.class)
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

	public void enterSalesTypeName() {
		salesTypeText.sendKeys("Retail");
	}
	public SalesTypesPage loginPageData(String salesTypes,String calculationfactors ) throws IOException
	{
		salesTypeName.sendKeys(salesTypes);
		calculationFactor.sendKeys(calculationfactors);
		chekBoxSalestype.click();
		btnAddNew.click();
		
		return new SalesTypesPage();
		
	}
	
	

}
