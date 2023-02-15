package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.Page;

public class HomePage extends Page {
	
	public void goToSignUp() {
		
	}
	
	public LoginPage goToSignIn() {
		//driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		click("signInbtn_XPATH");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LoginPage();
	}
	public void goToSupport() {
		
		
	}
	public void goToZohoEdu() {
		
	}
	public void goToLearnMore() {
		
	}
	public void validateFooterLinks() {
		
	}

}
