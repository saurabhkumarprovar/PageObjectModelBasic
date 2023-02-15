package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static String browser;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static TopMenu menu;

	public Page() {
		if (driver == null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (config.getProperty("browser").equals("chrome")) {
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);

			} else if (config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.debug("Driver launched");
			}
			driver.get(config.getProperty("siteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			menu = new TopMenu(driver);

		}
		

	}

	public void click(String locator) {
		if ((locator).endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if ((locator).endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}

		//test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public void type(String locator, String value) {
		if ((locator).endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if ((locator).endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}

		//test.log(LogStatus.INFO, "Setting value " + value + " to " + locator);
	}

	public WebElement dropdown;

	public void select(String locator, String value) {
		if ((locator).endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		} else if ((locator).endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		//test.log(LogStatus.INFO, "Setting value " + value + " to " + locator);
	}
	public static void quit() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
