package org.deleteafterwards;

import org.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/Alerts.html");
		elementLocatorByXpath("//button[contains(text(),'click the button to display an')]").click();
		//Simple Alert
		Alert a = driver.switchTo().alert();
		Thread.sleep(5000);
		a.accept();
		
		//Confirm Alert
		
		elementLocatorByXpath("//a[text()='Alert with OK & Cancel ']").click();
		
	}
}
