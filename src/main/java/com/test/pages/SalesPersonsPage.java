package com.test.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.testbase.TestBase;

public class SalesPersonsPage extends TestBase{
	@FindBy(xpath = "//td[contains(text(),'Sales Persons')]")
	WebElement SalesPersonsText;
	
	@FindBy(xpath = "//input[@name='salesman_name']")
	WebElement salesPersonName;
	
	//provision
	@FindBy(name = "provision")
	WebElement provisionSalesPersons;
	
	@FindBy(name = "ADD_ITEM")
	WebElement addItemSalesPersons;
	//btn_back_salespersons

	@FindBy(name = "ADD_ITEM")
	WebElement btn_back_salespersons;
	
	public SalesPersonsPage() {
		PageFactory.initElements(driver, this);
	}

	public String checkSalesPersonsPage() {
		return driver.getTitle();
	}

	/*public SalesTypesPage salesTypeData(String salestype, String cfactor) throws IOException {
		salesTypeName.sendKeys(salestype);
		calculationFactor.sendKeys(cfactor);
		chekBoxSalestype.click();
		btnAddNew.click();
		return new SalesTypesPage();
	}
*/
	
	public SalesTypesPage salesPersonsData(String salesPersonNamePage, String provisionSalesPersonsPage) throws IOException {
		salesPersonName.sendKeys(salesPersonNamePage);
		provisionSalesPersons.sendKeys(provisionSalesPersonsPage);
		addItemSalesPersons.click();
		return new SalesTypesPage();
	}
	public HomePage btn_back_sales_person() {
		btn_back_salespersons.click();
		return new HomePage();
	}
	
}
