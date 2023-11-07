package org.sampletestng;

import org.testng.annotations.Test;

public class InvoCount extends BaseClass {
	
	@Test(invocationCount=3)
	private void tc() {
		 launchBrowser();
		 windowMaxi();
		 url("https://www.facebook.com/");
		 textPass(elementLocatorById("email"), "java");
		 textPass(elementLocatorById("pass"), "123");
		 elementClick(elementLocatorByName("login"));
	}
}
