package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.utilities.TestUtil;

public class LoginTest extends BaseTest {
@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
public void loginTest(Hashtable<String,String> data) {
	HomePage home = new HomePage();
	LoginPage login=home.goToSignIn();
	ZohoAppPage zohoApp=login.goToEnterCredentials(data.get("username"), data.get("password"));
}
}
