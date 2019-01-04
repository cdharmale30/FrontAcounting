package com.test.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.test.testutils.DropDownHelper;
import com.test.testutils.TestUtils;
import com.test.testutils.WebEventListener;

public class TestBase {
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());

	public static WebDriver driver;
	public static Properties prop;
	public static WebElement element;

	public static Workbook book;
	public static Sheet sheet;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public DropDownHelper dropDownHelper;

	public TestBase() {

		prop = new Properties();
		FileInputStream fis;
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		try {
			fis = new FileInputStream(
					("I:\\All eclipse Code7\\FrontAccounting\\src\\main\\java\\com\\test\\config\\config.properties"));
			prop.load(fis);
			logger.info("loading config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		System.setProperty("webdriver.chrome.driver",
				"I:\\All eclipse Code7\\FrontAccounting\\EXE_Files\\chromedriver.exe");
		driver = new ChromeDriver();
		/*
		 * String browsername = properti.getProperty("browser");
		 * 
		 * if (browsername.equalsIgnoreCase("Firefox")) { driver = new FirefoxDriver();
		 * 
		 * } else if (browsername.equalsIgnoreCase("Chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "I:\\All eclipse Code7\\FrontAccounting\\EXE_Files\\chromedriver.exe");
		 * driver = new ChromeDriver();
		 * 
		 * }
		 */
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

	// --------------for screenshot-------------------
	public void failed(String methodName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile,
				new File("I:\\All eclipse Code7\\FrontAccounting\\screenshot\\" + methodName + "_" + ".jpg"));
	}

	// --------------for screenshot-------------------------

}