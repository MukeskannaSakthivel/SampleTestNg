package org.task;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.pojoadact.AdactHome;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginClass extends BaseClass {
	
	public AdactHome a;
	public SoftAssert sa;
	//@Parameters({"browser"})
	@BeforeClass()
	private void browser() {

		/*if(browserType.contains("hro")) {
			launchBrowser();
		}
		else if(browserType.equals("edge")) {
			launchEdge();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}*/
		//launchEdge();
		launchBrowser();
		windowMaxi();
		
	}

	
	String url1="";
	//Test Cases for Adactin - Login
	//Passing values from dataprovider present in dpclass, dataprovider name=login
	//soft Assert to check the title
	@Test(dataProvider="Login",dataProviderClass=DPClass.class)
	private void tc1(String user,String pswd) {
		a = new AdactHome();
		sa = new SoftAssert();
		url("http://adactinhotelapp.com/");
		boolean contains = driver.getTitle().contains("abcd");
		sa.assertTrue(contains, "Check Page Title");
		textPass(a.getUsername(), user);
		textPass(a.getPassword(), pswd);
		elementClick(a.getLoginBtn());
		url1=driver.getCurrentUrl();
		sa.assertAll();
	}
	
	//testcase for searching hotel by passing required fields
	//values passing using dataprovider present in dpclass name Details
	
	
	String url2="";
	@Test(dataProvider="Details",dataProviderClass=DPClass.class)
	private void tc2(String location,String hotelName,String roomType,
			String noOfRooms,String checkIn,String checkOut,String noOfAdult,String noOfChild) {
		//tc1(user,pswd );
		a=new AdactHome();
		url(url1);
		selByValue(a.getLocation(), location);
		selByValue(a.getHotels(),hotelName );
		selByValue(a.getRoomType(), roomType);
		selByValue(a.getNoOfRooms(), noOfRooms);
		a.getChechkIn().clear();
		textPass(a.getChechkIn(), checkIn);
		a.getCheckOut().clear();
		textPass(a.getCheckOut(), checkOut);
		selByValue(a.getNoOfAdult(), noOfAdult);
		selByValue(a.getNoOfChild(), noOfChild);
		
		elementClick(a.getSearch());
		url2=driver.getCurrentUrl();
	}
	
	//select hotels and press continue to payment package
	
	String url3="";
	@Test
	private void tc3() {
		
		a = new AdactHome();
		url(url2);
		elementClick(a.getRadioBtn());
		elementClick(a.getCont());
		url3 = driver.getCurrentUrl();
	
	}
	
	//passing personal details 
	
	@Test(dataProvider="PersonalDetails",dataProviderClass=DPClass.class)
	private void tc4(String firstName,String lastName,String address,String cardNum,
			String cardType,String expMonth,String expYear,String cvv) {

		a=new AdactHome();
		textPass(a.getFirstName(), firstName);
		textPass(a.getLastName(), lastName);
		textPass(a.getAddress(), address);
		textPass(a.getCardNumber(), cardNum);
		selByValue(a.getCardType(), cardType);
		selByValue(a.getMonth(), expMonth);
		selByValue(a.getYear(), expYear);
		textPass(a.getCvv(), cvv);
		elementClick(a.getBookNow());
		
	}
}
