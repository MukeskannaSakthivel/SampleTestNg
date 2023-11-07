package org.task;

import org.base.BaseClass;
import org.pojoadact.AdactHome;
import org.testng.annotations.DataProvider;

public class DPClass extends BaseClass {
	@DataProvider(name="Details")
	public String[][] hotelData(){
		
		return new String[][] {
			{"New York","Hotel Hervey","Deluxe","4","09/09/2023","14/09/2023","3","0"},
			{"London","Hotel Sunshine","Standard","2","10/10/2023","12/10/2023","2","1"}
		};
	}
	
	@DataProvider(name="Login")
	public String[][] loginData(){
		
		return new String[][] {
			{"mukes5890","mukes@5890"},
			{"vaithy2410","vaithy@2410"}
		};
	}
	@DataProvider(name="PersonalDetails")
	private String[][] personalData() {

		return new String[][] {
			{ "Mukes", "Sakthi", "Erode", "3742454554001261", "VISA", "3", "2029", "123" },
			{ "Ravi", "Kumar", "Bhavani", "3742454554001261", "MAST", "7", "2022", "456" }
		};
		
		
	}
}
