package com.test.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

	@FindBy(xpath = "//input[@name='show_inactive']")
	WebElement cb_shows_inactive_Entries;

	@FindBy(xpath = "//div[contains(text(),'New sales type has been added')]")
	WebElement salesType_EntryAdded;
	//

	@FindBy(xpath = "//button[@name='Edit5']")
	WebElement btn_Edit_Sales_Type;

	@FindBy(xpath = "//a[contains(text(),'Back')]")
	WebElement btn_back;
	
	@FindBy(xpath = "//button[@id='UPDATE_ITEM']")
	WebElement btn_Update;
	
	
	@FindBy(xpath = "//div[contains(text(),'Selected sales type has been updated')]")
	WebElement text_Updated_Msg;
	
	//button[@name='Delete156']
	@FindBy(xpath = "//button[@name='Delete173']")
	WebElement btn_DeleteSalesType;
	
	public SalesTypesPage() {
		PageFactory.initElements(driver, this);
	}

	public String checkSalesTypePageTitle() {
		return driver.getTitle();
	}

	public SalesTypesPage salesTypeData(String salestype, String cfactor) throws IOException {
		salesTypeName.sendKeys(salestype);
		calculationFactor.sendKeys(cfactor);
		chekBoxSalestype.click();
		btnAddNew.click();
		return new SalesTypesPage();
	}

	public boolean cb_inactiveEntries() {
		cb_shows_inactive_Entries.click();
		return cb_shows_inactive_Entries.isSelected();
	}

	public boolean saleTypeEntryAdded() {
		return salesType_EntryAdded.isDisplayed();
	}

	public String editSaleTypeName() {
		btn_Edit_Sales_Type.click();
		salesTypeName.sendKeys("IndiaMart");
		calculationFactor.sendKeys("5.8");
		btn_Update.click();
		return text_Updated_Msg.getText();
	}

	public HomePage btn_back() {
		btn_back.click();
		return new HomePage();
	}
	
	public SalesTypesPage btn_delete_sales_types() {
		btn_DeleteSalesType.click();
		return new SalesTypesPage();
	}
}
