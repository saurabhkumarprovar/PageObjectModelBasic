package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {
    public CRMHomePage gotoCRM(){
    	//driver.findElement(By.xpath("//div[text()='CRM']")).click();
    	click("CRMAppBtn_XPATH");
    	return new CRMHomePage();
    }
 public void gotoBooks(){
    	
    }
 public void gotoCalendar(){
 	
 }
 public void gotoConnect(){
	 	
 }
 public void gotoDesk(){
	 	
 }
}
