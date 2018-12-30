package com.test.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.test.pages.FixedAssetLinkPage;
import com.test.pages.HomePage;

import com.test.pages.LoginPage;
import com.test.pages.ManufacturingPage;
import com.test.pages.PurchasePage;
import com.test.pages.SalesTypesPage;
import com.test.pages.TestAndInventoryPage;
import com.test.testbase.TestBase;
import com.test.testutils.CustomListener;
import com.test.testutils.ExcelDataRead;
import com.test.testutils.TestUtils;
public class SalesTypesPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	SalesTypesPage salesTypesPage;
	ExcelDataRead exceldataRead;

	public SalesTypesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		salesTypesPage = new SalesTypesPage();
		homePage = loginPage.loginPageData(prop.getProperty("username"), prop.getProperty("password"));
		salesTypesPage = homePage.clickOnSalesTypesPage();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySalesTypesTittle() {
		String salesTypesPageText = salesTypesPage.checkSalesTypePageTitle();
		Assert.assertEquals(salesTypesPageText, "Sales ypes");

	}


	@DataProvider(name="loginData")
	public Object[][] loginDataProvider() throws Exception{
		Object[][] data = exceldataRead.getTestData("SalesTypes");
		return data;
	
	}
	
	@Test(priority=2,dataProvider="loginData")
	public void salesTypesPageData(String sale,String factor ) throws IOException{			
		salesTypesPage.salesTypeData(sale, factor);
		boolean transportEntry = salesTypesPage.saleTypeEntryAdded();
		Assert.assertTrue(transportEntry);
	}
	
	@Test(priority = 3)
	public void cb_verifyCheckboxTest() {
		boolean cb_selected = salesTypesPage.cb_inactiveEntries();
		Assert.assertTrue(cb_selected);
	}
	
	@Test(priority = 4)
	public void btn_edit_verify_Sales_Types() {
		String updatedMsg=salesTypesPage.editSaleTypeName();
	Assert.assertEquals(updatedMsg, "Selected sales type has been updated");
	}
	
	@Test(priority = 5)
	public void backBtnTest() {
		salesTypesPage.btn_back();
	}
	
	@Test(priority = 6)
	public void btn_delete_SalesType() {
		salesTypesPage.btn_delete_sales_types();
	}
}
