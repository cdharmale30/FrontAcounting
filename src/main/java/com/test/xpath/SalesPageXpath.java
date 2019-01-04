package com.test.xpath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SalesPageXpath {
	@FindBy(xpath = "//img[@src='./themes/default/images/logo_frontaccounting.png']")
	@CacheLookup
	 WebElement freeAccountingLogo;

	@FindBy(name = "user_name_entry_field")
	WebElement et_username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement et_password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_submit;
	
	@FindBy(xpath = "company_login_name")
	WebElement dropDown_project;
}