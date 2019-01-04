package com.test.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.testbase.TestBase;
import com.test.testutils.ScrollPage;

public class HomePage extends TestBase {



	@FindBy(xpath = "//a[contains(text(),'urchases')]")
	WebElement purchasesLink;

	@FindBy(xpath = "//a[contains(text(),'tems and Inventory')]")
	WebElement temsandInventoryLink;

	@FindBy(xpath = "//a[contains(text(),anufacturing)]")
	WebElement manufacturingLink;

	@FindBy(xpath = "//a[contains(text(),'ixed Assets')]")
	WebElement fixedAssetLink;

	@FindBy(xpath = "//a[contains(text(),'Sales T')]")
	WebElement salesTypesLink;

	@FindBy(xpath = "//a[@href='./sales/manage/sales_people.php?']")
	WebElement salesPersonsLink;

	@FindBy(xpath = "//a[@href='./sales/manage/customers.php?']")
	WebElement customersLink;
	//
	@FindBy(xpath = "//a[@href='./sales/sales_order_entry.php?NewQuotation=Yes']")
	WebElement sales_Quotation_Entry;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public PurchasePage clickOnPurchasesLink() {
		purchasesLink.click();
		ScrollPage.scrollingToBottomofPage();
		return new PurchasePage();

	}

	public TestAndInventoryPage clickOnTestAndInventoryLink() {
		temsandInventoryLink.click();
		return new TestAndInventoryPage();
	}

	public ManufacturingPage clickOnManufacturingPageLink() {
		manufacturingLink.click();
		return new ManufacturingPage();
	}

	public FixedAssetLinkPage clickOnFixedAssetLinkLink() {
		fixedAssetLink.click();
		return new FixedAssetLinkPage();
	}

	public SalesTypesPage clickOnSalesTypesPage() {
		salesTypesLink.click();
		return new SalesTypesPage();
	}

	public SalesPersonsPage clickOnSalesPersonsPage() {
		salesPersonsLink.click();
		return new SalesPersonsPage();
	}

	public CustomersPage clickOnAddManageCustomers() {
		customersLink.click();
		return new CustomersPage();
	}

	public SalesQuotationEntryPage clickOnSalesQuotationEntryPage() {
		sales_Quotation_Entry.click();
		return new SalesQuotationEntryPage();
	}
}
