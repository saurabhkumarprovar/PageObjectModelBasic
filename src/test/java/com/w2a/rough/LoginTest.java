package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsHomePage;
import com.w2a.pages.crm.accounts.CreateAccountPage;

public class LoginTest {
	public static void main(String args[]) {
		HomePage home = new HomePage();
		LoginPage login=home.goToSignIn();
		ZohoAppPage zohoApp=login.goToEnterCredentials("saurabhkumarrajput21@gmail.com", "PasswordOfZoho");
		zohoApp.gotoCRM();
		AccountsHomePage ahp=Page.menu.gotToAccounts();
		CreateAccountPage cap = ahp.goToCreateAccount();
		cap.createAccount();
	
	}
 
 
}
