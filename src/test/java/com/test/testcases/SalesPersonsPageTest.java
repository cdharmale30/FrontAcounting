package com.test.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.pages.SalesPersonsPage;
import com.test.testbase.TestBase;
import com.test.testutils.ExcelDataRead;
import com.test.testutils.TestUtils;

public class SalesPersonsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	SalesPersonsPage salesPersonsPage;
	ExcelDataRead exceldataRead;

	public SalesPersonsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		salesPersonsPage = new SalesPersonsPage();
		homePage = loginPage.loginPageData(prop.getProperty("username"), prop.getProperty("password"));
		salesPersonsPage = homePage.clickOnSalesPersonsPage();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySalesPersonsTittle() {
		String salesPersonsPageText = salesPersonsPage.checkSalesPersonsPage();
		Assert.assertEquals(salesPersonsPageText, "Sales Persons");

	}

	@DataProvider(name = "salesPersonData")
	public Object[][] loginDataProvider() throws Exception {
		Object[][] data = exceldataRead.getTestData("SalesPersonData");
		return data;

	}

	@Test(priority = 2, dataProvider = "salesPersonData")
	public void salesPersonsPageData(String salesPerson, String provison) throws IOException {
		salesPersonsPage.salesPersonsData(salesPerson, provison);
	}
	@Test(priority = 3)
	public void backBtnTest() {
		salesPersonsPage.btn_back_sales_person();
	}

}
