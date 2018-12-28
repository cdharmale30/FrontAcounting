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

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtil;
	PurchasePage purchasePage;
	TestAndInventoryPage  testAndInventoryPage;
	ManufacturingPage    manufacturingPage  ;  
	FixedAssetLinkPage fixedAssetLinkPage;
	SalesTypesPage salesTypePage;
	
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
	}

	@Test(priority = 2)
	public void verifyPurchaseLinkTest() {

		purchasePage = homePage.clickOnPurchasesLink();
	}
	
	@Test(priority=3)
	public void verifytestAndInventoryTest(){
		
		testAndInventoryPage = homePage.clickOnTestAndInventoryLink();
	
	}
	
	@Test(priority=4)
	public void verifyManufacturingLinkTest(){
		
		manufacturingPage = homePage.clickOnManufacturingPageLink();
	}
	
	@Test(priority=5)
	public void verifyFixedAssetLinkLinkTest() {
		fixedAssetLinkPage=homePage.clickOnFixedAssetLinkLink();
	}

	

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(15000);
		driver.quit();
	}

}
