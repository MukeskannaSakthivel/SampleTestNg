 package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.gson.FieldAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static FileInputStream fi;
	public static Workbook book;
	public static File f;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static Select s;
	public static FileOutputStream fo;
	public static Robot r;


	//--> To Perform Select All
	public static void selectAllText() {
		try {
			r = new Robot();
		} catch (AWTException e) {}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	//---> Select by Index from dropdown

	public static void selByIndex(WebElement ele , int index) {
		s=new Select(ele);
		s.selectByIndex(index);
	}

	//--> Select by Value from DropDown
	public static void selByValue(WebElement ele, String value) {
		s= new Select(ele);
		s.selectByValue(value);
	}

	// Select by Text from Dropdown
	public static void selByVisibleText(WebElement ele,String text) {
		s = new Select(ele);
		s.selectByVisibleText(text);
	}

	// to create Excel sheet
	public static void createExcelSheet(String name,String sheetName)  {
		f = new File("src\\test\\resources\\sheet\\"+name+".xlsx");

		book = new XSSFWorkbook();
		book.createSheet(sheetName);
		try {
			fo = new FileOutputStream(f);
		} catch (FileNotFoundException e1) {}
		try {
			book.write(fo);
		} catch (IOException e) {}

	}

	//to insert value
	public static void insertInto(String name,String sheetName,int rowNo,int cellNo,String data) {
		f= new File("src\\test\\resources\\sheet\\"+name+".xlsx");

		try {
			fi=new FileInputStream(f);
		} catch (FileNotFoundException e) 	{}
		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		cell.setCellValue(data);
		try {
			fo= new FileOutputStream(f);
		} catch (FileNotFoundException e) {}
		try {
			book.write(fo);
		} catch (IOException e) {}
	}

	//to fetch no of rows in sheet
	public static int noOfRows(String name,String sheetName) {
		f = new File("src\\test\\resources\\sheet\\"+name+".xlsx");

		try {
			fi=new FileInputStream(f);
		} catch (FileNotFoundException e) {}
		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {}
		Sheet sheet = book.getSheet(sheetName);
		return  sheet.getPhysicalNumberOfRows();
	}
	
	//To fetch no of cells in a row
	public static int noOfCells(String name, String sheetName, int rowNo) {
		f = new File("src\\test\\resources\\sheet\\"+name+".xlsx");

		try {
			fi=new FileInputStream(f);
		} catch (FileNotFoundException e) {}
		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {}
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		return row.getPhysicalNumberOfCells();
	}
	//to read a data from the excel sheet
	public static String readDataFromExcel(String name, String sheetName, int rowNo, int cellNo)
	{

		//To give file path
		f = new File("C:\\Users\\KALAIVANI\\eclipse-workspace\\Framework\\src\\test\\resources\\sheet\\"+name+".xlsx");
		//To read a data
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
		}

		//Create object for workbook

		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {
		}

		//To fetch a single sheet

		Sheet sheet = book.getSheet(sheetName);

		Row row = sheet.getRow(rowNo);

		Cell cell = row.getCell(cellNo);

		int cellType = cell.getCellType();
		String value = null;
		if(cellType == 1)
		{
			//to get a string value
			value = cell.getStringCellValue();
			//System.out.println(value);
		}
		else if(DateUtil.isCellDateFormatted(cell))
		{
			Date d = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd,MMMM,YYYY");
			value = s.format(s);
			//System.out.println(value);
		}
		else
		{
			double d = cell.getNumericCellValue();
			long l = (long)d;
			value = String.valueOf(l);
			//  System.out.println(value);
		}
		return value;
	}

	//To create rows and cells
	public static void createExcelRowsAndCells(String name,String sheetName,int rowNo,int cellNo,String data) {
		f= new File("src\\test\\resources\\sheet\\"+name+".xlsx");

		if(rowNo == 0 && cellNo == 0) {
			book = new XSSFWorkbook();
			sheet = book.createSheet(sheetName);
			row = sheet.createRow(rowNo);
			cell = row.createCell(cellNo);

		}
		else if(rowNo>=0 && cellNo >0) {
			try {
				fi = new FileInputStream(f);
			} catch (FileNotFoundException e) {}
			try {
				book = new XSSFWorkbook(fi);
			} catch (IOException e) {}
			sheet = book.getSheet(sheetName);
			row=sheet.getRow(rowNo);
			cell = row.createCell(cellNo);
		}
		else if(rowNo>0 && cellNo==0) {
			try {
				fi = new FileInputStream(f);
			} catch (FileNotFoundException e) {}
			try {
				book = new XSSFWorkbook(fi);
			} catch (IOException e) {}
			sheet = book.getSheet(sheetName);
			row = sheet.createRow(rowNo);
			cell = row.createCell(cellNo);
		}
		cell.setCellValue(data);
		try {
			fo = new FileOutputStream(f);
		} catch (FileNotFoundException e) {}
		try {
			book.write(fo);
		} catch (IOException e) {}
	}

	// Wait for 10 seconds
	public static void toWait() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	//to launch the edge browser
	public static void launchEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	
	//to launch the chrome browser
	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	//to pass the url
	public static void url(String url) {
		driver.get(url);
	}

	//to maximize the window
	public static void windowMaxi() {
		driver.manage().window().maximize();
	}

	// sendkeys()
	public static void textPass(WebElement we,String value) {
		we.sendKeys(value);
	}

	//to locate a element by id
	public static WebElement elementLocatorById(String id) {
		return driver.findElement(By.id(id));
	}

	//to locate a element by name
	public static WebElement elementLocatorByName(String name){
		return driver.findElement(By.name(name));
	}

	//to locate a element by className
	public static WebElement elementLocatorByClass(String className) {
		return driver.findElement(By.className(className));
	}

	//to locate a element by xpath
	public static WebElement elementLocatorByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	// to refresh browser
	public static void refresh() {
		driver.navigate().refresh();
	}

	//click()
	public static void elementClick(WebElement ele) {
		ele.click();
	}
}
