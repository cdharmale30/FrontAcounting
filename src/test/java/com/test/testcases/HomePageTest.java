package com.test.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.pages.FixedAssetLinkPage;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.pages.ManufacturingPage;
import com.test.pages.PurchasePage;
import com.test.pages.SalesQuotationEntryPage;
import com.test.pages.SalesTypesPage;
import com.test.pages.TestAndInventoryPage;
import com.test.testbase.TestBase;
import com.test.testutils.TestUtils;

public class HomePageTest extends TestBase {
	public static final Logger logger = Logger.getLogger(HomePageTest.class.getName());
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtil;
	PurchasePage purchasePage;
	TestAndInventoryPage testAndInventoryPage;
	ManufacturingPage manufacturingPage;
	FixedAssetLinkPage fixedAssetLinkPage;
	SalesTypesPage salesTypePage;
	SalesQuotationEntryPage salesQuotationEntryPage;

	public HomePageTest() {
		super();
	

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtils();
		loginPage = new LoginPage();
		homePage = loginPage.loginPageData(prop.getProperty("username"), prop.getProperty("password"));
	}

	/*
	 * @Test(priority=1) public static int brokenLinkCount(){ int homePageLinks =
	 * homePage.bro Assert.assertEquals(homePageTitle,
	 * "CRMPRO","Home page title not matched"); }
	 */

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Main Menu", "Home page title not matched");
		logger.info("Verify The Tittle of Page");
	}

	@Test(priority = 2)
	public void verifyPurchaseLinkTest() {

		purchasePage = homePage.clickOnPurchasesLink();
		logger.info("click on Purchase Page");
		
	}

	@Test(priority = 3)
	public void verifytestAndInventoryTest() {
		testAndInventoryPage = homePage.clickOnTestAndInventoryLink();
		logger.info("click on testAndInventoryPage Page");
	}

	@Test(priority = 4)
	public void verifyManufacturingLinkTest() {

		manufacturingPage = homePage.clickOnManufacturingPageLink();
		logger.info("click on Manufacturing Page");
	}

	@Test(priority = 5)
	public void verifyFixedAssetLinkLinkTest() {
		fixedAssetLinkPage = homePage.clickOnFixedAssetLinkLink();
		logger.info("click on FixedAssetLink Page");
	}

	@Test(priority = 6)
	public void clickOnSalesQuotationEntryPage() {
		salesQuotationEntryPage = homePage.clickOnSalesQuotationEntryPage();
	}

	// BrokenLinks

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(15000);
		driver.quit();
	}

}
