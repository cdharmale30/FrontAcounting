package com.test.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.pages.CustomersPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.testbase.TestBase;
import com.test.testutils.DropDownHelper;
import com.test.testutils.ExcelDataRead;
import com.test.testutils.TestUtils;

public class CustomerPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	CustomersPage customersPage;
	ExcelDataRead exceldataRead;

	public CustomerPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		customersPage = new CustomersPage();
		homePage = loginPage.loginPageData(prop.getProperty("username"),prop.getProperty("password"));
		customersPage = homePage.clickOnAddManageCustomers();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
	
	@Test(priority = 1)
	public void dropDownCustomerPage() {
		customersPage.clickOnDropDown();
	}
	@Test(priority = 2)
	public void backBtnTest() {
		customersPage.btn_back_customer_page();
	}
	
}
