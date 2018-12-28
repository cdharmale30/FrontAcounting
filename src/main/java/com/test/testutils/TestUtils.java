package com.test.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class TestUtils {
	public static long PAGE_LOAD_TIMEOUT = 77;
	public static long IMPLICITLY_WAIT_TIMEOUT = 15;
	public static String TESTDATA_SHEET_PATH = "I:\\All eclipse Code7\\FrontAccounting\\"
			+ "src\\main\\java\\com\\test\\testdata\\Front_Accounting_XLSheet.xlsx";

	static Workbook book;
	static Sheet sheet;
	static WebDriver driver;

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

	// ---------------Xl Sheet read--------------------

	// --------------Screen shot Code--------------------
	public  void failed() throws IOException {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshotFile, new File("I:\\All eclipse Code7\\FrontAccounting\\screenshot\\"+"failed_"+this.getClass().getName()+"_"+".jpg"));
	}
	
	// --------------Screen shot Code--------------------

}
