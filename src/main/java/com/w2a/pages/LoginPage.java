package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.Page;

public class LoginPage extends Page {
public ZohoAppPage goToEnterCredentials(String userName, String passWord)
{
	//driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys(userName);
	type("usernametext_XPATH",userName);
	//driver.findElement(By.xpath("//button[@class='btn blue'][@id='nextbtn']")).click();
	click("nextBtn_XPATH");
	//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(passWord);
	type("passwordtext_XPATH",passWord);
	//driver.findElement(By.xpath("//button[@class='btn blue'][@id='nextbtn']")).click();
	click("nextBtn_XPATH");
	return new ZohoAppPage();
}
public void goToLearnMore()
{
	
}
public void goToForgotPassword()
{
	
}
}
