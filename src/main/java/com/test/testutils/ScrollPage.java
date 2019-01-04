package com.test.testutils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.test.testbase.TestBase;

public class ScrollPage extends TestBase{

	public static void scrollingToBottomofPage() {
		 ((JavascriptExecutor) driver)
         .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollingToElementofPage() {
		WebElement element = driver.findElement(By.linkText("Import/Export"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
	}
	
	public void scrollingByCoordinatesofPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
	}
	
}


