package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.Page;

public class TestUtil extends Page {
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {
		Date d = new Date();

		screenshotName = d.toString().replaceAll(":", "_").replaceAll(" ", "_") + ".jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		int rows=2;
		int cols=3;
		// int rows = excel.getRowCount(sheetName);

		// log.debug("Number of rows " + rows);
		// int cols = excel.getColumnCount(sheetName);

		// log.debug("Number of cols " + cols);

		/*
		 * Object[][] data = new Object[rows - 1][cols];
		 * 
		 * for (int rowNum = 2; rowNum <= rows; rowNum++) {
		 * 
		 * for (int colNum = 0; colNum < cols; colNum++) {
		 * 
		 * data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum); } }
		 */

		Object[][] data = new Object[rows - 1][1];
		Hashtable<String, String> table = null;
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			table = new Hashtable<String, String>();
			for (int colNum = 0; colNum < cols; colNum++) {
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
				
			}
			
		}

		log.debug("Reach end of getData method");
		log.debug(data[0][0]);
		return data;

	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {
		String sheetName = "test_suite";
		// int rows=excel.getRowCount("test_suite");
		int rows = 3;
		for (int rNum = 2; rNum <= rows; rNum++) {
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			if (testCase.equalsIgnoreCase(testName)) {
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
	}
}
