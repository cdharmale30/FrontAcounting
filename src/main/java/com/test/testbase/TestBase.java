package com.test.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.testutils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebElement element;

	public static Workbook book;
	public static Sheet sheet;

	public TestBase() {

		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(
					("I:\\All eclipse Code7\\FrontAccounting\\src\\main\\java\\com\\test\\config\\config.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver", "I:\\All eclipse Code7\\FrontAccounting\\EXE_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		/*String browsername = properti.getProperty("browser");

		if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();

		} else if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "I:\\All eclipse Code7\\FrontAccounting\\EXE_Files\\chromedriver.exe");
			driver = new ChromeDriver();

		}
*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}