package com.test.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestUtils {
	public static long PAGE_LOAD_TIMEOUT = 77;
	public static long IMPLICITLY_WAIT_TIMEOUT = 15;
	public static String TESTDATA_SHEET_PATH = "I:\\All eclipse Code7\\FrontAccounting\\"
			+ "src\\main\\java\\com\\test\\testdata\\Front_Accounting_XLSheet.xlsx";

	static Workbook book;
	static Sheet sheet;
	static WebDriver driver;
	// -------------for extent report and screenshot----------------------
	/*
	 * public static ExtentReports extent; public static ExtentTest test; public
	 * ITestResult result;
	 * 
	 * static { Calendar calendar = Calendar.getInstance(); SimpleDateFormat
	 * formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); extent = new
	 * ExtentReports(System.getProperty("user.dir") +
	 * "/src/main/java/com/hybridFramework/report/test" +
	 * formater.format(calendar.getTime()) + ".html", false); }
	 */
	// -------------for extent report and screenshot----------------------

	// ---------------Xl Sheet read--------------------
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	// -------------for extent report and screenshot----------------------
	/*
	 * public String getScreenShot(String imageName) throws IOException {
	 * 
	 * if (imageName.equals("")) { imageName = "blank"; } File image =
	 * ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); String
	 * imagelocation = System.getProperty("user.dir") +
	 * "/src/main/java/com/hybridFramework/screenshot/"; Calendar calendar =
	 * Calendar.getInstance(); SimpleDateFormat formater = new
	 * SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); String actualImageName =
	 * imagelocation + imageName + "_" + formater.format(calendar.getTime()) +
	 * ".png"; File destFile = new File(actualImageName); FileUtils.copyFile(image,
	 * destFile); return actualImageName; }
	 * 
	 * public void getresult(ITestResult result) throws IOException { if
	 * (result.getStatus() == ITestResult.SUCCESS) {
	 * 
	 * test.log(LogStatus.PASS, result.getName() + " test is pass"); } else if
	 * (result.getStatus() == ITestResult.SKIP) { test.log(LogStatus.SKIP,
	 * result.getName() + " test is skipped and skip reason is:-" +
	 * result.getThrowable()); } else if (result.getStatus() == ITestResult.FAILURE)
	 * { test.log(LogStatus.FAIL, result.getName() + " test is failed" +
	 * result.getThrowable()); String screen = getScreenShot("");
	 * test.log(LogStatus.FAIL, test.addScreenCapture(screen)); } else if
	 * (result.getStatus() == ITestResult.STARTED) { test.log(LogStatus.INFO,
	 * result.getName() + " test is started"); } }
	 * 
	 * @AfterMethod() public void afterMethod(ITestResult result) throws IOException
	 * { getresult(result); }
	 * 
	 * @BeforeMethod() public void beforeMethod(Method result) { test =
	 * extent.startTest(result.getName()); test.log(LogStatus.INFO, result.getName()
	 * + " test Started"); }
	 * 
	 * @AfterClass(alwaysRun = true) public void endTest() { // driver.quit();
	 * extent.endTest(test); extent.flush(); }
	 */
	// -------------for extent report and screenshot----------------------

	// --------------for screenshot-------------------
	

	// --------------for screenshot-------------------------

}
