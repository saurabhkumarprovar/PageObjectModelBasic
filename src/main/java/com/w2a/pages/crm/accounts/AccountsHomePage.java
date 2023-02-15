package com.w2a.pages.crm.accounts;

import org.openqa.selenium.By;

import com.w2a.base.Page;

public class AccountsHomePage extends Page {

	public CreateAccountPage goToCreateAccount() {
		//driver.findElement(By.xpath("//button[@data-zcqa='cv_createbtn']")).click();
		click("createAccountBtn_XPATH");
		return new CreateAccountPage();
	}

	public void goToImportAccount() {

	}
}
