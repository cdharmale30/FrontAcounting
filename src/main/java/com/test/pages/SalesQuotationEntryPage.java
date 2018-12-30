package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.testbase.TestBase;
import com.test.testutils.DropDownHelper;

public class SalesQuotationEntryPage extends TestBase {

	@FindBy(xpath = "//select[@id='customer_id']")
	WebElement select_customer;

	@FindBy(xpath = "//img[@src='../themes/default/images/cal.gif']")
	WebElement quotation_date;

	@FindBy(xpath = "//a[@href='javascript:setCCDate(2018,12,31)']")
	WebElement quotation_date_dropDown;

	@FindBy(xpath = "//select[@id='stock_id']")
	WebElement select_Item;

	@FindBy(xpath = "//input[@name='qty']")
	WebElement select_Quality;

	@FindBy(xpath = "//input[@name='price']")
	WebElement et_select_Price;

	@FindBy(xpath = "//button[@name='AddItem']")
	WebElement btn_AddItem;

	@FindBy(xpath = "//select[@name='Location']")
	WebElement dropDown_selectLocation;

	@FindBy(xpath = "//button[@id='ProcessOrder']")
	WebElement btn_Place_Quotation;
	
	@FindBy(xpath = "//select[@id='branch_id']")
	WebElement dropDown_branch;

	public SalesQuotationEntryPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnDropDown() {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.SelectUsingVisibleText(select_customer, "chetya");
	}

	public void clickOn_Quotation_Date() {
		quotation_date.click();
		quotation_date_dropDown.click();

	}
	
	
	public void clickOn_branch() {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.SelectUsingVisibleText(select_customer, "chetya");
	}
	
	public void clickOnDropDownCalender() {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.SelectUsingVisibleText(dropDown_branch, "mayurg");
	}

	public void dropDwon_selectItem() {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.SelectUsingVisibleText(select_Item, "Pen Drive");
	}

	public void entre_Quality() {
		select_Quality.sendKeys("3");
	}

	public void enter_Price_Before_Tax() {
		et_select_Price.sendKeys("5999");
	}

	public void clickOnAddItem() {
		btn_AddItem.click();
	}

	public void dropDown_SelectLoaction() {
		dropDownHelper = new DropDownHelper(driver);
		dropDownHelper.SelectUsingVisibleText(dropDown_selectLocation, "Pune Karvenagar");
	}

	public NewSalesOrderEntryDetailsPage clickOnPlaceQuotation() {
		btn_Place_Quotation.click();
		return new NewSalesOrderEntryDetailsPage();
	}

	/*public void clickOnPlaceQuotation() {
		btn_Place_Quotation.click();
	}*/
}
