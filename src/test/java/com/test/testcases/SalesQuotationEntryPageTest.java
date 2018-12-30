package com.test.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.pages.CustomersPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.pages.SalesQuotationEntryPage;
import com.test.testbase.TestBase;
import com.test.testutils.ExcelDataRead;
import com.test.testutils.TestUtils;

public class SalesQuotationEntryPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	SalesQuotationEntryPage salesQuotationEntryPage;
	ExcelDataRead exceldataRead;

	public SalesQuotationEntryPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		salesQuotationEntryPage = new SalesQuotationEntryPage();
		homePage = loginPage.loginPageData(prop.getProperty("username"), prop.getProperty("password"));
		salesQuotationEntryPage = homePage.clickOnSalesQuotationEntryPage();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@Test(priority = 1)
	public void dropDownCustomerPage() {
		salesQuotationEntryPage.clickOnDropDown();
	}

	@Test(priority = 2)
	public void dropDownCustomerPageCalender() {
		salesQuotationEntryPage.clickOn_Quotation_Date();
	}
	
	@Test(priority = 3)
	public void dropDown_Branch() {
		salesQuotationEntryPage.clickOn_branch();
	}

	@Test(priority = 4)
	public void dropDown_Select_Item() {
		salesQuotationEntryPage.dropDwon_selectItem();
	}

	@Test(priority = 5)
	public void select_Itemtest() {
		salesQuotationEntryPage.entre_Quality();
	}

	@Test(priority = 6)
	public void enter_Price_After_Tax_Test() {
		salesQuotationEntryPage.enter_Price_Before_Tax();
	}
	

	@Test(priority = 7)
	public void verify_btn_AddItem() {
		salesQuotationEntryPage.clickOnAddItem();
	}
	
	@Test(priority = 8)
	public void dropDown_select_LoactionTest() {
		salesQuotationEntryPage.dropDown_SelectLoaction();
	}
	
	@Test(priority = 9)
	public void verify_btn_Place_Quotation() {
		salesQuotationEntryPage.clickOnPlaceQuotation();
	}

}