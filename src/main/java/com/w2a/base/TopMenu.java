package com.w2a.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.pages.crm.accounts.AccountsHomePage;

public class TopMenu {
	public WebDriver driver;

	public TopMenu(WebDriver driver) {

		this.driver = driver;
	}

	public void gotToHome() {

	}

	public void gotToLeads() {

	}

	public void gotToContacts() {

	}

	public AccountsHomePage gotToAccounts() {
		Page page=new Page();
		// Page.driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		page.click("MenuAccountBtn_XPATH");
		driver.findElement(By.xpath("//a[text()='Accounts']")).click();
		return new AccountsHomePage();
		//driver.quit();
	}

	public void gotToDeals() {

	}

	public void gotToTasks() {

	}

	public void gotToMeetings() {

	}

	public void gotToServices() {

	}

	public void signOut() {

	}
}
