package org.pojoadact;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactHome extends BaseClass {
	
	public AdactHome() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	@FindBy(name="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotels;
	
	@FindBy(id="room_type")
	private WebElement roomType;
	
	@FindBy(id="room_nos")
	private WebElement noOfRooms;
	
	@FindBy(id="datepick_in")
	private WebElement chechkIn;
	
	@FindBy(id="datepick_out")
	private WebElement checkOut;
	
	@FindBy(id="adult_room")
	private WebElement noOfAdult;
	
	@FindBy(id="child_room")
	private WebElement noOfChild;
	
	@FindBy(id="Submit")
	private WebElement search;
	
	@FindBy(id="radiobutton_0")
	private WebElement radioBtn;
	
	@FindBy(id="continue")
	private WebElement cont;
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement cardNumber;
	
	@FindBy(id="cc_cvv")
	private WebElement cvv;
	
	@FindBy(id="cc_type")
	private WebElement cardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement month;
	
	@FindBy(id="cc_exp_year")
	private WebElement year;
	
	@FindBy(id="book_now")
	private WebElement bookNow;
	
	@FindBy(name="order_no")
	private WebElement orderNo;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getChechkIn() {
		return chechkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getNoOfAdult() {
		return noOfAdult;
	}

	public WebElement getNoOfChild() {
		return noOfChild;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getCont() {
		return cont;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}
	
	
	
	
	
}
