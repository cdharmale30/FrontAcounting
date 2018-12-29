package com.test.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.testbase.TestBase;
import com.test.testutils.DropDownHelper;

public class CustomersPage extends TestBase {

	//input[@name='CustName']

	@FindBy(xpath = "//input[@name='CustName']")
	WebElement et_customer_full_name;
	
	
	@FindBy(xpath = "//a[contains(text(),'Back')]")
	WebElement btn_back_customer_page;

	
	
	@FindBy(xpath = "//select[@id='curr_code']")
	WebElement dropDownCustomerPage;
	

	public CustomersPage() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * public SalesTypesPage salesTypeData(String salestype, String cfactor) throws
	 * IOException { salesTypeName.sendKeys(salestype);
	 * calculationFactor.sendKeys(cfactor); chekBoxSalestype.click();
	 * btnAddNew.click(); return new SalesTypesPage(); }
	 */
	
	public void clickOnDropDown() {
		dropDownHelper= new DropDownHelper(driver);
		dropDownHelper.SelectUsingVisibleText(dropDownCustomerPage, "Pounds");
	}
	
	public HomePage btn_back_customer_page() {
		btn_back_customer_page.click();
		return new HomePage();
	}
}
