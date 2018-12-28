package com.test.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.pages.FixedAssetLinkPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.pages.ManufacturingPage;
import com.test.pages.PurchasePage;
import com.test.pages.SalesTypesPage;
import com.test.pages.TestAndInventoryPage;
import com.test.testbase.TestBase;
import com.test.testutils.TestUtils;

public class SalesTypesPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	SalesTypesPage salesTypesPage;

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

		salesTypesPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

	@Test
	public void verifySalesTypesTittle() {
		String salesTypesPageText = salesTypesPage.checkSalesTypePageTitle();
		Assert.assertEquals(salesTypesPageText, "Sales Types");

	}
	@Test
	public void verifySalesTypeName() {
		
	
	}

}
