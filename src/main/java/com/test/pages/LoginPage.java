package com.test.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.test.testbase.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath = "//img[@src='./themes/default/images/logo_frontaccounting.png']")
	@CacheLookup
	 WebElement freeAccountingLogo;

	@FindBy(name = "user_name_entry_field")
	WebElement et_username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement et_password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_submit;

	By incorrectPassword = By.xpath("//body//center//font//b[contains(text(),'Incorrect Password')]");

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean frontAccountinglogotest() {
		return freeAccountingLogo.isDisplayed();
	}

	public String loginTitleTest() {
		return driver.getTitle();
	}

	public String loginDropDown() {
		Select project = new Select(driver.findElement(By.name("company_login_name")));
		
		project.selectByVisibleText("FrontAccounting");
		return driver.getTitle();
	}

	public HomePage loginPageData(String uname, String passw) {

		et_username.sendKeys(uname);
		et_password.sendKeys(passw);
		btn_submit.click();
		return new HomePage();

	}
}

	