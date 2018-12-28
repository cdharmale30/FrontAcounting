package com.test.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import com.test.testbase.TestBase;
import com.test.testutils.TestUtils;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	public static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());

	public static String sheetName = "LoginData";

	public LoginPageTest() {
		super();
		logger.info("Initialize the Super Constructor");

	}

	@BeforeMethod
	public void setup() {
		initialization();

		testUtils = new TestUtils();

		loginPage = new LoginPage();

	}

	@Test(priority = 1)
	public void loginTitleTest() {
		String loginPageTitle = loginPage.loginTitleTest();
		Assert.assertEquals(loginPageTitle, "FrontAccounting 2.4.2 - Login");
		logger.info("Verify the Login page Tittle");

	}

	@Test(priority = 2)
	public void frontAccountinglogotest() {
		boolean logoPresent = loginPage.frontAccountinglogotest();
		Assert.assertTrue(logoPresent);
		logger.info("verify the logo on loginpage");

	}

	/*
	 * @DataProvider(name = "loginData") public Object[][] loginDataProvider()
	 * throws Exception {
	 * 
	 * Object[][] data = testUtils.getTestData(sheetName); return data;
	 * 
	 * }
	 * 
	 * @Test(priority = 2, dataProvider = "loginData") public void
	 * LoginPageDataTest(String username, String password) throws IOException {
	 * 
	 * loginPage.loginPageData(username, password);
	 * logger.info("enter invalid and valid credintials");
	 * 
	 * }
	 */

	@Test(priority = 3)
	public void dropDownTest() {
		loginPage.dropDown();
		logger.info("click on drowpdown page on login");

	}

	@Test(priority = 4)
	public void loginPageDataTest() {

		homePage = loginPage.loginPageData(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(15000);
		driver.quit();
	}
}